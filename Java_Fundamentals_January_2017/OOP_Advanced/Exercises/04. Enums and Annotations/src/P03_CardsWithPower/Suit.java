package P03_CardsWithPower;

@CustomAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum Suit {

    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int value;

    Suit(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {

        int ordinalValue = this.ordinal();
        String nameValue = this.name();

        String output = String.format("Ordinal value: %s; Name value: %s",
                ordinalValue, nameValue);
        return output;
    }
}
