import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile
{
    public static void main(String[] args) {
        try(BufferedReader reader=new BufferedReader(new FileReader("src/main/java/Employee.csv"))){
            String line;
            while((line= reader.readLine())!=null){
                String [] col=line.split(",");
                System.out.println("Id : "+col[0] +" Name : "+col[1]+" age : "+col[2]+" Marks : "+col[3]);
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
