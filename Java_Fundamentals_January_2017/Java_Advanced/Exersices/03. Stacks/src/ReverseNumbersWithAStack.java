import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> reversed = new ArrayDeque<>();

        for (String element :
                input) {
            reversed.push(element);
        }

        while (!reversed.isEmpty()){
            System.out.print(reversed.pop() + " ");
        }
    }
}
