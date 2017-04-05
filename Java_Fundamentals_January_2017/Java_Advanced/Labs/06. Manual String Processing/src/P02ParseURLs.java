import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P02ParseURLs {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split("://");

        if(input.length != 2){
            System.out.println("Invalid URL");
        }
        else{

            System.out.println("Protocol = " + input[0]);

            int index = input[1].indexOf("/");

            System.out.println("Server = " + input[1].substring(0, index));
            System.out.printf("Resources = " + input[1].substring(index + 1));
        }

    }
}
