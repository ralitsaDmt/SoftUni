package ShoppingSpree;

public class Product {

    private String name;
    private Double cost;

    public Product(String name, Double cost){
        this.setName(name);
        this.setCost(cost);
    }

    public Double getCost(){
        return this.cost;
    }

    void setName(String name){
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    void setCost(Double cost){
        if (cost < 0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }

        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
