import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split("\\s+");
        List<Integer> nums = new ArrayList<Integer>();
        for(String s: input) nums.add(Integer.parseInt(s));

        Function<List<Integer>, List<Integer>> add = x -> {
            return x.stream().map(n -> n + 1).collect(Collectors.toList());
        };
        Function<List<Integer>, List<Integer>> multiply = x -> {
            return x.stream().map(n -> n * 2).collect(Collectors.toList());
        };
        Function<List<Integer>, List<Integer>> subtract = x -> {
            return x.stream().map(n -> n - 1).collect(Collectors.toList());
        };
        Consumer<List<Integer>> print = x -> {
            for(int num:x) System.out.print(num + " ");
        };


//        Function<String, Object> parseCommand = x -> {
//            switch (x){
//                case "add": return add;
//                case "multiply": return multiply;
//                case "subtract": return subtract;
//                case "print": return print;
//                default: return null;
//            }
//        };

        while (true){
            String command = in.readLine();
            if(command.equals("end")) break;

            switch (command){
                case "add": nums = add.apply(nums); break;
                case "multiply": nums = multiply.apply(nums); break;
                case "subtract": nums = subtract.apply(nums); break;
                case "print": print.accept(nums);
            }
        }
    }
}
