package advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Duplicate {
    public static void main(String[] args) {
        try(CSVReader reader=new CSVReader(new FileReader("src/main/java/advanceProblems/Duplicate.csv"))) {
        reader.readNext();

        String [] line;
        Map<String,String []> mp=new HashMap<>();
        while((line=reader.readNext())!=null){
            String id=line[0];
            if(mp.containsKey(id)){
                System.out.println("Duplicate line");
                System.out.println(line[0]+","+line[1]+","+line[2]+","+line[3]+","+line[4]);
            }
            else{
                mp.put(id, new String[]{line[1], line[2],line[3], line[3],line[4]});
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
