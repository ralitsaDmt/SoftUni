import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_ReplaceATag {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("(<a)(\\shref=\".*\")(>)(.*)(</a>)");

        StringBuilder sb = new StringBuilder();
        while (true){
            String line = in.readLine();
            if(line.equals("END")) break;

            line= line.replaceAll("\\s+", " ");
            sb.append(line)
            .append("\n");
        }

        String str = sb.toString();
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()){
            String replacer = "[URL" + matcher.group(2) + "]" + matcher.group(4) + "[/URL]";
            str = str.replace(matcher.group(), replacer);
        }

        System.out.println(str);
    }
}
