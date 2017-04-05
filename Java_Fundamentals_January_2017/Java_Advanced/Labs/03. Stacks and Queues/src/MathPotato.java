import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] names = scan.nextLine().split("\\s+");
        int cycles = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();
        for (String name :
                names) {
            children.add(name);
        }
        
        int cycle = 1;
        while (children.size() > 1){
            for (int i = 1; i < cycles; i++) {
                children.offer(children.poll());
            }

            if (isPrime(cycle)){
                System.out.println("Prime " + children.peek());
            }
            else{
                System.out.println("Removed " + children.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + children.poll());
    }

    private static boolean isPrime(int cycle) {

        if (cycle == 1){
            return false;
        }

        if (cycle == 2){
            return true;
        }

        for (int i = 2; i <= Math.sqrt(cycle); i++) {
            if (cycle % i == 0){
                return false;
            }
        }

        return true;
    }
}
