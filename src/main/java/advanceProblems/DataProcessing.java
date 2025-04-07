package advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProcessing {

    static void validateMail(){
        String regex="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern= Pattern.compile(regex);

        try(CSVReader reader =new CSVReader(new FileReader("src/main/java/advanceProblems/Data.csv"))){
            String [] header=reader.readNext();
            String [] line;
            while((line=reader.readNext())!=null){
                Matcher matcher=pattern.matcher(line[4]);
                if(!matcher.matches()){
                    System.out.println("Following record does not have valid mail");
                    System.out.println(Arrays.toString(line));
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

    static  void validateNumber(){
        String regex="^[0-9]{10}$";

        Pattern pattern= Pattern.compile(regex);

        try(CSVReader reader =new CSVReader(new FileReader("src/main/java/advanceProblems/Data.csv"))){
            String [] header=reader.readNext();
            String [] line;
            while((line=reader.readNext())!=null){
                Matcher matcher=pattern.matcher(line[5]);
                if(!matcher.matches()){
                    System.out.println("Following record does not have valid Number");
                    System.out.println(Arrays.toString(line));
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
    public static void main(String[] args) {
        validateMail();
        validateNumber();
    }
}
