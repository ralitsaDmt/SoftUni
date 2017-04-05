import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {

    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_ONE_PATH = PROJECT_PATH + "file1.txt";
    private static final String FILE_TWO_PATH = PROJECT_PATH + "file2.txt";
    private static final String FILE_THREE_PATH = PROJECT_PATH + "file3.txt";
    private static final String OUTPUT_FILE_PATH = PROJECT_PATH + "files.zip";

    public static void main(String[] args) throws FileNotFoundException {

        String[] srcFiles = { FILE_ONE_PATH, FILE_TWO_PATH, FILE_THREE_PATH};

        try{
            byte[] buffer = new byte[1024];

            ZipOutputStream archiver = new ZipOutputStream(new FileOutputStream(OUTPUT_FILE_PATH));

            for (String file : srcFiles){

                File srcFile = new File(file);
                FileInputStream fis = new FileInputStream(srcFile);

                archiver.putNextEntry(new ZipEntry(srcFile.getName()));

                int lenght;
                while((lenght = fis.read(buffer)) > 0){
                    archiver.write(buffer, 0, lenght);
                }

                archiver.closeEntry();
                fis.close();
            }

            archiver.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
