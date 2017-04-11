package Problem_05_BorderControl;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> intruders = new ArrayList<>();

        while (true) {
            String line = reader.readLine();

            if ("End".equals(line)) {
                break;
            }

            String[] data = line.split("\\s+");

            if (data.length == 3) {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];

                Citizen citizen = new Citizen(name, age, id);
                intruders.add(citizen);
            } else {
                String model = data[0];
                String id = data[1];

                Robot robot = new Robot(model, id);
                intruders.add(robot);
            }
        }

        String fakeIdLastDigits = reader.readLine();

        List<String> detainedIds = new ArrayList<>();

        for (Identifiable intruder : intruders) {

            String intruderId = intruder.getId();

            if (intruderId.endsWith(fakeIdLastDigits)) {
                detainedIds.add(intruderId);
            }
        }

        System.out.println(String.join("\n", detainedIds));
    }
}
