package Problem_06_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Birthable> birthables = new ArrayList<>();

        while (true) {
            String line = reader.readLine();

            if ("End".equals(line)) {
                break;
            }

            String[] data = line.split("\\s+");

            String kind = data[0];

            Birthable birthable = null;

            if ("Citizen".equals(kind)) {
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String id = data[3];
                String birthdate = data[4];

                birthable = new Citizen(name, age, id, birthdate);
            } else if ("Pet".equals(kind)) {
                String name = data[1];
                String birthdate = data[2];

                birthable = new Pet(name, birthdate);
            }

            if (birthable != null) {
                birthables.add(birthable);
            }
        }

        String year = reader.readLine();

        Pattern pattern = Pattern.compile(year);

        for (Birthable birthable : birthables) {

            String birthdate = birthable.getBirthdate();
            Matcher matcher = pattern.matcher(birthdate);

            if (matcher.find()) {
                System.out.println(birthdate);
            }
        }
    }
}
