import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(", ");

        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        int[][] matrix = new int[rows][cols];

        ReadMatrix(scan, rows, cols, matrix);

        FindMaxSum(rows, cols, matrix);


    }

    private static void FindMaxSum(int rows, int cols, int[][] matrix) {

        long maxSum = Integer.MIN_VALUE;
        int maxRow = 0, maxCol = 0;

        long sum = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (sum > maxSum){
                    maxRow = i;
                    maxCol = j;
                    maxSum = sum;
                }
            }
        }

        PrintResult(matrix, maxRow, maxCol, maxSum);
    }

    private static void PrintResult(int[][] matrix, int maxRow, int maxCol, long maxSum) {
        for (int i = maxRow; i < maxRow + 2; i++) {
            for (int j = maxCol; j < maxCol + 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(maxSum);
    }

    static void ReadMatrix(Scanner scan, int rows, int cols, int[][] matrix){
        for (int i = 0; i < rows; i++) {
            String[] row = scan.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
    }
}
