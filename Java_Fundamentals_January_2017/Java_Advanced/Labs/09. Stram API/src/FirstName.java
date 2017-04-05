import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(in.readLine().split("\\s+"));

        Set<Character> letters = new HashSet<>();

        Stream.of(in.readLine().split("\\s+"))
                .map(s -> s.toLowerCase().charAt(0))
                .forEach(letters::add);

        Optional<String> first = names.stream()
                .filter(w -> letters.contains(w.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if(first.isPresent()){
            System.out.println(first.get());
        }
        else{
            System.out.println("No match");
        }
    }
}
