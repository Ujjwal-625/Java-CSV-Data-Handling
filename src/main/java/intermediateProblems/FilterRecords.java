package intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        try(CSVReader reader=new CSVReader(new FileReader("src/main/java/Employee.csv"))){
            String [] line;
            while((line=reader.readNext())!=null){
                if(Integer.parseInt(line[3])>=80){
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
