import warnings
import csv
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns
import os
import random
import hashlib
import json
from flask import Flask, render_template, request
from imblearn.over_sampling import SMOTE
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import padding
from cryptography.hazmat.backends import default_backend
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import confusion_matrix, accuracy_score, classification_report, roc_curve, auc
from sklearn.preprocessing import StandardScaler

# Flask app setup
app = Flask(__name__)

# Directory to store uploaded figures
UPLOAD_FOLDER = 'static/plots'
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

# Ensure the plots directory exists
if not os.path.exists(app.config['UPLOAD_FOLDER']):
    os.makedirs(app.config['UPLOAD_FOLDER'])

# Global dictionary to store transaction encryption keys (for simplicity)
transaction_keys = {}


# Function to load fraud detection data
def load_fraud_data():
    # Replace with the correct file path
    data = pd.read_csv('creditcard_sampledata.csv')
    X = data.iloc[:, 2:30].values  # Excluding the first two columns (Time, Amount)
    y = data.Class.values
    return X, y


# Function to plot fraud detection figures
def plot_fraud_detection(X, y):
    plot_paths = []

    # Original Data Plot
    plt.figure(num='Anti-Money Laundering Detection: Original', clear=True)
    plt.scatter(X[y == 0, 0], X[y == 0, 1], label="Class #0", alpha=0.5, linewidth=0.15)
    plt.scatter(X[y == 1, 0], X[y == 1, 1], label="Class #1", alpha=0.5, linewidth=0.15, c='r')
    plt.title("Original Set", fontsize=15)
    plt.legend()
    plot_path = os.path.join(app.config['UPLOAD_FOLDER'], 'original_plot.png')
    plt.savefig(plot_path)
    plt.close()
    plot_paths.append(plot_path)

    # SMOTE Resampling
    method = SMOTE()
    X_resampled, y_resampled = method.fit_resample(X, y)

    plt.figure(num='Anti-Money Laundering Detection: Resampled', clear=True)
    plt.scatter(X_resampled[y_resampled == 0, 0], X_resampled[y_resampled == 0, 1], label="Class #0", alpha=0.5,
                linewidth=0.15)
    plt.scatter(X_resampled[y_resampled == 1, 0], X_resampled[y_resampled == 1, 1], label="Class #1", alpha=0.5,
                linewidth=0.15, c='r')
    plt.title("Resampled Set", fontsize=15)
    plt.legend()
    plot_path = os.path.join(app.config['UPLOAD_FOLDER'], 'resampled_plot.png')
    plt.savefig(plot_path)
    plt.close()
    plot_paths.append(plot_path)

    return plot_paths


# Function to handle transactions (simplified)
def generate_key():
    return hashlib.sha256(str(random.getrandbits(256)).encode()).digest()


def encrypt_data(data, key):
    iv = random.getrandbits(128).to_bytes(16, byteorder='big')
    cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend())
    encryptor = cipher.encryptor()
    padder = padding.PKCS7(128).padder()
    padded_data = padder.update(data.encode()) + padder.finalize()
    encrypted_data = encryptor.update(padded_data) + encryptor.finalize()
    return iv + encrypted_data


def decrypt_data(encrypted_data, key):
    iv = encrypted_data[:16]
    ciphertext = encrypted_data[16:]
    cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend=default_backend())
    decryptor = cipher.decryptor()
    unpadder = padding.PKCS7(128).unpadder()
    decrypted_data = decryptor.update(ciphertext) + decryptor.finalize()
    return unpadder.update(decrypted_data) + unpadder.finalize()


# Function to monitor transactions and flag suspicious ones
def monitor_transactions(transaction_log, key, low_threshold=10000, high_threshold=50000):
    decrypted_data = decrypt_data(transaction_log['encrypted_data'], key)
    transaction_data = json.loads(decrypted_data)
    amount = transaction_data['amount']
    if amount <= low_threshold:
        return "Transaction is fraud"
    elif low_threshold < amount <= high_threshold:
        return "Transaction is non-fraud"
    else:
        return "Transaction is fraud"


# Function to read transactions from a CSV file
def read_transactions_from_csv(filename):
    transactions = []
    try:
        with open(filename, mode='r', newline='') as file:
            reader = csv.DictReader(file)
            for row in reader:
                transactions.append({
                    'sender': row['sender'],
                    'receiver': row['receiver'],
                    'amount': float(row['amount']),
                })
    except FileNotFoundError:
        print("CSV file not found!")
    return transactions


# Function to train the model and evaluate performance
def train_and_evaluate_model(X, y):
    # Split the data into training and testing sets
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    # Feature scaling
    scaler = StandardScaler()
    X_train_scaled = scaler.fit_transform(X_train)
    X_test_scaled = scaler.transform(X_test)

    # Train a RandomForest Classifier
    model = RandomForestClassifier(n_estimators=100, random_state=42)
    model.fit(X_train_scaled, y_train)

    # Predictions
    y_pred = model.predict(X_test_scaled)

    # Evaluation Metrics
    conf_matrix = confusion_matrix(y_test, y_pred)
    accuracy = accuracy_score(y_test, y_pred)
    class_report = classification_report(y_test, y_pred)

    # ROC Curve
    fpr, tpr, _ = roc_curve(y_test, model.predict_proba(X_test_scaled)[:, 1])
    roc_auc = auc(fpr, tpr)

    # Plot ROC Curve
    plt.figure()
    plt.plot(fpr, tpr, color='darkorange', lw=2, label='ROC curve (area = %0.2f)' % roc_auc)
    plt.plot([0, 1], [0, 1], color='navy', lw=2, linestyle='--')
    plt.xlim([0.0, 1.0])
    plt.ylim([0.0, 1.05])
    plt.xlabel('False Positive Rate')
    plt.ylabel('True Positive Rate')
    plt.title('Receiver Operating Characteristic')
    plt.legend(loc='lower right')
    roc_plot_path = os.path.join(app.config['UPLOAD_FOLDER'], 'roc_curve.png')
    plt.savefig(roc_plot_path)
    plt.close()

    return conf_matrix, accuracy, class_report, roc_plot_path


# Flask Routes
@app.route('/')
def index():
    X, y = load_fraud_data()
    plot_paths = plot_fraud_detection(X, y)
    return render_template('index.html', plot_urls=plot_paths)


@app.route('/verify')
def verify():
    # Load transactions from a CSV file
    filename = "transactions.csv"  # Specify your CSV file path here
    transactions = read_transactions_from_csv(filename)

    # Render the transactions in the webpage
    return render_template('verify.html', transactions=transactions)


@app.route('/submit_transaction', methods=['POST'])
def submit_transaction():
    sender = request.form['sender']
    receiver = request.form['receiver']
    try:
        amount = float(request.form['amount'])
    except ValueError:
        return "Invalid amount entered, please enter a valid number.", 400

    key = generate_key()

    # Create transaction and monitor it
    transaction_log = {
        'sender': sender,
        'receiver': receiver,
        'amount': amount,
        'transaction_hash': hashlib.sha256(f'{sender}{receiver}{amount}'.encode()).hexdigest(),
    }
    transaction_log['encrypted_data'] = encrypt_data(json.dumps(transaction_log), key)

    transaction_keys[transaction_log['transaction_hash']] = key  # Save the key for later decryption

    # Monitor the transaction for suspicious activity
    risk_level = monitor_transactions(transaction_log, key)

    # Provide feedback to the user
    result = f"Transaction classified as: {risk_level}"

    return render_template('result.html', result=result)


@app.route('/about')
def about():
    return render_template('about.html')


@app.route('/model_performance')
def model_performance():
    X, y = load_fraud_data()
    conf_matrix, accuracy, class_report, roc_plot_path = train_and_evaluate_model(X, y)

    return render_template(
        'model_performance.html',
        confusion_matrix=conf_matrix,
        accuracy=accuracy,
        classification_report=class_report,
        roc_plot_url=roc_plot_path
    )


if __name__ == "__main__":
    app.run(debug=True)
