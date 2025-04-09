package advanceProblems;


import java.io.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class DbToCSV {
    public static void main(String[] args) {
        String file1= "Student1.csv";
        String file2 ="copy.csv";
        try{
            CSVReader reader = new CSVReader(new FileReader(file1));
            String[] line;
            CSVWriter writer =new CSVWriter(new FileWriter(file2));
            while((line = reader.readNext())!=null){
                writer.writeNext(line);
            }
            writer.close();
            reader.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
