import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(", ");

        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        long sum = 0;

        for (int i = 0; i < rows; i++) {
            String[] row = scan.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                sum += Integer.parseInt(row[j]);
            }
        }

        System.out.printf("%d\n%d\n%d",
                rows, cols, sum);
    }
}
