package P02_CardRank;

public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    @Override
    public String toString() {

        int ordinalValue = this.ordinal();
        String nameValue = this.name();

        String output = String.format("Ordinal value: %s; Name value: %s",
                ordinalValue, nameValue);
        return output;
    }
}
