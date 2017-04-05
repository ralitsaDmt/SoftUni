import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] size = scan.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][]matrix = ReadMatrix(scan, rows, cols);

        long[] result = FindMaxSum(matrix, rows, cols);

        long maxSum = result[0];
        long maxRow = result[1];
        long maxCol = result[2];

        System.out.println("Sum = " + maxSum);
        PrintMaxMatrix(matrix, (int)maxRow, (int)maxCol);
    }

    private static void PrintMaxMatrix(int[][] matrix, int maxRow, int maxCol) {
        for (int i = maxRow; i < maxRow + 3; i++) {
            for (int j = maxCol; j < maxCol + 3; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static long[] FindMaxSum(int[][] matrix, int rows, int cols) {
        long maxSum = Long.MIN_VALUE;
        int maxRow = 0, maxCol = 0;

        long sum;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                sum = CalcSum(matrix,i, j);
                if (sum > maxSum){
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new long[] {maxSum, maxRow, maxCol};
    }

    private static long CalcSum(int[][] matrix, int i, int j) {
        long sum = 0;

        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                sum += matrix[k][l];
            }
        }

        return sum;
    }

    private static int[][] ReadMatrix(Scanner scan, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        return matrix;
    }
}
