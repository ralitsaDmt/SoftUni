import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();
        String chars = in.readLine();

        if(chars.length() == 0){
            System.out.println("No shake.");
        }

        while(chars.length() > 0){
            int firstIndex = line.indexOf(chars);
            int lastIndex = line.lastIndexOf(chars);

            if(firstIndex >= 0 && lastIndex >= 0 && lastIndex > firstIndex){
                line = shake(line, chars, firstIndex, lastIndex);

                System.out.println("Shaked it.");

                chars = reduceChars(chars);
            }
            else{
                System.out.println("No shake.");
                break;
            }
        }

        if(chars.length() == 0){
            System.out.println("No shake.");
        }

        System.out.println(line);
    }

    private static String reduceChars(String chars) {
        int indexToRemove = chars.length() / 2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length(); i++) {
            if(i != indexToRemove){
                sb.append(chars.charAt(i));
            }
        }

        return sb.toString();
    }

    private static String shake(
            String line, String chars, int firstIndex, int lastIndex) {

        StringBuilder sb = new StringBuilder(line);

        sb.delete(lastIndex, lastIndex + chars.length());
        sb.delete(firstIndex, firstIndex + chars.length());

        return sb.toString();
    }
}
