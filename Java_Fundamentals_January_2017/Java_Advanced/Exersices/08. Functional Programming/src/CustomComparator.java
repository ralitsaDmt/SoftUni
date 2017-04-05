import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Stream.of(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isOdd = x -> x % 2 != 0;

        List<Integer> evenNums = nums.stream()
                .filter(isEven).collect(Collectors.toList());
        List<Integer> oddNums = nums.stream()
                .filter(isOdd).collect(Collectors.toList());

        Collections.sort(evenNums);
        Collections.sort(oddNums);

        evenNums.forEach(x -> System.out.print(x + " "));
        oddNums.forEach(x -> System.out.print(x + " "));
    }
}
