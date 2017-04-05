import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        int elementsToPush = Integer.parseInt(tokens[0]);
        int elementsToPop = Integer.parseInt(tokens[1]);
        int elementsToCheck = Integer.parseInt(tokens[2]);

        ArrayDeque<Integer> elements = new ArrayDeque<>();

        tokens = scan.nextLine().split("\\s+");

        int len = Math.min(elementsToPush, tokens.length);

        for (int i = 0; i < len; i++) {
            elements.push(Integer.parseInt(tokens[i]));
        }

        len = Math.min(elements.size(), elementsToPop);
        for (int i = 0; i < len; i++) {
            elements.pop();
        }

        int minElement = Integer.MAX_VALUE;
        boolean isFound = false;

        while (!elements.isEmpty()){

            int check = elements.pop();

            if (check == elementsToCheck){
                isFound = true;
            }

            if (check < minElement){
                minElement = check;
            }
        }

        if (minElement == Integer.MAX_VALUE){
            minElement = 0;
        }

        if (isFound){
            System.out.println(isFound);
        }
        else{
            System.out.println(minElement);
        }
    }
}
