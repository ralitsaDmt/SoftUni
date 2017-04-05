import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String firstString = scan.next();
        String secondString = scan.next();
        int firstInt = scan.nextInt();
        int secondInt = scan.nextInt();
        int thirdInt = scan.nextInt();
        String thirdString = scan.next();

        int sum = firstInt + secondInt + thirdInt;

        System.out.printf("%s %s %s %d", firstString, secondString, thirdString, sum);
    }

}

