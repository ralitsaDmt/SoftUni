import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        final String stringPath = "D:\\Files-and-Streams";
        File dir = new File(stringPath);

        if (dir.isDirectory()){
            File[] files = dir.listFiles();

            for (File file:
                 files) {
                if (!file.isDirectory()){
                    System.out.printf("%s: %s\n",
                            file.getName(), file.length());
                }
            }
        }
    }
}
