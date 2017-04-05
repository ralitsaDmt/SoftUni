import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nums = Stream.of(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int divide = Integer.parseInt(in.readLine());

        Consumer<List<Integer>> reverse = x ->{
            for (int i = 0; i < x.size() /2; i++) {
                int temp = x.get(i);
                x.set(i, x.get(x.size() - i - 1));
                x.set(x.size() - i - 1, temp);
            }
        };

        BiPredicate<Integer, Integer> isDivisible = (x, y) -> x % y != 0;

        reverse.accept(nums);
        nums.forEach(x -> {
            if (isDivisible.test(x, divide)) System.out.print(x + " ");
        });

        nums.stream().filter(x->isDivisible.test(x,divide)).forEach(n->{
            System.out.print(n + " ");
        });
    }
}
