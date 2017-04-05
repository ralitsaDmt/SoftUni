import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        int elementsToAdd = Integer.parseInt(tokens[0]);
        int elementsToPoll = Integer.parseInt(tokens[1]);
        int elementsToCheck = Integer.parseInt(tokens[2]);

        ArrayDeque<Integer> elements = new ArrayDeque<>();

        tokens = scan.nextLine().split("\\s+");

        int len = Math.min(elementsToAdd, tokens.length);

        for (int i = 0; i < len; i++) {
            elements.offer(Integer.parseInt(tokens[i]));
        }

        len = Math.min(elements.size(), elementsToPoll);
        for (int i = 0; i < len; i++) {
            elements.poll();
        }

        int minElement = Integer.MAX_VALUE;
        boolean isFound = false;

        while (!elements.isEmpty()){

            int check = elements.poll();

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
