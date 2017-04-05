import java.io.*;
import java.util.ArrayList;
import java.util.StringJoiner;

public class CopyBytes {

    public static void main(String[] args) {
        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try(InputStream br = new FileInputStream(inputPath);
            OutputStream bw = new FileOutputStream(outputPath)
        ){
            int s = 0;
            while((s = br.read()) >= 0) {
                if (s == 10 || s == 32) {
                    bw.write(s);
                }
                else{
                    String digits = String.valueOf(s);
                    for(int i = 0; i < digits.length(); i++){
                        bw.write(digits.charAt(i));
                    }
                }
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
