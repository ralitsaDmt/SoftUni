import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.stream.Collectors;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, HashMap<String, Integer>> logs = new HashMap<>();

        // keep the order of appearance of IPs
        HashMap<String, LinkedHashSet<String>> userIPs = new HashMap<>();
        // keep alphabetical order of usernames
        TreeSet<String> usernames = new TreeSet<>();

        while (true){
            String[] input = scan.nextLine().split("\\s+");
            if (input[0].equals("end")) break;

            String ip = input[0].split("=")[1];
            String user = input[2].split("=")[1];

            usernames.add(user);

            if (logs.containsKey(user)){
                userIPs.get(user).add(ip);

                if (logs.get(user).containsKey(ip)){
                    logs.get(user).put(ip, logs.get(user).get(ip) + 1);
                }
                else{
                    logs.get(user).put(ip, 1);
                }
            }
            else {
                userIPs.put(user, new LinkedHashSet<>());
                userIPs.get(user).add(ip);

                logs.put(user, new HashMap<>());
                logs.get(user).put(ip, 1);
            }
        }


        for(String user : usernames){
            System.out.println(user + ":");

            LinkedHashSet<String> results = new LinkedHashSet<>();
            for (String ip :
                    userIPs.get(user)) {
                results.add(ip + " => " + logs.get(user).get(ip));
            }

            System.out.println(String.join(", ", results) + ".");
        }
    }
}
