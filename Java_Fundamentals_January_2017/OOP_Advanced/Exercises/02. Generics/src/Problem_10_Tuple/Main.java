package Problem_10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String personAddressInput = reader.readLine();
        String[] personAddressData = personAddressInput.split("\\s+");
        String firstName = personAddressData[0];
        String lastName = personAddressData[1];
        String fullName = firstName + " " + lastName;
        String city = personAddressData[2];

        Tuple<String, String> personAddress = new Tuple<>(fullName, city);
        System.out.println(personAddress.toString());

        String personBeerInput = reader.readLine();
        String[] personBeerData = personBeerInput.split("\\s+");
        String personName = personBeerData[0];
        int literOfBeer = Integer.parseInt(personBeerData[1]);

        Tuple<String, Integer> personBeer = new Tuple<>(personName, literOfBeer);
        System.out.println(personBeer.toString());

        String numbersInput = reader.readLine();
        String[] numbersData = numbersInput.split("\\s+");
        int firstNumber = Integer.parseInt(numbersData[0]);
        double secondNumber = Double.parseDouble(numbersData[1]);

        Tuple<Integer, Double> numbers = new Tuple<>(firstNumber, secondNumber);
        System.out.println(numbers.toString());
    }
}
