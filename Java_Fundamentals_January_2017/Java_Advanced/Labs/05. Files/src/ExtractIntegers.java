import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class ExtractIntegers {



    public static void main(String[] args) {



        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try(Scanner scanner = new Scanner(new FileInputStream(inputPath));
            PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath)))
        {
            while (scanner.hasNext()){
                if(scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }

    }
}
