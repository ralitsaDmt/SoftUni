package Problem_11_Threeuple;

public class Threeuple<T, V, K> {

    private T firstItem;
    private V secondItem;
    private K thirdItem;

    private void setFirstItem(T firstItem) {
        this.firstItem = firstItem;
    }

    private void setSecondItem(V secondItem) {
        this.secondItem = secondItem;
    }

    private void setThirdItem(K thirdItem) { this.thirdItem = thirdItem; }

    public T getFirstItem() {
        return firstItem;
    }

    public V getSecondItem() {
        return secondItem;
    }

    public K getThirdItem() {
        return thirdItem;
    }

    public Threeuple(T firstItem, V secondItem, K thirdItem) {
        this.setFirstItem(firstItem);
        this.setSecondItem(secondItem);
        this.setThirdItem(thirdItem);
    }

    @Override
    public String toString() {
        String output = this.firstItem + " -> " + this.secondItem + " -> " + this.thirdItem;
        return output;
    }
}
