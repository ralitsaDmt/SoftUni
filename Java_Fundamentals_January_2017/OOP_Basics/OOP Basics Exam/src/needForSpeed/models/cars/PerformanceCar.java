package needForSpeed.models.cars;

import java.util.LinkedList;
import java.util.List;

public class PerformanceCar extends Car {

    private static final int HORSEPOWER_DIVISOR = 2;
    private static final int SUSPENSION_DIVISOR = 4;

    private List<String> addOns;
    private int tuneIndex;


    public PerformanceCar(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
        this.addOns = new LinkedList<>();
        this.tuneIndex = 0;
    }

    @Override
    public long getHorsePower() {
        long increasedHorsePower = this.calculateHorsePower(super.getHorsePower()) + tuneIndex;
        return increasedHorsePower;
    }

    @Override
    public long getSuspension() {
        return this.calculateSuspension(super.getSuspension()) + (tuneIndex / 2);
    }

    private long calculateHorsePower(long horsePower){
        return horsePower + horsePower / HORSEPOWER_DIVISOR;
    }

    private long calculateSuspension(long suspension){
        return suspension - (suspension / SUSPENSION_DIVISOR);
    }

    @Override
    public void getTuned(int tuneIndex, String addOn) {
        this.tuneIndex += tuneIndex;
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {

        String addOnsLine = "Add-ons: ";

        addOnsLine += this.addOns.size() != 0 ? String.join(", ", this.addOns) : "None";

        String performanceCarOutput = super.toString() + addOnsLine;

        return performanceCarOutput;
    }
}
