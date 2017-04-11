package Problem_07_CustomList;

import java.util.List;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list){

        int leftIndex = 0;
        int rightIndex = 1;

        if (list.count() > 0) {
            while (leftIndex < list.count() - 1 && rightIndex < list.count()) {
                    T leftElement = list.get(leftIndex);
                    T rightElement = list.get(rightIndex);

                    if (leftElement.compareTo(rightElement) > 0) {
                        list.swap(leftIndex, rightIndex);
                        leftIndex = 0;
                        rightIndex = 1;
                    } else {
                        leftIndex++;
                        rightIndex++;
                    }
            }
        }
    }
}
