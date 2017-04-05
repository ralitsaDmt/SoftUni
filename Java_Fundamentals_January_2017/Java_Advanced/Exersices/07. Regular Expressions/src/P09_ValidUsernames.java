import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();

        List<String> usernames = extraxtUsernames(input);
        List<String> validUsernames = matchValidUsernames(usernames);

        List<Integer> usernameSums = calculateUsernameSums(validUsernames);

        int max = Collections.max(usernameSums);

        String[] result = findMaxUsernames(usernameSums, validUsernames, max);

        if (result != null){
            System.out.println(result[0]);
            System.out.println(result[1]);
        }
    }

    private static String[] findMaxUsernames(List<Integer> usernameSums, List<String> usernames, int max) {
        for (int i = 0; i < usernameSums.size(); i++) {
            if(usernameSums.get(i) == max){
                return new String[] {usernames.get(i), usernames.get(i + 1)};
            }
        }

        return null;
    }


    private static List<Integer> calculateUsernameSums(List<String> validUsernames) {
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < validUsernames.size() - 1; i++) {
            int firstLength = validUsernames.get(i).length();
            int secondLength = validUsernames.get(i + 1).length();

            sums.add(firstLength + secondLength);
        }

        return sums;
    }

    private static List<String> matchValidUsernames(List<String> usernames) {
        String pattern = "^[a-zA-z][\\w]{2,24}$";
        Pattern validPattern = Pattern.compile(pattern);

        List<String> validUsernames = new ArrayList<>();

        Matcher matcher;
        for (String username:usernames) {
            matcher = validPattern.matcher(username);
            if (matcher.find()){
                validUsernames.add(username);
            }
        }

        return validUsernames;
    }

    private static List<String> extraxtUsernames(String input) {
        String text = input;
        String pattern = "(^|[\\/\\()\\s])(.+?)([\\/\\\\()\\s]|$)";
        //String pattern = "(^|[\\/\\()\\s])(.+?)([\\/\\\\()\\s]|$)";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(text);

        List<String> usernames = new ArrayList<>();

        while (matcher.find()){
            String match = matcher.group(2);

            usernames.add(match.trim());
            int startIndex = text.indexOf(match) + match.length();

            text = text.substring(startIndex);
            matcher = p.matcher(text);
        }

        return usernames;
    }
}
