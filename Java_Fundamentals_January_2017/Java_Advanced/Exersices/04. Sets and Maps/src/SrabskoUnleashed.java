import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();

        String pattern = "^([a-zA-Z]+\\s?[a-zA-Z]+\\s?[a-zA-Z]+)\\s@([a-zA-Z]+\\s?[a-zA-Z]+\\s?[a-zA-Z]+)\\s(\\d+)\\s(\\d+)";
        Pattern p = Pattern.compile(pattern);

        while (true) {
            String line = in.readLine();
            if (line.equals("End")) break;

            Matcher m = p.matcher(line);
            if (m.find()){
                String singer = m.group(1);
                String town = m.group(2);
                int ticketPrice = Integer.parseInt(m.group(3));
                int ticketsCount = Integer.parseInt(m.group(4));
                int sum = ticketPrice * ticketsCount;

                if (venues.containsKey(town)){
                    if (!venues.get(town).containsKey(singer)){
                        venues.get(town).put(singer, sum);
                    } else {
                        venues.get(town).put(singer, venues.get(town).get(singer) + sum);
                    }
                } else {
                    venues.put(town, new LinkedHashMap<>());
                    venues.get(town).put(singer, sum);
                }
            }
        }

        venues.entrySet().forEach(v -> {
            System.out.println(v.getKey());
            v.getValue().entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %s\n", s.getKey(), s.getValue()));
        });
    }
}
