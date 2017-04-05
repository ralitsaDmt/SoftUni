package CarSalesMan;

public class Engine {
    private String model;
    private String power;
    private String displacement;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    private String efficiency;

    public Engine(String model, String power, String displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, String power) {
        this(model, power, "n/a", "n/a");
    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return "  " + model + ":\n" +
                "    Power: " + power + "\n" +
                "    Displacement: " + displacement + "\n" +
                "    Efficiency: " + efficiency;
    }
}
