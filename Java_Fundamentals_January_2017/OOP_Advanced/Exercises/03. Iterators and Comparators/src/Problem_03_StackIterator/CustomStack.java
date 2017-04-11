package Problem_03_StackIterator;

public interface CustomStack<T> extends Iterable<T> {
    void push(T item);

    T pop();
}
