package needForSpeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        CarManager manager = new CarManager();

        while (true) {
            String line = reader.readLine();
            if ("Cops Are Here".equals(line)) {
                break;
            }

            int index = line.indexOf(" ");
            String command = line.substring(0, index);
            String dataLine = line.substring(index + 1);
            String[] data = dataLine.split("\\s+");

            manager.interpretCommand(command, data);
        }

        System.out.println();
    }
}
