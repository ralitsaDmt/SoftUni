import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split("\\s+");

        int lower = Integer.parseInt(input[0]);
        int upper = Integer.parseInt(input[1]);

        String filter = in.readLine();

        Predicate<Integer> findEvenOdd = createPredicate(filter);

        List<Integer> nums = new ArrayList<>();
        for (int i = lower; i <= upper; i++) {
            if(findEvenOdd.test(i)){
                System.out.print(i + " ");
            }
        }
    }

    static Predicate<Integer> createPredicate(String filter) {
        switch (filter){
            case "even": return x -> x % 2 ==0;
            case "odd": return x -> x % 2 != 0;
            default: return x -> true;
        }
    }
}
