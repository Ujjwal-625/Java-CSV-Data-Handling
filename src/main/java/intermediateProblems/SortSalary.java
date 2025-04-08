package intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortSalary {

    static void displayRecords(){
        try(CSVReader reader =new CSVReader(new FileReader("Employee.csv"))){
            String []line;
            while((line=reader.readNext())!=null){
                System.out.println("Id : "+line[0] +" Name : "+line[1]+" age : "+line[2]+" Marks : "+line[3]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    static void sortSalary(){
        try(CSVReader reader =new CSVReader(new FileReader("Employee.csv"))){

            List<String[]> allRecords=new ArrayList<>();
            String[] header = reader.readNext();
            allRecords.add(header);
            List<String[]> employeeData = new ArrayList<>();

            String[] line;
            while ((line = reader.readNext()) != null) {
                employeeData.add(line);
            }

            employeeData.sort(Comparator.comparingDouble(o -> Double.parseDouble(o[3])));
            allRecords.addAll(employeeData);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Displaying reocrds initially");
        displayRecords();

        System.out.println("Sorting records according to salary of the employee ");

        sortSalary();

        System.out.println("Records after modifications");

        displayRecords();
    }

}
