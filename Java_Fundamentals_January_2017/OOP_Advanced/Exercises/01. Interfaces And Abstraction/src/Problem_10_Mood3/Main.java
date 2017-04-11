package Problem_10_Mood3;

import Problem_10_Mood3.contracts.IGameObject;
import Problem_10_Mood3.models.Archangel;
import Problem_10_Mood3.models.Demon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String inputLine = reader.readLine();
        String[] inputData = inputLine.split("\\s+");

        String username = inputData[0];
        String characterType = inputData[1];
        String specialPoints = inputData[2];
        int level = Integer.parseInt(inputData[3]);

        IGameObject gameObject;

        switch (characterType) {
            case "Demon":
                int demonPassword = generateDemonPassword(username);
                double energy = Double.parseDouble(specialPoints);
                gameObject = new Demon(username, demonPassword, energy, level);
                break;
            case "Archangel":
                String archangelPassword = generateArchangelPassword(username);
                int mana = Integer.parseInt(specialPoints);
                gameObject = new Archangel(username, archangelPassword, mana, level);
                break;
        }
    }

    private static int generateDemonPassword(String username) {
        int usernameLength = username.length();
        int password = usernameLength * 217;
        return password;
    }

    private static String generateArchangelPassword(String username) {
        String reversedUsername = reverseUsername(username);
        int usernameLength = username.length();

        String password = reversedUsername + usernameLength * 21;

        return password;
    }

    private static String reverseUsername(String username) {
        StringBuilder nameBuilder = new StringBuilder();

        for (int i = username.length() - 1; i >= 0; i--) {
            char nextChar = username.charAt(i);
            nameBuilder.append(nextChar);
        }

        return nameBuilder.toString();
    }

}
