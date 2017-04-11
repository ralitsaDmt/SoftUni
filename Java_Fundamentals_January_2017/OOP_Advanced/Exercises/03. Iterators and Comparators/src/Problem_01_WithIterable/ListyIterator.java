package Problem_01_WithIterable;

public interface ListyIterator<T> extends Iterable<T> {

    boolean move();

    boolean hasNext();

    void print();
}
