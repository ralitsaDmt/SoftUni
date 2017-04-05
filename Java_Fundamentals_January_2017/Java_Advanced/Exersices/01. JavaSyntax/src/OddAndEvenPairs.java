import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(" ");

        if (line.length % 2 != 0){
            System.out.println("invalid length");
            return;
        }

        int[] numbers = new int[line.length];

        for (int i = 0; i < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        int firstNum, secondNum;
        for (int i = 0; i < numbers.length - 1; i += 2) {
            firstNum = numbers[i];
            secondNum = numbers[i + 1];

            String message;
            if (firstNum % 2 == 0 && secondNum % 2 == 0){
                message = "both are even";
            }
            else if(firstNum % 2 == 1 && secondNum % 2 == 1){
                message = "both are odd";
            }
            else{
                message = "different";
            }

            System.out.printf("%d, %d -> %s\n",
                    firstNum, secondNum, message);
        }
    }
}
