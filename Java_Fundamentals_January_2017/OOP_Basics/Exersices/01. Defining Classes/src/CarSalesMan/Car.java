package CarSalesMan;

public class Car {
    public String model;
    public Engine engine;
    public String weight;
    public String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String weight) {
        this (model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine) {
        this (model, engine, "n/a", "n/a");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return model + ":\n"
                + engine + "\n"
                +"  Weight: " + weight + "\n"
                + "  Color: " + color;
    }
}
