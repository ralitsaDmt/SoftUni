package P01_CardSuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Suit[] suits = Suit.values();

        System.out.println(input + ":");
        for (Suit suit : suits) {
            System.out.println(suit);
        }
    }
}
