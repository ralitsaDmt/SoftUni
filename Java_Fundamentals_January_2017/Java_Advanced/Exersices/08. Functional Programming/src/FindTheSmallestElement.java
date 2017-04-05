import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Stream.of(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findMin = x -> {
            int min = Integer.MAX_VALUE;

            for(Integer num:x){
                if(num < min) min = num;
            }

            return min;
        };

        int min = findMin.apply(nums);

        System.out.println(nums.lastIndexOf(min));
    }
}
