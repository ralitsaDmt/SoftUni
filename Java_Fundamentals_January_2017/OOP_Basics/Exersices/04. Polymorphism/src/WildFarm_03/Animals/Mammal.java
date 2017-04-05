package WildFarm_03.Animals;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    protected void setLivingRegion(String region) {
        this.livingRegion = region;
    }

    public String getLivingRegion(){
        return this.livingRegion;
    }

    public Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.setLivingRegion(livingRegion);
    }

    @Override
    public String toString() {

        String formattedWeight = formatWeight(this.getAnimalWeight());

        formattedWeight = formattedWeight.replace(",", ".");

        String message = String.format("%s[%s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                formattedWeight,
                this.getLivingRegion(),
                this.getFoodEaten());
        return message;
    }

    protected static String formatWeight(double weight)
    {
        if(weight == (long) weight)
            return String.format("%d",(long)weight);
        else
            return String.format("%s",weight);
    }
}
