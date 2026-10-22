import pandas as pd

# Sample data: List of dictionaries with transaction details
data = [
    {'sender': 'Alice', 'receiver': 'Bob', 'amount': 1000},
    {'sender': 'Charlie', 'receiver': 'David', 'amount': 100000},
    {'sender': 'Eve', 'receiver': 'Frank', 'amount': 3000},
    {'sender': 'Ragul', 'receiver': 'Prem', 'amount': 30000},
    {'sender': 'Elavarasan', 'receiver': 'Mathi', 'amount': 4000},
    {'sender': 'Prem', 'receiver': 'Deva', 'amount': 6000},
    {'sender': 'Hari', 'receiver': 'Renu', 'amount': 5000},
    {'sender': 'Arul', 'receiver': 'Gowtham', 'amount': 15000},
    {'sender': 'Swathi', 'receiver': 'Sandy', 'amount': 20000},
    {'sender': 'Anu', 'receiver': 'Abi', 'amount': 25000},
    {'sender': 'Anjali', 'receiver': 'Anitha', 'amount': 7000},
    {'sender': 'Karthik', 'receiver': 'Kathir', 'amount': 8000},
    {'sender': 'Sakthi', 'receiver': 'Veena', 'amount': 9000},
    {'sender': 'Hendry', 'receiver': 'Jack', 'amount': 10000},
]

# Convert the data into a pandas DataFrame
df = pd.DataFrame(data)

# Define the filename for the CSV
filename = 'transactions.csv'

# Write the DataFrame to a CSV file
df.to_csv(filename, index=False)

print(f"CSV file '{filename}' created successfully.")
