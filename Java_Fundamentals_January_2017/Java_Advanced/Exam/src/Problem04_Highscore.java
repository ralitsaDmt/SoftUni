import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem04_Highscore {

    private static Map<String, Long> playerScore;
    private static Map<String, List<String>> playerOpponents;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        playerScore = new LinkedHashMap<>();
        playerOpponents = new LinkedHashMap<>();

        while (true){
            String input = in.readLine();
            if (input.equals("osu!")){
                break;
            }

            String[] duel = input.split("<->");
            String[] firstPlayerInfo = duel[0].split("\\s+");
            String[] secondPlayerInfo = duel[1].split("\\s+");


            Integer firstScore = Integer.parseInt(firstPlayerInfo[0]);
            String firstName = firstPlayerInfo[1];
            String secondName = secondPlayerInfo[0];
            Integer secondScore = Integer.parseInt(secondPlayerInfo[1]);

            if (!playerScore.containsKey(firstName)){
                playerScore.put(firstName, (long)0);
            }

            if (!playerScore.containsKey(secondName)){
                playerScore.put(secondName, (long)0);
            }

            if (!playerOpponents.containsKey(firstName)){
                playerOpponents.put(firstName, new LinkedList<>());
            }

            if (!playerOpponents.containsKey(secondName)){
                playerOpponents.put(secondName, new LinkedList<>());
            }

            Integer difference = Math.abs(firstScore - secondScore);

            String firstDuel;
            String secondDuel;

            if (firstScore > secondScore){
                playerScore.put(firstName, playerScore.get(firstName) + difference);
                playerScore.put(secondName, playerScore.get(secondName) - difference);

                firstDuel = secondName + " <-> " + difference;
                secondDuel = firstName + " <-> " + (-1 * difference);
            }
            else if (firstScore < secondScore){
                playerScore.put(firstName, playerScore.get(firstName) - difference);
                playerScore.put(secondName, playerScore.get(secondName) + difference);

                firstDuel = secondName + " <-> " + ( -1 * difference);
                secondDuel = firstName + " <-> " + difference;
            }
            else {
                firstDuel = secondName + " <-> " + difference;
                secondDuel = firstName + " <-> " + difference;
            }

            playerOpponents.get(firstName).add(firstDuel);
            playerOpponents.get(secondName).add(secondDuel);
        }

        playerScore.entrySet().stream()
                .sorted( (k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach( e -> {
                    System.out.println(e.getKey() + " - (" + e.getValue() + ")");
                    for (String duel:playerOpponents.get(e.getKey())) {
                        System.out.println("*   " + duel);
                    }
                });
    }
}
