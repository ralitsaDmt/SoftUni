package Problem_11_Threeuple;

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
        String address = personAddressData[2];
        String town = personAddressData[3];

        Threeuple<String, String, String> personAddress = new Threeuple<>(fullName, address, town);
        System.out.println(personAddress.toString());

        String personBeerInput = reader.readLine();
        String[] personBeerData = personBeerInput.split("\\s+");
        String personName = personBeerData[0];
        int literOfBeer = Integer.parseInt(personBeerData[1]);
        String condition = personBeerData[2];

        boolean isDrunk = false;
        if ("drunk".equals(condition)) {
            isDrunk = true;
        }

        Threeuple<String, Integer, Boolean> personBeer = new Threeuple<>(personName, literOfBeer, isDrunk);
        System.out.println(personBeer.toString());

        String personAccount = reader.readLine();
        String[] personAccountData = personAccount.split("\\s+");
        String name = personAccountData[0];
        double balance = Double.parseDouble(personAccountData[1]);
        String currency = personAccountData[2];

        Threeuple<String, Double, String> account = new Threeuple<>(name, balance, currency);
        System.out.println(account);

    }
}
