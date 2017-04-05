import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums= Stream.of(in.readLine().split("\\s+"))
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

        System.out.println(findMin.apply(nums));
    }
}
