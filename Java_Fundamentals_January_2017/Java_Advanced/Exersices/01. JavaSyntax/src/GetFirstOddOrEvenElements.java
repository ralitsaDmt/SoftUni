import java.util.ArrayList;
import java.util.Scanner;

public class GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = ReadCollection(scan);

        String[] command = scan.nextLine().split(" ");
        int count = Integer.parseInt(command[1]);
        String kind = command[2];

        ArrayList<Integer> result = CountNumbers(numbers, count, kind);
        for (int num :
                result) {
            System.out.printf("%d ", num);
        }
    }

    private static ArrayList<Integer> CountNumbers(int[] numbers, int count, String kind) {
        ArrayList<Integer> result = new ArrayList<>();

        int reminder = 0;
        if (kind.equals("odd")){
            reminder = 1;
        }

        int localCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == reminder){
                localCount++;
                result.add(numbers[i]);
            }
            if (localCount == count){
                break;
            }
        }

        return result;
    }

    private static int[] ReadCollection(Scanner scan) {
        String[] input = scan.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }

}
