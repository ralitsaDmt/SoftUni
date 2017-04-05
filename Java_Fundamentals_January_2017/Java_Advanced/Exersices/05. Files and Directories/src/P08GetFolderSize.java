import java.io.File;
import java.util.ArrayDeque;

public class P08GetFolderSize {
    public static void main(String[] args) {
        final String stringPath = "D:\\Files-and-Streams";
        File dir = new File(stringPath);

        long size = folderSize(dir);

        System.out.println("Folder size: " + size);
    }

    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}
