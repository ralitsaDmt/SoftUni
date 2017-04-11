package P03_CardsWithPower;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawCard(Card card){
        this.hand.add(card);
    }

    public int cardsCount(){
        return this.hand.size();
    }

    public Card getHighestCard(){
        Card highestCard = this.hand.get(0);

        for (Card card : hand) {
            if (highestCard.compareTo(card) < 0) {
                highestCard = card;
            }
        }
        return highestCard;
    }

    @Override
    public String toString() {
        Card highestCard = this.getHighestCard();

        String output = String.format("%s wins with %s.",
                this.name, highestCard.toString());
        return output;
    }
}
