package model;

import java.time.LocalDate;

public class Expense {
    private int id;
    private String category;
    private double amount;
    private LocalDate date;
    private String description;

    public Expense(int id, String category, double amount, LocalDate date, String description) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Expense(String category, double amount, LocalDate date, String description) {
        this(0, category, amount, date, description);
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
}
