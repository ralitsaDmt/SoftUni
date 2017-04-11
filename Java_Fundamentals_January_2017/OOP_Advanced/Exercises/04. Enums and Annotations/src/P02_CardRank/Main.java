package P02_CardRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Rank[] ranks = Rank.values();

        System.out.println(input + ":");
        for (Rank rank : ranks) {
            System.out.println(rank);
        }
    }
}
