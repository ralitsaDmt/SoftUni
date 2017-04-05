package systemsplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        TheSystem system = new TheSystem();

        String line = reader.readLine();

        String commandPattern = "([A-Za-z]+)\\((.*)\\)";

        Pattern pattern = Pattern.compile(commandPattern);

        while (!"System Split".equals(line)) {

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String command = matcher.group(1);
                String[] data = matcher.group(2).split(", ");

                system.interpretCommand(command, data);
            }

            line = reader.readLine();
        }

        system.interpretCommand("System Split", new String[]{});
    }
}
