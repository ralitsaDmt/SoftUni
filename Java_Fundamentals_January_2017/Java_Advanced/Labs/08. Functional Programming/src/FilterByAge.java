import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.sun.javafx.print.PrintHelper.createPrinter;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        Map<String, Integer> people = readPeople(in, n);

        String condition = in.readLine();
        int ageFilter = Integer.parseInt(in.readLine());

        String format = in.readLine();

        Predicate<Integer> tester = createTester(condition, ageFilter);

        Consumer<Map.Entry<String, Integer>> printer = createPrint(format);

        printFilteredStudents(people, printer, tester);
    }

    private static void printFilteredStudents(Map<String, Integer> people, Consumer<Map.Entry<String, Integer>> printer, Predicate<Integer> tester) {
        for(Map.Entry<String, Integer> p:people.entrySet()){
            if(tester.test(p.getValue())){
                printer.accept(p);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrint(String format) {

        switch (format){
            case "name age":
                return person -> System.out.printf("%s - %d%n",
                        person.getKey(), person.getValue());
            case "age name":
                return person -> System.out.printf("%d - %s%n",
                        person.getValue(), person.getKey());
            case "age":
                return person -> System.out.println(person.getValue());
            case "name": return  person -> System.out.println(person.getKey());
            default: return person -> System.out.println();
        }
    }

    private static Predicate<Integer> createTester(String condition, int ageFilter) {
        switch (condition){
            case "younger": return x -> x < ageFilter;
            case "older": return x -> x > ageFilter;
            default: return x -> x == ageFilter;
        }
    }

    private static Map<String, Integer> readPeople(BufferedReader in, int n) throws IOException {
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = in.readLine().split(", ");
            people.put(info[0], Integer.parseInt(info[1]));
        }

        return people;
    }
}
