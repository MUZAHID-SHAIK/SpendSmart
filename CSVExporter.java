package util;

import model.Expense;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public static void exportToCSV(List<Expense> expenses, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("ID,Category,Amount,Date,Description\n");
            for (Expense e : expenses) {
                writer.write(String.format("%d,%s,%.2f,%s,%s\n",
                        e.getId(), e.getCategory(), e.getAmount(), e.getDate(), e.getDescription()));
            }
        }
    }
}
