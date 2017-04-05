import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {

        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
                PrintWriter writer = new PrintWriter(outputPath)
        ) {
            String s;
            while((s = reader.readLine()) != null){
                writer.println(s.toUpperCase());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
