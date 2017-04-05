import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10_QueryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String p = "((^.+?\\?)|(^)|&)(.+?)=(.+?)$";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher;

        while (true){
            String data = in.readLine();
            if("END".equals(data)) break;

            String[] splitData = data.split("&");

            Map<String, List<String>> queries = new LinkedHashMap<>();

            for (String token:splitData) {
                matcher = pattern.matcher(token);
                if (matcher.find()){
                    String field = matcher.group(4);
                    String value = matcher.group(5);

                    Pattern spaces = Pattern.compile("\\s+");
                    Matcher matchSpaces;


                    field = field.replace("%20", " ");
                    field = field.replace("+", " ");

                    matchSpaces = spaces.matcher(field);
                    if(matchSpaces.find()){field = field.replace(matchSpaces.group(), " ");

                    }

                    field = field.trim();
                    value = value.replace("%20", " ");
                    value = value.replace("+", " ");

                    matchSpaces = spaces.matcher(value);
                    if(matchSpaces.find()){
                        value = value.replace(matchSpaces.group(), " ");
                    }

                    value = value.trim();

                    if (!queries.containsKey(field)){
                        queries.put(field, new ArrayList<>());
                    }

                    queries.get(field).add(value);
                }
            }

            for (Map.Entry<String, List<String>> entry:queries.entrySet()){
                String key = entry.getKey();
                List<String> value = entry.getValue();

                System.out.print(key + "=" + value);
            }

            System.out.println();

//            for(Map.Entry<String, HashMap> entry : selects.entrySet()) {
//                String key = entry.getKey();
//                HashMap value = entry.getValue();
//
//                // do what you have to do here
//                // In your case, an other loop.
//            }
        }
    }
}
