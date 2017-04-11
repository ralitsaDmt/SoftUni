package P01_CardSuits;

public enum Suit {

    CLUBS, DIAMONDS, HEARTS, SPADES;


    @Override
    public String toString() {

        int ordinalValue = this.ordinal();
        String nameValue = this.name();

        String output = String.format("Ordinal value: %s; Name value: %s",
                ordinalValue, nameValue);
        return output;
    }
}
