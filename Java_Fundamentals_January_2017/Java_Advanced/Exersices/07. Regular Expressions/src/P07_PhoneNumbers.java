import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P07_PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phonebook = readEntries(in);
        PrintPhonebook(phonebook);
    }

    private static void PrintPhonebook(Map<String, String> phonebook) {

        if(phonebook.size() == 0){
            System.out.println("<p>No matches!</p>");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<ol>");

        for (String name: phonebook.keySet()) {
            sb.append(String.format("<li><b>%s:</b> %s</li>", name, phonebook.get(name)));
        }

        //sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("</ol>");

        System.out.println(sb);
    }


    private static Map<String, String> readEntries(BufferedReader in) throws IOException {
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (true){
            String line = in.readLine();
            if(line.equals("END")) break;

            Pattern pattern = Pattern.compile("([A-Z]+[a-z]*)([^a-zA-Z+]+?)(\\+?[0-9][0-9()\\/\\.\\-\\s]+[0-9])");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()){
                String name = matcher.group(1);
                String phoneNumber = matcher.group(3);

                phoneNumber = cleanNumbers(phoneNumber);

                phonebook.put(name, phoneNumber);
            }
        }

        return phonebook;
    }

    private static String cleanNumbers(String phoneNumber) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < phoneNumber.length(); i++) {
            char ch = phoneNumber.charAt(i);
            if(ch != '('
                    && ch != ')'
                    && ch != '/'
                    && ch != '.'
                    && ch != '-'
                    && ch != ' '){
                sb.append(phoneNumber.charAt(i));
            }
        }

        return sb.toString();
    }
}
