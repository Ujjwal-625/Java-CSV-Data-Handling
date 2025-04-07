package intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifyCSVFile {

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

    static void modifyRecords(){
        List<String []> allRecords=new ArrayList<>();

        try(CSVReader reader =new CSVReader(new FileReader("Employee.csv"))){
            String []line;
            while((line=reader.readNext())!=null){

                if(!line[3].equals("Salary")){
                    double salary=Double.parseDouble(line[3]);
                    salary*=1.1;
                    line[3]=String.format("%.2f",salary);
                }
                allRecords.add(line);
            }

        }
        catch (CsvValidationException ex) {
            throw new RuntimeException(ex);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try(CSVWriter writer =new CSVWriter(new FileWriter("Employee.csv"))){
            writer.writeAll(allRecords);
            System.out.println("Modified succefully");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        System.out.println("Records before modification ");
        displayRecords();
        System.out.println("Modifying the records");
        modifyRecords();
        System.out.println("Cheking");
        displayRecords();
        System.out.println("Checking 1" );
    }
}
