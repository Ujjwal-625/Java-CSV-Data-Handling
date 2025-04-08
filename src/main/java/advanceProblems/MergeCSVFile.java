package advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFile {
    public static void main(String[] args) {
        String file1 = "src/main/java/advanceProblems/Student1.csv";
        String file2 = "src/main/java/advanceProblems/Student2.csv";
        String mergedFile = "src/main/java/advanceProblems/merged_students.csv";

        try {
            // Read students1.csv (ID, Name, Age)
            CSVReader reader1 = new CSVReader(new FileReader(file1));
            Map<String, String[]> studentMap = new HashMap<>();
            String[] line1;
            reader1.readNext(); // Skip header
            while ((line1 = reader1.readNext()) != null) {
                studentMap.put(line1[0], new String[]{line1[1], line1[2]});
            }
            reader1.close();

            // Read students2.csv (ID, Marks, Grade) and merge
            CSVReader reader2 = new CSVReader(new FileReader(file2));
            String[] line2;
            reader2.readNext(); // Skip header

            CSVWriter writer = new CSVWriter(new FileWriter(mergedFile));
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"}); // Write header

            while ((line2 = reader2.readNext()) != null) {
                String id = line2[0];
                if (studentMap.containsKey(id)) {
                    String[] studentInfo = studentMap.get(id);
                    writer.writeNext(new String[]{id, studentInfo[0], studentInfo[1], line2[1], line2[2]});
                }
            }

            reader2.close();
            writer.close();
            System.out.println("Merged file created: " + mergedFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
