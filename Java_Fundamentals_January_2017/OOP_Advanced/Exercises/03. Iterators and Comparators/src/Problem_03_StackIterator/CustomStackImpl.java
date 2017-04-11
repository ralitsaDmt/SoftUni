package Problem_03_StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStackImpl<T> implements CustomStack<T>, Iterable<T> {
    private List<T> elements;

    public CustomStackImpl(){
        this.elements = new ArrayList<T>();
    }

    @Override
    public void push(T item) {
        this.elements.add(item);
    }

    @Override
    public T pop() {
        int lastIndex = this.elements.size() - 1;

        if (lastIndex < 0) {
            throw new IndexOutOfBoundsException("No elements");
        }

        T item = this.elements.get(lastIndex);
        this.elements.remove(lastIndex);
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    public final class StackIterator implements Iterator<T> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index <= elements.size() - 1;
        }

        @Override
        public T next() {
            if (this.index < elements.size()){
                T item = elements.get(index);
                index++;
                return item;
            }
            throw new IndexOutOfBoundsException("No elements");
        }
    }
}
