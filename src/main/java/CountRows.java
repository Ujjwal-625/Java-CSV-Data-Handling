import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args) {
        try(BufferedReader reader=new BufferedReader(new FileReader("Employee.csv"))){
            String line;
            int count=0;
            while((line= reader.readLine())!=null){
                count++;
                String [] col=line.split(",");
                System.out.println("Id : "+col[0] +" Name : "+col[1]+" age : "+col[2]+" Marks : "+col[3]);
            }
            System.out.println("There are "+count +" lines in the csv file");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
