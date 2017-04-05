import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath), "UTF-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath), "UTF-8"))) {

            int counter = 1;
            String line = reader.readLine();

            while (line != null){



                if(counter % 3 == 0){
                    writer.write(line);
                    System.out.println(line);
                    writer.write("\n");
                }
                counter++;
                line = reader.readLine();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
