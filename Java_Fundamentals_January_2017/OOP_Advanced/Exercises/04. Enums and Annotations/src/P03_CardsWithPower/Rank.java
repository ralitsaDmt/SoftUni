package P03_CardsWithPower;

@CustomAnnotation(category = "Rank", description = "Provides rank constants for a Card class.")
public enum Rank {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int value;

    Rank(int value){
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
