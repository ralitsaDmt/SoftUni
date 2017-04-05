import java.io.FileInputStream;

public class Problem {
    public static void main(String[] args) {
        String path = "D:\\input.txt";

        try(FileInputStream fis = new FileInputStream(path)){
            int oneByte = fis.read();

            while (oneByte >= 0){
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fis.read();
            }
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
