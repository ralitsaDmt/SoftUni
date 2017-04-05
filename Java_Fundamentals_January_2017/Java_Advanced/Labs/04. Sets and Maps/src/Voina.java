import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = ReadInput(scan);
        LinkedHashSet<Integer> secondPlayer = ReadInput(scan);

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) break;

            int firstHand = firstPlayer.iterator().next();
            int secondHand = secondPlayer.iterator().next();

            firstPlayer.remove(firstHand);
            secondPlayer.remove(secondHand);

            if (firstHand > secondHand){
                firstPlayer.add(firstHand);
                firstPlayer.add(secondHand);
            }
            else if(firstHand < secondHand){
                secondPlayer.add(firstHand);
                secondPlayer.add(secondHand);
            }
        }

        if (firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }
        else if(secondPlayer.size() > firstPlayer.size()){
            System.out.println("Second player win!");
        }
        else{
            System.out.println("Draw!");
        }

    }

    private static LinkedHashSet<Integer> ReadInput(Scanner scan) {
        String[] numbers = scan.nextLine().split("\\s+");

        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for (String number :
                numbers) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }
}
