import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P13MagicExchangeableWords {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String first = scan.next();
        String second = scan.next();

        boolean areExch = check(first, second);
        System.out.println(areExch);
    }

    private static boolean check(String first, String second) {

        Set<Character> firstSet = new TreeSet<>();
        Set<Character> secondSet = new TreeSet<>();

        for (int i = 0; i < first.length(); i++) {
            firstSet.add(first.charAt(i));
        }

        for (int i = 0; i < second.length(); i++) {
            secondSet.add(second.charAt(i));
        }

        return firstSet.size() == secondSet.size();
    }
}
