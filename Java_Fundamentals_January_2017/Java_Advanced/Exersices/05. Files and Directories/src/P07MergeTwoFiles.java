import java.io.*;

public class P07MergeTwoFiles {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FIRST_FILE_PATH = PROJECT_PATH + "file1.txt";
    private static final String SECOND_FILE_PATH = PROJECT_PATH + "file2.txt";
    private static final String RESULT_FILE_PATH = PROJECT_PATH + "results.txt";

    public static void main(String[] args) {

        try(BufferedReader firstReader = new BufferedReader(new FileReader(FIRST_FILE_PATH));
            BufferedReader secondReader = new BufferedReader(new FileReader(SECOND_FILE_PATH));
            BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE_PATH))
        ) {
            ReadWrite(firstReader, writer);
            ReadWrite(secondReader, writer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ReadWrite(BufferedReader reader, BufferedWriter writer) throws IOException {
        String s = "";
        while ((s = reader.readLine()) != null){
            writer.write(s);
            writer.newLine();
        }
    }
}
