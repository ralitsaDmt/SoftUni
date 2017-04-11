package P09_TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<TrafficLight> trafficLights = new ArrayList<>();
        String[] input = reader.readLine().split("\\s+");

        for (String signal : input) {
            TrafficLight light = new TrafficLight(signal);
            trafficLights.add(light);
        }

        int countOfChanges = Integer.parseInt(reader.readLine());

        for (int i = 0; i < countOfChanges; i++) {
            StringBuilder builder = new StringBuilder();

            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeSignal();
                builder.append(trafficLight.getSignal());
                builder.append(" ");
            }

            String output = builder.toString().trim();
            System.out.println(output);
        }
    }
}
