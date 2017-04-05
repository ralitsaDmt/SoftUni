package needForSpeed.models.cars;

public abstract class Car {
    private String brand;
    private String model;
    private long yearOfProduction;
    private long horsePower;
    private long acceleration;
    private long suspension;
    private long durability;

    Car(String brand, String model, int yearOfProduction, int horsePower, int acceleration, int suspension, int durability){
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsePower(horsePower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public long getYearOfProduction() {
        return yearOfProduction;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public long getHorsePower() {
        return horsePower;
    }

    protected void setHorsePower(long horsePower) {
        this.horsePower = horsePower;
    }

    public long getAcceleration() {
        return acceleration;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public long getSuspension() {
        return suspension;
    }

    protected void setSuspension(long suspension) {
        this.suspension = suspension;
    }

    public long getDurability() {
        return durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        String brandModelYearLine = String.format("%s %s %d\n",
                this.getBrand(), this.getModel(), this.getYearOfProduction());
        String horsePowerAccelerationLine = String.format("%d HP, 100 m/h in %d s\n",
                this.getHorsePower(), this.getAcceleration());
        String suspensionDurabilityLine = String.format("%d Suspension force, %d Durability\n",
                this.getSuspension(), this.getDurability());

        builder.append(brandModelYearLine)
                .append(horsePowerAccelerationLine)
                .append(suspensionDurabilityLine);

        return builder.toString();
    }

    public long getCasualPerformancePoints(){
        return (this.getHorsePower() / this.getAcceleration()) + (this.getSuspension() + this.getDurability());
    }

    public long getDragPerformancePoints(){
        return this.getHorsePower() / this.getAcceleration();
    }

    public long getDriftHorsePoints(){
        return this.getSuspension() + this.getDurability();
    }

    public abstract void getTuned(int tuneIndex, String addOn);
}
