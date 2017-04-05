import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortOddNumbers {
    public static void main(String[] args) throws IOException {
        List<Integer> list = readNumbers();

        // remove even numbers
        list.removeIf(x -> x % 2 != 0);
        printResult(list);

        list.sort(Integer::compareTo);
        printResult(list);
    }

    private static void printResult(List<Integer> list){
        StringBuilder sb = new StringBuilder();

        for (Integer l :
                list) {
            sb.append(l).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }

    private static List<Integer> readNumbers() throws IOException {

        List<Integer> nums = new ArrayList<>();

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] str = in.readLine().split(", ");

        for (String aStr : str) {
            nums.add(Integer.parseInt(aStr));
        }

        return nums;
    }
}
