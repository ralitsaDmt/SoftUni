import java.util.Locale;
import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int blurAmount = Integer.parseInt(scan.nextLine());

        String[] line = scan.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        long[][] matrix = ReadMatrix(scan, rows, cols);

        line = scan.nextLine().split(" ");
        int rowCoordinate = Integer.parseInt(line[0]);
        int colCoordinate = Integer.parseInt(line[1]);

        BlurPicture(matrix, rows, cols, rowCoordinate, colCoordinate, blurAmount);

    }

    private static void BlurPicture(long[][] matrix, int rows, int cols, int rowCoordinate, int colCoordinate, int blurAmount) {

        int startRow = Math.max(0, rowCoordinate - 1);
        int endRow = Math.min(rows - 1, rowCoordinate + 1);
        int startCol = Math.max(0, colCoordinate - 1);
        int endCol = Math.min(cols - 1, colCoordinate + 1);

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                matrix[i][j] += blurAmount;
            }
        }

        PrintMatrix(matrix);

    }

    private static void PrintMatrix(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static long[][] ReadMatrix(Scanner scan, int rows, int cols) {
        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = scan.nextLine().split(" ");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Long.parseLong(line[j]);
            }
        }
        return matrix;
    }
}
