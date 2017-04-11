package Problem_01_WithIterable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIteratorImpl<T> implements Iterable<T>, ListyIterator<T> {

    private List<T> data;
    private int index;

    public ListyIteratorImpl(T... items){
        this.data = Arrays.asList(items);
        this.index = 0;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        while (this.iterator().hasNext()) {
            action.accept(this.iterator().next());
        }
    }

    @Override
    public boolean move() {
        if (this.hasNext()) {
            this.iterator().next();
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.data.size() - 1;
    }

    @Override
    public void print() {
        if (this.iterator().hasNext()) {
            System.out.println(this.data.get(this.index));
        } else {
            throw new UnsupportedOperationException("Invalid operation!");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new InternalIterator();
    }

    private final class InternalIterator implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public T next() {
            return data.get(index++);
        }
    }

}
