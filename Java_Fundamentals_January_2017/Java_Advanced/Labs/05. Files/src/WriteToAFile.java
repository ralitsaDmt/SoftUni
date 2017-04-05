import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class WriteToAFile {
    public static void main(String[] args) {
        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        HashSet<String> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ",",".","!", "?");

        ArrayList<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(inputPath), "UTF-8"))) {

            String s;

            while((s = br.readLine()) != null){

                for(String p: punctuation){
                    s = s.replace(p, "");
                }
                lines.add(s);
                System.out.println(s);
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputPath), "UTF-8"))) {


            for(String line:lines){
                bw.write(line);
                bw.write("\n");
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
