import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    private static BiPredicate<String, String> startsWith = String::startsWith;
    private static BiPredicate<String, String> endsWith = String::endsWith;
    private static BiPredicate<String, Integer> hasLength = (x, l) -> x.length() == l;
    private static BiPredicate<String, String> contains = String::contains;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));


        List<String> people = new ArrayList<String>(Arrays.asList(in.readLine().split("\\s+")));
        Set<String> filters = new LinkedHashSet<>();

        while(true){
            String input = in.readLine();
            if("Print".equals(input)) break;

            String[] tprf = input.split(";");
            String command = tprf[0];

            switch (command){
                case "Add filter": filters.add(tprf[1] + ";" + tprf[2]); break;
                case "Remove filter": {
                    if(filters.contains(tprf[1] + ";" + tprf[2])){
                        filters.remove(tprf[1] + ";" + tprf[2]);
                    }
                }
            }            
        }
        
        people = applyFilters(people, filters);

        System.out.println(String.join(" ", people));
    }

    private static List<String> applyFilters(List<String> people, Set<String> filters) {

        for (String f:filters) {
            String[] fs = f.split(";");
            String filter = fs[0];
            String parameter = fs[1];

            switch (filter){
                case "Starts with": people = people.stream().filter(x -> !startsWith.test(x, parameter)).collect(Collectors.toList()); break;
                case "Ends with": people = people.stream().filter(x -> !endsWith.test(x, parameter)).collect(Collectors.toList()); break;
                case "Length": people = people.stream().filter(x -> !hasLength.test(x, Integer.parseInt(parameter))).collect(Collectors.toList()); break;
                case "Contains": people = people.stream().filter(x -> !contains.test(x, parameter)).collect(Collectors.toList()); break;
            }
        }

        return people;
    }
}
