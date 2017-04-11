package Problem_04_Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {

    private List<T> rocks;

    public Lake(T... items){
        this.rocks = Arrays.asList(items);
    }

    @Override
    public Iterator iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {

        int evenIndex = 0;
        int oddIndex = 1;

        @Override
        public boolean hasNext() {
            if (this.evenIndex < rocks.size()) {
                return true;
            }

            return this.oddIndex < rocks.size();
        }

        @Override
        public T next() {
            if (evenIndex < rocks.size()){
                T nextEvenRock = rocks.get(evenIndex);
                evenIndex += 2;
                return nextEvenRock;
            }

            if (oddIndex < rocks.size()) {
                T nextOddRock = rocks.get(oddIndex);
                oddIndex += 2;
                return nextOddRock;
            }

            return null;
        }
    }
}
