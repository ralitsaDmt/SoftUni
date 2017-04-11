package P10_InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        CommandInterpreter interpreter = new CommandInterpreter();

        while (true) {
            String line = reader.readLine();
            String[] data = line.split(";");
            String command = data[0];
            interpreter.interpretCommand(command, data);
            if ("END".equals(line)) {
                break;
            }
        }
    }
}
