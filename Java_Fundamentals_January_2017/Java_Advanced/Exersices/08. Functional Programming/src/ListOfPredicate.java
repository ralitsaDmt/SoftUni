import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfPredicate {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        Set<Integer> nums = Stream.of(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        BiPredicate<Integer, Integer> isDivisor = (x, y) -> x % y == 0;

        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int num :
                    nums) {
                if(!isDivisor.test(i, num)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.print(i + " ");
            }
        }
    }
}
