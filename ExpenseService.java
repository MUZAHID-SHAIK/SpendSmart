package service;

import dao.ExpenseDAO;
import model.Expense;
import java.sql.SQLException;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class ExpenseService {
    private final ExpenseDAO expenseDAO;

    public ExpenseService(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    public void addExpense(Expense expense) throws SQLException {
        expenseDAO.addExpense(expense);
    }

    public Map<String, Double> getCategoryWiseDistribution() throws SQLException {
        List<Expense> expenses = expenseDAO.getAllExpenses();
        return expenses.stream()
                .collect(Collectors.groupingBy(
                    Expense::getCategory,
                    Collectors.summingDouble(Expense::getAmount)));
    }

    public Map<Month, Double> getMonthlyTrends() throws SQLException {
        List<Expense> expenses = expenseDAO.getAllExpenses();
        return expenses.stream()
                .collect(Collectors.groupingBy(
                    e -> e.getDate().getMonth(),
                    TreeMap::new,
                    Collectors.summingDouble(Expense::getAmount)));
    }
}
