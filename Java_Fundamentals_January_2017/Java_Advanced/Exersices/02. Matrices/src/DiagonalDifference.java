import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = PrimaryDiagonal(scan, size);

        long primaryDiagonal = CalcPrimaryDiagonal(matrix, size);
        long secondaryDiagonal = CalcSecondaryDiagonal(matrix, size);

        long diff = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(diff);
    }

    private static long CalcSecondaryDiagonal(int[][] matrix, int size) {
        long sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = size; j >= 0; j--) {
                if (j == size - i - 1){
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }

    private static long CalcPrimaryDiagonal(int[][] matrix, int size) {
        long sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j){
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }

    private static int[][] PrimaryDiagonal(Scanner scan, int size) {
        int[][]matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = scan.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        return matrix;
    }
}
