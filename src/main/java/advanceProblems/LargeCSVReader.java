package advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("src/main/java/advanceProblems/students_large.csv"))) {
            int batchSize = 0;
            int totalRecords = 0;

            reader.readNext(); // Skip header
            String[] line;

            while ((line = reader.readNext()) != null) {
                totalRecords++;
                batchSize++;

                // Print the record
                System.out.println(String.join(", ", line));

                // If we have processed 100 records, wait for 5 seconds
                if (batchSize == 100) {
                    System.out.println("\nProcessed " + totalRecords + " records so far. Pausing for 5 seconds...\n");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted: " + e.getMessage());
                    };
                    batchSize = 0; // Reset batch count after waiting
                }
            }

            System.out.println("\nTotal Records Processed: " + totalRecords);
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
