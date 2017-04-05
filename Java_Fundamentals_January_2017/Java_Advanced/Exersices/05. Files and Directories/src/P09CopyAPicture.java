import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyAPicture {

    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String IMAGE_PATH = PROJECT_PATH + "picture.jpg";
    private static final String IMAGE_COPY_PATH = PROJECT_PATH + "picture-copy.jpg";

    public static void main(String[] args) {

        try(FileInputStream in = new FileInputStream(IMAGE_PATH);
            FileOutputStream out = new FileOutputStream(IMAGE_COPY_PATH)
        ) {
            int bytes;
            while((bytes = in.read()) != -1){
                out.write(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
