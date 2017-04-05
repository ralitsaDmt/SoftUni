package ShoppingSpree;

import java.util.ArrayList;

public class Person {

    private String name;
    private Double money;
    private ArrayList<Product> products;

    public Person(String name, Double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    void setName(String name){
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    void setMoney(Double money){
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public void buyProduct(Product product){
        if (this.money < product.getCost()){
            throw new IllegalArgumentException("%s can't afford %s");
        }

        this.money -= product.getCost();
        this.products.add(product);
    }

    @Override
    public String toString() {

        if (this.products.size() > 0){
            StringBuilder sb = new StringBuilder();
            sb.append(this.name + " - ");
            for (Product product : this.products) {
                sb.append(product.toString() + ", ");
            }

            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        } else {
            return this.name  + " - Nothing bought";
        }
    }
}
