import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> playersNames = new LinkedHashSet<>();
        HashMap<String, HashSet<String>> playerCards = DrawCards(scan, playersNames);
        HashMap<String, Long> playerScore = countScore(playerCards);


        for(String player: playersNames){
            System.out.printf("%s: %s\n",
                    player, playerScore.get(player));
        }
    }

    private static HashMap<String, Long> countScore(HashMap<String, HashSet<String>> playerCards) {
        HashMap<String, Long> playerScore = new HashMap<>();

        for(String player : playerCards.keySet()){
            long score = 0;

            for(String card : playerCards.get(player)){
                String power = card.substring(0, card.length() - 1);
                String type = card.substring(card.length() - 1);

                score += calcType(type) * calcValue(power);
            }

            playerScore.put(player, score);
        }

        return playerScore;
    }

    private static HashMap<String, HashSet<String>> DrawCards(Scanner scan, LinkedHashSet<String> playersNames) {
        HashMap<String, HashSet<String>> playerCards = new HashMap<>();

        while(true){
            String[] input = scan.nextLine().split(":");
            if("JOKER".equals(input[0].toUpperCase())) break;

            String name = input[0];
            String[] tokens = input[1].trim().split(", ");

            if (!playerCards.containsKey(name)){
                playerCards.put(name, new HashSet<>());
            }
            Collections.addAll(playerCards.get(name), tokens);

            playersNames.add(name);
        }

        return playerCards;
    }

    private static int calcType(String type) {
        switch (type){
            case "S": return 4;
            case "H": return 3;
            case "D": return 2;
            case "C": return 1;
        }
        return 0;
    }

    private static int calcValue(String power) {
        switch (power){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10": return Integer.parseInt(power);
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
        }

        return 0;
    }
}
