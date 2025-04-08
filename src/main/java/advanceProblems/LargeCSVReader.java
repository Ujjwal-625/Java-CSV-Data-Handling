package advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        try(CSVReader reader=new CSVReader(new FileReader("src/main/java/advanceProblems/students_large.csv"))){
            int batchsize=100;
            int totalRecords=0;
            reader.readNext();
            String [] line;

            while((line=reader.readNext())!=null){
                batchsize++;
                totalRecords++;


                for (String record :line) {
                    System.out.println(String.join(", ", record));
                }

                if(batchsize==100){
                    batchsize=0;
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
