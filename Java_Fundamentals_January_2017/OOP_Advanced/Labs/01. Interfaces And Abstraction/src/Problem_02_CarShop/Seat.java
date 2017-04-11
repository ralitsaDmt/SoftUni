package Problem_02_CarShop;

import java.io.Serializable;

public class Seat implements Sellable {

    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;
    private double price;

    private void setPrice(double price) {
        this.price = price;
    }

    private void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
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
    public double getPrice() {
        return this.price;
    }

    public String getCountryProduced(){
        return this.countryProduced;
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

    public Seat(String model, String color, int horsePower, String countryProduced, double price) {
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
        this.setCountryProduced(countryProduced);
        this.setPrice(price);
    }
}
