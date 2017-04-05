import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) {

        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            PrintWriter writer = new PrintWriter(outputPath)
        ) {

            String s;
            int count = 1;
            while((s = reader.readLine()) != null){
                writer.println(count + ". "+ s);
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
