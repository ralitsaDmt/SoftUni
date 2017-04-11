package P03_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        // Problem 05_Card compareTo()
//        Card firstCard = drawCard(reader);
//        Card secondCard = drawCard(reader);
//
//        Card greaterCard = firstCard.compareTo(secondCard) > 0 ? firstCard : secondCard;
//
//        System.out.println(greaterCard);

        //Problem 06 Custom Enum Annotation
//
//        String item = reader.readLine();
//
//        Class annotatedClass = null;
//
//        switch (item) {
//            case "Rank":
//                annotatedClass = Rank.class;
//                break;
//            case "Suit":
//                annotatedClass = Suit.class;
//                break;
//        }
//
//        assert annotatedClass != null;
//        CustomAnnotation annotation = (CustomAnnotation)annotatedClass.getAnnotation(CustomAnnotation.class);
//
//        String type = annotation.type();
//        String description = annotation.description();
//
//        String output = String.format("Type = %s, Description = %s", type, description);
//
//        System.out.println(output);

        // Problem 07 Deck of Cards
//
//        String input = reader.readLine();
//        List<Card> deck = new ArrayList<>();
//
//        Suit[] suits = Suit.values();
//        Rank[] ranks = Rank.values();
//
//        for (Suit suit : suits) {
//            String suitName = suit.name();
//
//            for (Rank rank : ranks) {
//                String rankName = rank.name();
//
//                Card card = new Card(rankName, suitName);
//                deck.add(card);
//            }
//        }
//
//        for (Card card : deck) {
//            System.out.println(card);
//        }

        // Problem 08 Card Game


        List<Card> deck = fillCards();

        Player firstPlayer = createPlayer(reader);
        Player secondPlayer = createPlayer(reader);

        drawCards(firstPlayer, reader, deck);
        drawCards(secondPlayer, reader, deck);

        Player winner = findWinner(firstPlayer, secondPlayer);

        System.out.println(winner);
    }

    private static List<Card> fillCards() {
        List<Card> deck = new ArrayList<>();

        Suit[] suits = Suit.values();
        Rank[] ranks = Rank.values();

        for (Suit suit : suits) {
            String suitName = suit.name();

            for (Rank rank : ranks) {
                String rankName = rank.name();

                Card card = new Card(rankName, suitName);
                deck.add(card);
            }
        }

        return deck;
    }

    private static Player createPlayer(BufferedReader reader) throws IOException {
        String name = reader.readLine();
        Player player = new Player(name);
        return player;
    }

    private static void drawCards(Player player, BufferedReader reader, List<Card> deck) throws IOException {
        while (player.cardsCount() < 5) {

            Card card = null;

            try {
                card = drawCard(reader);

                boolean isCardAvaialble = checkIfCardIsAvailable(card, deck);

                if (isCardAvaialble){
                    deck.remove(card);
                    player.drawCard(card);
                } else {
                    System.out.println("Card is not in the deck.");
                }

            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private static boolean checkIfCardIsAvailable(Card card, List<Card> deck) {

        for (Card deckCard : deck) {
            if (deckCard.compareTo(card) == 0) {
                return true;
            }
        }
        return false;
    }

    private static Card drawCard(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        String[] data = input.split(" of ");
        String rankName = data[0];
        String suitName = data[1];

        Card card = new Card(rankName, suitName);
        return card;
    }

    private static Player findWinner(Player firstPlayer, Player secondPlayer){

        Card firstPlayerHighestCard = firstPlayer.getHighestCard();
        Card secondPlayerHighestCard = secondPlayer.getHighestCard();

        Player winner = null;
        if (firstPlayerHighestCard.compareTo(secondPlayerHighestCard) > 0) {
            winner = firstPlayer;
        } else {
            winner = secondPlayer;
        }

        return winner;
    }

//    private static Card drawCard(BufferedReader reader) throws IOException {
//        String rank = reader.readLine();
//        String suit = reader.readLine();
//
//        Card card = new Card(rank, suit);
//        return card;
//    }
}
