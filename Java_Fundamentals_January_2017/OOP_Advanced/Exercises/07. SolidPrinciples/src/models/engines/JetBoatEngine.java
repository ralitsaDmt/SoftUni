package models.engines;

public class JetBoatEngine extends BoatEngineImpl {
    private static final int Multiplier = 5;

    public JetBoatEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getOutput() {
        int output = (super.getHorsepower() * Multiplier) + super.getDisplacement();
        return output;
    }
}
