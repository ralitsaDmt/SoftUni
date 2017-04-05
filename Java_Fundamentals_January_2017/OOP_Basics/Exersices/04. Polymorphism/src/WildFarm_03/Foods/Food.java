package WildFarm_03.Foods;

public abstract class Food {
    private int quantity;

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    protected Food(int quantity){
        this.setQuantity(quantity);
    }
}
