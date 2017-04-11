package P03_CardsWithPower;

public class Card implements Comparable {

    private Suit suit;
    private Rank rank;

    public Card(String rankName, String suitName){
        this.setSuit(suitName);
        this.setRank(rankName);
    }

    private void setSuit(String suitName){

        boolean isSuitNameValid = this.suitsContainSuitName(suitName);

        if (!isSuitNameValid) {
            throw new IllegalArgumentException("No such card exists.");
        }

        this.suit = Enum.valueOf(Suit.class, suitName);
    }

    private void setRank(String rankName){
        boolean isRankNameValid = this.ranksContainRankName(rankName);

        if (!isRankNameValid){
            throw new IllegalArgumentException("No such card exists.");
        }

        this.rank = Enum.valueOf(Rank.class, rankName);
    }

//    public Suit getSuit(){
//        return this.suit;
//    }
//
//    public Rank getRank(){
//        return this.rank;
//    }

    private boolean ranksContainRankName(String rankName) {
        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            if (rank.name().equals(rankName)){
                return true;
            }
        }
        return false;
    }

    private boolean suitsContainSuitName(String suitName){
        Suit[] suits = Suit.values();

        for (Suit suit : suits) {
            if (suit.name().equals(suitName)) {
                return true;
            }
        }

        return false;
    }

    private int getPower(){
        int suitPower = this.suit.getValue();
        int rankPower = this.rank.getValue();

        int totalPower = suitPower + rankPower;
        return totalPower;
    }

    @Override
    public boolean equals(Object o) {
        Card other = (Card)o;

        return this.compareTo(other) == 0;
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
//        String output = String.format("Card name: %s of %s; Card power: %s",
//                this.rank.name(), this.suit.name(), this.getPower());

        String output = String.format("%s of %s",
                this.rank.name(), this.suit.name());

        return output;
    }

    @Override
    public int compareTo(Object o) {
        Card otherCard = (Card)o;
        int comparisonResult = this.getPower() - otherCard.getPower();
        return comparisonResult;
    }
}
