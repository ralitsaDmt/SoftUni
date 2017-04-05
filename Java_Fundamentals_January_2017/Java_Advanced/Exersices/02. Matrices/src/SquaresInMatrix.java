import java.util.Scanner;

public class SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        String[][] matrix = ReadMatrix(scan, rows, cols);
        int squaresCount = CountSquares(matrix, rows, cols);

        System.out.println(squaresCount);
    }

    private static int CountSquares(String[][] matrix, int rows, int cols) {
        int count = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j].equals(matrix[i][j + 1])
                        && matrix[i][j].equals(matrix[i + 1][j])
                        && matrix[i][j].equals(matrix[i + 1][j + 1])){
                    count++;
                }
            }
        }

        return count;
    }

    private static String[][] ReadMatrix(Scanner scan, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().split(" ");
        }

        return matrix;
    }
}
