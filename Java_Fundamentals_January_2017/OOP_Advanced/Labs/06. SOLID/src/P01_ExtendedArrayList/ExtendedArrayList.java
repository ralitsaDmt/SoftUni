package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ExtendedArrayList<E extends Comparable> extends ArrayList<E> {
    public E max(){
        E max = null;
        Iterator<E> iterator = super.iterator();

        while (iterator.hasNext()) {
            E element = iterator.next();
            if (max == null || element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public E min(){
        E min = null;
        Iterator<E> iterator = super.iterator();

        while (iterator.hasNext()) {
            E element = iterator.next();
            if (min == null || element.compareTo(min) < 0){
                min = element;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ExtendedArrayList<Integer> list = new ExtendedArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.min());
        System.out.println(list.max());
    }
}
