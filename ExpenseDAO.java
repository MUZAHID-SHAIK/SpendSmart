package dao;

import model.Expense;
import java.sql.*;
import java.util.*;

public class ExpenseDAO {
    private final Connection connection;

    public ExpenseDAO(Connection connection) {
        this.connection = connection;
    }

    public void addExpense(Expense expense) throws SQLException {
        String sql = "INSERT INTO expenses (category, amount, date, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, expense.getCategory());
            stmt.setDouble(2, expense.getAmount());
            stmt.setDate(3, Date.valueOf(expense.getDate()));
            stmt.setString(4, expense.getDescription());
            stmt.executeUpdate();
        }
    }

    public List<Expense> getAllExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses ORDER BY date DESC";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Expense e = new Expense(
                    rs.getInt("id"),
                    rs.getString("category"),
                    rs.getDouble("amount"),
                    rs.getDate("date").toLocalDate(),
                    rs.getString("description")
                );
                expenses.add(e);
            }
        }
        return expenses;
    }
}
