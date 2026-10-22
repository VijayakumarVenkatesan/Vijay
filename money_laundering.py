import warnings
warnings.filterwarnings('ignore')
warnings.simplefilter('ignore')

import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.patches import Rectangle
import numpy as np
from pprint import pprint as pp
import csv
from pathlib import Path
import seaborn as sns
from itertools import product
import string

import nltk
from nltk.corpus import stopwords
from nltk.stem.wordnet import WordNetLemmatizer

from imblearn.over_sampling import SMOTE
from imblearn.over_sampling import BorderlineSMOTE
from imblearn.pipeline import Pipeline

from sklearn.linear_model import LinearRegression, LogisticRegression
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import r2_score, classification_report, confusion_matrix, accuracy_score, roc_auc_score, roc_curve, precision_recall_curve, average_precision_score
from sklearn.metrics import homogeneity_score, silhouette_score
from sklearn.ensemble import RandomForestClassifier, VotingClassifier
from sklearn.preprocessing import MinMaxScaler
from sklearn.cluster import MiniBatchKMeans, DBSCAN

import gensim
from gensim import corpora

pd.set_option('display.max_columns', 700)
pd.set_option('display.max_rows', 400)
pd.set_option('display.min_rows', 10)
pd.set_option('display.expand_frame_repr', True)

data = Path.cwd() / 'fraud_detection'

ch1 = data / 'chapter_1'
cc1_file = ch1 / 'creditcard_sampledata.csv'
cc3_file = ch1 / 'creditcard_sampledata_3.csv'

ch2 = data / 'chapter_2'
cc2_file = ch2 / 'creditcard_sampledata_2.csv'

ch3 = data / 'chapter_3'
banksim_file = ch3 / 'banksim.csv'
banksim_adj_file = ch3 / 'banksim_adj.csv'
db_full_file = ch3 / 'db_full.pickle'
labels_file = ch3 / 'labels.pickle'
labels_full_file = ch3 / 'labels_full.pickle'
x_scaled_file = ch3 / 'x_scaled.pickle'
x_scaled_full_file = ch3 / 'x_scaled_full.pickle'

ch4 = data / 'chapter_4'
enron_emails_clean_file = ch4 / 'enron_emails_clean.csv'
cleantext_file = ch4 / 'cleantext.pickle'
corpus_file = ch4 / 'corpus.pickle'
dict_file = ch4 / 'dict.pickle'
ldamodel_file = ch4 / 'ldamodel.pickle'

# df = pd.read_csv(cc3_file)
df = pd.read_csv(cc2_file)
# df = pd.read_csv(cc1_file)

# df.info()

# print(df.head())

occ = df['Class'].value_counts()

print(occ)

ratio_cases = occ/len(df.index)
print(f'\nRatio of fraudulent cases: {ratio_cases[1]}\nRatio of non-fraudulent cases: {ratio_cases[0]}')

def prep_data(df: pd.DataFrame) -> (np.ndarray, np.ndarray):
    X = df.iloc[:, 2:30].values
    y = df.Class.values
    return X, y

def original_plot_data(X: np.ndarray, y: np.ndarray):
    plt.figure(num='Anti-Money Laundering Detection', clear=True)
    plt.scatter(X[y == 0, 0], X[y == 0, 1], label="Class #0", alpha=0.5, linewidth=0.15)
    plt.scatter(X[y == 1, 0], X[y == 1, 1], label="Class #1", alpha=0.5, linewidth=0.15, c='r')
    plt.title("Original Set", fontsize=15)
    plt.legend()
    return plt.show()

X, y = prep_data(df)

original_plot_data(X, y)

def predicted_data():
    plt.figure(num='Anti-Money Laundering Detection', clear=True)
    plt.scatter(df.V2[df.Class == 0], df.V3[df.Class == 0], label="Class #0", alpha=0.5, linewidth=0.15)
    plt.scatter(df.V2[df.Class == 1], df.V3[df.Class == 1], label="Class #1", alpha=0.5, linewidth=0.15, c='r')
    plt.legend()
    plt.title('Predicted Set', fontsize=15)
    plt.show()

predicted_data()

def resampled_plot_data(X: np.ndarray, y: np.ndarray):
    plt.figure(num='Anti-Money Laundering Detection', clear=True)
    plt.scatter(X[y == 0, 0], X[y == 0, 1], label="Class #0", alpha=0.5, linewidth=0.15)
    plt.scatter(X[y == 1, 0], X[y == 1, 1], label="Class #1", alpha=0.5, linewidth=0.15, c='r')
    plt.title("Resampled Set", fontsize=15)
    plt.legend()
    return plt.show()

method = SMOTE()
X_resampled, y_resampled = method.fit_resample(X, y)

resampled_plot_data(X_resampled, y_resampled)

def compare_plot(X: np.ndarray, y: np.ndarray, X_resampled: np.ndarray, y_resampled: np.ndarray, method: str):
    plt.figure(num='Anti-Money Laundering Detection', clear=True)
    plt.subplot(1, 2, 1)
    plt.scatter(X[y == 0, 0], X[y == 0, 1], label="Class #0", alpha=0.5, linewidth=0.15)
    plt.scatter(X[y == 1, 0], X[y == 1, 1], label="Class #1", alpha=0.5, linewidth=0.15, c='r')
    plt.title('Original Set', fontsize=15)
    plt.subplot(1, 2, 2)
    plt.scatter(X_resampled[y_resampled == 0, 0], X_resampled[y_resampled == 0, 1], label="Class #0", alpha=0.5, linewidth=0.15)
    plt.scatter(X_resampled[y_resampled == 1, 0], X_resampled[y_resampled == 1, 1], label="Class #1", alpha=0.5, linewidth=0.15, c='r')
    plt.title(method, fontsize=15)
    plt.legend()
    plt.show()

compare_plot(X, y, X_resampled, y_resampled, method='SMOTE')

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=0)
model = RandomForestClassifier(random_state=5, n_estimators=20)
# model = LogisticRegression(solver='liblinear')
# model = DecisionTreeClassifier()
# model = MiniBatchKMeans(n_clusters=2)
model.fit(X_train, y_train)
predicted = model.predict(X_test)
conf_mat = confusion_matrix(y_true=y_test, y_pred=predicted)
print('\nConfusion Matrix:\n', conf_mat)
print(f'\nAccuracy Score: {accuracy_score(y_test, predicted)}')
print('\nClassification Report:\n', classification_report(y_test, predicted))
TP = conf_mat[0][0]
FP = conf_mat[0][1]
FN = conf_mat[1][0]
TN = conf_mat[1][1]
recall = TP/(TP+FN)
precision = TP/(TP+FP)
print(f"Precision: {precision}")
print(f"Recall: {recall}")
f_measure = (2*recall*precision)/(recall+precision)
print(f"F1 Score: {f_measure}")

plt.figure(num='Anti-Money Laundering Detection', clear=True)
sns.heatmap(conf_mat, annot=True, fmt='g', xticklabels=['True', 'False'],
            yticklabels=['True', 'False'])
plt.ylabel('Predicted', fontsize=12)
plt.xlabel('Actual', fontsize=12)
plt.title('Confusion Matrix', fontsize=15)
plt.show()
