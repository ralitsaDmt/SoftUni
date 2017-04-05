import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));


        int[] arr = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Integer[] intArr = new Integer[arr.length];
        int i = 0;
        for (int value : arr) {
            intArr[i++] = value;
        }

        Stream<Integer> numbers = Arrays.stream(intArr);

        numbers.filter(x -> x >= 10 && x <= 20)
                .distinct()
                .limit(2)
                .forEach(x -> System.out.print(x + " "));

    }
}
