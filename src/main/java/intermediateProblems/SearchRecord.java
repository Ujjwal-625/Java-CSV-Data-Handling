package intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        try(CSVReader reader =new CSVReader(new FileReader("src/main/java/Employee.csv"))){
            String []line;
            Scanner scanner=new Scanner(System.in);
            System.out.print("Enter name of ther employee : ");
            String name= scanner.next();
            System.out.println();
            while((line=reader.readNext())!=null){
                if(line[1].equals(name)){
                    System.out.println("Id : "+line[0] +" Name : "+line[1]+" age : "+line[2]+" Marks : "+line[3]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }
}
