package models.engines;

public class SterndriveBoatEngine extends BoatEngineImpl {
    private static final int Multiplier = 7;

    public SterndriveBoatEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        int output = (this.getHorsepower() * Multiplier) + this.getDisplacement();
        return output;
    }
}
