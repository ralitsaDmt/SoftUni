package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static Map<String, Cat> cats;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        cats = new LinkedHashMap<>();

        while (true){
            String input = in.readLine();
            if (input.equals("End")){
                break;
            }

            String[] splitInput = input.split("\\s+");

            String breed = splitInput[0];
            String name = splitInput[1];
            String prop = splitInput[2];

            switch (breed){
                case "Siamese": cats.put(name, new Siamese(name, prop)); break;
                case "Cymric": cats.put(name, new Cymric(name, prop)); break;
                case "StreetExtraordinaire": cats.put(name, new StreetExtraordinaire(name, prop)); break;
            }
        }

        String nameToPrint = in.readLine();

        Cat catToPrint = cats.get(nameToPrint);

        System.out.println(catToPrint);
    }
}
