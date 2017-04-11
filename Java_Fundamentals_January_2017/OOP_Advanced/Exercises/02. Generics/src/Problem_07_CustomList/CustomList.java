package Problem_07_CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<T>();
    }

    public void add(T element){
        this.list.add(element);
    }

    public void remove(int index){
        this.list.remove(index);
    }

    public boolean contains(T element){
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex){
        T temporaryElement = this.list.get(firstIndex);

        this.list.set(firstIndex, this.list.get(secondIndex));
        this.list.set(secondIndex, temporaryElement);
    }

    public long countGreaterThan(T element){
        long count = this.list.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
        return count;
    }

    public T getMax(){
        if (this.list.size() > 0){

            T maxElement = this.list.get(0);

            for (T element : list) {
                if (element.compareTo(maxElement) > 0){
                    maxElement = element;
                }
            }
            return maxElement;
        }
        return null;
    }

    public T getMin(){
        if (this.list.size() > 0){

            T minElement = this.list.get(0);

            for (T element : list) {
                if (element.compareTo(minElement) < 0){
                    minElement = element;
                }
            }
            return minElement;
        }
        return null;
    }

    public T get(int index){
        return this.list.get(index);
    }

    public int count(){
        return this.list.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T t : list) {
            builder.append(t)
                    .append("\n");
        }

        String output = builder.substring(0, builder.length() - 1);
        return output;
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
