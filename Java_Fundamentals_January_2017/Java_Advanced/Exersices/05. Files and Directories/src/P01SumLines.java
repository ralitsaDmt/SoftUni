import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {
    public static void main(String[] args) {

        String inputPath = "D:\\input.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;

            while ((line = reader.readLine()) != null){
                long sum = CalcSum(line);
                System.out.println(sum);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long CalcSum(String line) {
        long sum = 0;

        for (int i = 0; i < line.length(); i++) {
            sum += line.charAt(i);
        }

        return sum;
    }
}
