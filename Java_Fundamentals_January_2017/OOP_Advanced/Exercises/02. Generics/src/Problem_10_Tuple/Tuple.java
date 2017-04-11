package Problem_10_Tuple;

public class Tuple<T, V> {

    private T firstItem;
    private V secondItem;

    private void setFirstItem(T firstItem) {
        this.firstItem = firstItem;
    }

    private void setSecondItem(V secondItem) {
        this.secondItem = secondItem;
    }

    public Tuple(T firstItem, V secondItem) {
        this.setFirstItem(firstItem);
        this.setSecondItem(secondItem);
    }

    @Override
    public String toString() {
        String output = this.firstItem + " -> " + this.secondItem;
        return output;
    }
}
