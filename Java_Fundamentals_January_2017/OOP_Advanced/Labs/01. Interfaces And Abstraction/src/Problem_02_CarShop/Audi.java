package Problem_02_CarShop;

public class Audi implements Rentable {

    private String model;
    private String color;
    private int horsePower;
    private int minRentDays;
    private double pricePerDay;
    private String countryProduced;

    public void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setMinRentDays(int minRentDays) {
        this.minRentDays = minRentDays;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDays;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public String getCountryProduced() {
        return countryProduced;
    }

    public int getTires(){
        return Car.TIRES;
    }

    @Override
    public String toString() {
        String output = String.format("This is %s produced in %s and have %d tires",
                this.getModel(), this.getCountryProduced(), this.getTires());
        return output;
    }

    public Audi(String model, String color, int horsePower, String countryProduced, int minRentDays, double pricePerDay) {
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
        this.setCountryProduced(countryProduced);
        this.setMinRentDays(minRentDays);
        this.setPricePerDay(pricePerDay);
    }
}
