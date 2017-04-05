import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] line = scan.nextLine().split(" ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        String[][]matrix = new String[rows][cols];

        FillMatrix(matrix, alphabet, rows, cols);
        PrintMatrix(matrix);
    }

    private static void PrintMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void FillMatrix(String[][] matrix, char[] alphabet, int rows, int cols) {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = "" + alphabet[i] + alphabet[i + j] + alphabet[i];
            }
        }
    }
}
