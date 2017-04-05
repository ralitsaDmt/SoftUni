import java.util.*;

public class GroupNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(", ");

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(0, new ArrayList<>());
        matrix.add(1, new ArrayList<>());
        matrix.add(2, new ArrayList<>());

        for (String num:
             line) {
            int currentNumber = Integer.parseInt(num);
            matrix.get(Math.abs(currentNumber % 3)).add(currentNumber);
        }

        for (ArrayList<Integer> integers :
                matrix) {
            for (Integer integer :
                    integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }
}
