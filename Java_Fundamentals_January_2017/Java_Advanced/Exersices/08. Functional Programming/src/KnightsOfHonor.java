import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split("\\s+");

        Consumer<String> printer = x -> System.out.println("Sir " + x);

        for(String s:input){
            printer.accept(s);
        }
    }
}
