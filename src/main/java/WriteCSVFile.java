import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
    public static void main(String[] args) {
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("Employee.csv"))){
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,Alice Williams,Finance,62000\n");
            writer.write("105,Bob Johnson,Sales,58000\n");
            System.out.println("CSV file written successfully!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
