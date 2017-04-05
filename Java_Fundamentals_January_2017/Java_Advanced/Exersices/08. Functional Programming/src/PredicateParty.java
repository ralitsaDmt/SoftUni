import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    private static BiPredicate<String, String> startsWith = String::startsWith;
    private static BiPredicate<String, String> endsWith = String::endsWith;
    private static BiPredicate<String, Integer> hasLength = (x, l) -> x.length() == l;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> people = new ArrayList<String>(Arrays.asList(in.readLine().split("\\s+")));

        String input;
        while(true){
            if("Party!".equals(input = in.readLine())) break;

            String[] tprf = input.split("\\s+");
            String command = tprf[0];

            switch (command){
                case "Remove": people = filterInvitations(people, tprf); break;
                case "Double": people = doubleInvitations(people, tprf); break;
            }

        }

        assert people != null;
        if(people.size() > 0){
            System.out.println(String.join(", ", people) + " are going to the party!");
        }else{
            System.out.println("Nobody is going to the party!");
        }

    }

    private static List<String> doubleInvitations(List<String> people, String[] tprf) {
        String filter = tprf[1];
        String parameter = tprf[2];

        switch (filter){
            case "StartsWith": {
                for (int i = 0; i < people.size(); i++) {
                    if(startsWith.test(people.get(i), parameter)){
                        people.add(i, people.get(i));
                        i++;
                    }
                }
                return people;
            }
            case "EndsWith": {
                for (int i = 0; i < people.size(); i++) {
                    if(endsWith.test(people.get(i), parameter)){
                        people.add(i, people.get(i));
                        i++;
                    }
                }

                return people;
            }
            case "Length": {
                for (int i = 0; i < people.size(); i++) {
                    if(hasLength.test(people.get(i), Integer.parseInt(parameter))){
                        people.add(i, people.get(i));
                        i++;
                    }
                }

                return people;
            }
            default: return null;
        }
    }

    private static List<String> filterInvitations(List<String> people, String[] tprf) {
        String filter = tprf[1];
        String parameter = tprf[2];

        switch (filter){
            case "StartsWith": return people.stream().filter(x -> !startsWith.test(x, parameter)).collect(Collectors.toList());
            case "EndsWith": return people.stream().filter(x -> !endsWith.test(x, parameter)).collect(Collectors.toList());
            case "Length": return people.stream().filter(x -> !hasLength.test(x, Integer.parseInt(parameter))).collect(Collectors.toList());
            default: return null;
        }
    }
}
