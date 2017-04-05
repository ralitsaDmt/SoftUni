import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split("\\s+");

        Consumer<String> printer = System.out::println;

        for(String s:input){
            printer.accept(s);
        }
    }
}
