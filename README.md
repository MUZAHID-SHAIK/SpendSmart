# SpendSmart - Expense Tracking & Visualization

SpendSmart is a simple, Java-based backend tool that helps users track, categorize, and visualize their personal expenses. It uses MySQL for persistent storage and includes features like category-wise and monthly expense analysis, and CSV export for reporting.

---

## 🧰 Tech Stack

* **Language:** Java
* **Database:** MySQL
* **Architecture:** MVC-inspired modular structure
* **File Export:** CSV

---

## 📁 Project Structure

```
SpendSmart/
├── src/
│   ├── model/          # Expense object definition
│   ├── dao/            # Data Access Layer (CRUD operations)
│   ├── service/        # Business logic layer
│   ├── util/           # Utility for exporting CSV reports
│   └── Main.java       # Entry point for the application
└── db/
    └── schema.sql      # SQL table creation script
```

---

## 📦 Features

### ✅ Add and Store Expenses

Each expense includes:

* Category (e.g., Food, Transport)
* Amount
* Date
* Description

Stored securely in a MySQL database.

### 📊 Insights

* **Category-wise Distribution:** See how much you spend per category.
* **Monthly Trends:** Analyze your monthly spending behavior.

### 📤 Export to CSV

* Easily export your full expense data to `expenses.csv` for external use.

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/SpendSmart.git
cd SpendSmart
```

### 2. Set up MySQL

Run the SQL script to create the required table:

```sql
-- db/schema.sql
CREATE DATABASE spendsmart;
USE spendsmart;

CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(50),
    amount DOUBLE,
    date DATE,
    description TEXT
);
```

### 3. Configure Database Connection

Update the `Main.java` file with your DB credentials:

```java
Connection connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/spendsmart", "root", "your_password"
);
```

### 4. Compile and Run

```bash
javac -d bin src/**/*.java
java -cp bin Main
```

---

## 🔍 Code Breakdown

### `model/Expense.java`

* A simple POJO that defines the structure of an expense.
* Fields: `id`, `category`, `amount`, `date`, `description`

### `dao/ExpenseDAO.java`

* Handles all database operations.
* Methods: `addExpense()`, `getAllExpenses()`

### `service/ExpenseService.java`

* Business logic for generating insights:

  * `getCategoryWiseDistribution()`
  * `getMonthlyTrends()`

### `util/CSVExporter.java`

* Utility class that exports a list of expenses into a `.csv` file.

### `Main.java`

* Entry point to the application.
* Demonstrates:

  * Adding a sample expense
  * Retrieving reports
  * Exporting to CSV

---

## 📌 Example Output

```text
Category-wise Distribution: {Food=500.0}
Monthly Trends: {JUNE=500.0}
Exported expenses to expenses.csv
```

---
