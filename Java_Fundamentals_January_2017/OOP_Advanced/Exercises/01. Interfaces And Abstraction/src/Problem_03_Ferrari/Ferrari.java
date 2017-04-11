package Problem_03_Ferrari;

public class Ferrari implements Car {

    private final String MODEL = "488-Spider";
    private String driverName;

    private void setDriverName(String name) {
        this.driverName = name;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        String output = String.format("%s/%s/%s/%s",
                MODEL, this.useBrakes(), this.pushGasPedal(), this.driverName);
        return output;
    }

    public Ferrari(String driverName) {
        this.setDriverName(driverName);
    }
}
