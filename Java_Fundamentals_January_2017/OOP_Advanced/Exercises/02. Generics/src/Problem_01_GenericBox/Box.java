package Problem_01_GenericBox;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>>{

    private T value;

    public T getValue(){
        return this.value;
    }

    private void setValue(T value){
        this.value = value;
    }

    public Box(T value){
        this.setValue(value);
    }

    @Override
    public String toString() {
        String output = String.format("%s: %s", this.value.getClass().getName(), this.value);
        return output;
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.value.compareTo(o.getValue());
    }
}
