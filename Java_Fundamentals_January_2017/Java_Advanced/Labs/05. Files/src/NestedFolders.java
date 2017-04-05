import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {

        final String stringPath = "D:\\Files-and-Streams";
        File dir = new File(stringPath);

        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(dir);
        int counter = 1;

        while (!queue.isEmpty()){
            File currentDir = queue.poll();

            File[] nested = currentDir.listFiles();
            for(File nestedFile : nested){
                if(nestedFile.isDirectory()){
                    queue.offer(nestedFile);
                    counter++;
                }
            }

            System.out.println(currentDir.getName());
        }
        System.out.println(counter + " folders");
    }

//    private static String readFiles(){
//
//    }
}
