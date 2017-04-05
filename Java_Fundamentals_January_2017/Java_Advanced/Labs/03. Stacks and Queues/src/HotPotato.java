import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int steps = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();

        for (String in :
                input) {
            children.offer(in);
        }

        while (children.size() > 1){
            for (int i = 0; i < steps - 1; i++) {
                children.offer(children.poll());
            }

            System.out.println("Removed " + children.poll());
        }

        System.out.println("Last is " + children.poll());
    }
}
