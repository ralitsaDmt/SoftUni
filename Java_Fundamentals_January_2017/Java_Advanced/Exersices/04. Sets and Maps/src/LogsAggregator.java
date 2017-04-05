import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(in.readLine());

        Map<String, TreeSet<String>> usersIPs = new HashMap<>();
        Map<String, Integer> usersDurations = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String[] tokens = in.readLine().split("\\s+");

            String ip = tokens[0];
            String username = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            if (usersDurations.containsKey(username)){
                usersDurations.put(username, usersDurations.get(username) + duration);
            }
            else{
                usersDurations.put(username, duration);
            }

            if (!usersIPs.containsKey(username)){
                usersIPs.put(username, new TreeSet<>());
            }

            usersIPs.get(username).add(ip);
        }

        usersDurations.entrySet()
                .stream()
                .sorted((u1, u2) -> u1.getKey().compareTo(u2.getKey()))
                .forEach(u ->{
                    System.out.printf("%s: %s [%s]\n",
                            u.getKey(), u.getValue(), String.join(", ", usersIPs.get(u.getKey())));
                });
    }
}
