import java.util.HashMap;
import java.util.Scanner;

public class CountSameValuesinArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split("\\s+");

        HashMap<String, Integer> occurrences = new HashMap<>();

        for (String number :
                numbers) {
            if (!occurrences.containsKey(number)) {
                occurrences.put(number, 1);
            } else {
                occurrences.put(number, occurrences.get(number) + 1);
            }
        }

        for (String key :
                occurrences.keySet()) {
            System.out.printf("%s - %d times\n", key, occurrences.get(key));
        }
    }
}
