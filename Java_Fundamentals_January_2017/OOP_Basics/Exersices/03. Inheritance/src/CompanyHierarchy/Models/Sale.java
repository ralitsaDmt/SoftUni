package CompanyHierarchy.Models;

import CompanyHierarchy.Interfaces.ISale;

import java.util.Date;

public class Sale implements ISale {
    private String name;
    private Date date;
    private double price;

    public Sale (String name, Date date, double price) {
        this.setName(name);
        this.setDate(date);
        this.setPrice(price);
    }

    private void setName (String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }

        if (name.length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    private void setDate (Date date) {
        this.date = date;
    }

    private void setPrice (double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }

        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
