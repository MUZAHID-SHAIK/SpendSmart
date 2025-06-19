import dao.ExpenseDAO;
import model.Expense;
import service.ExpenseService;
import util.CSVExporter;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spendsmart", "root", "password")) {

            ExpenseDAO dao = new ExpenseDAO(connection);
            ExpenseService service = new ExpenseService(dao);

            // Add Sample Expense
            service.addExpense(new Expense("Food", 500.0, LocalDate.now(), "Groceries"));

            // Category-wise distribution
            Map<String, Double> categoryDist = service.getCategoryWiseDistribution();
            System.out.println("Category-wise Distribution: " + categoryDist);

            // Monthly trends
            Map<java.time.Month, Double> monthlyTrend = service.getMonthlyTrends();
            System.out.println("Monthly Trends: " + monthlyTrend);

            // Export to CSV
            List<Expense> allExpenses = dao.getAllExpenses();
            CSVExporter.exportToCSV(allExpenses, "expenses.csv");
            System.out.println("Exported expenses to expenses.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
