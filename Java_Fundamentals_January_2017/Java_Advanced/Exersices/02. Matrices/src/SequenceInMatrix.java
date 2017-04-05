import java.util.Scanner;

public class SequenceInMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] size = scan.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = ReadMatrix(scan, rows, cols);

        FindLongestSeq(matrix, rows, cols);
    }

    private static void FindLongestSeq(String[][] matrix, int rows, int cols) {
        int maxCount = Integer.MIN_VALUE;
        String bestElement = "";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int horizontalCount = FindHorizontalCount(matrix, i, j);
                int verticalCount = FindVerticalCount(matrix, i, j);
                int primaryDiagonalCount = FindDiagonalCount(matrix, i, j);
                int secondaryDiagonalCount = FindSecondaryDiagonalCount(matrix, i, j);

                int max = Math.max(horizontalCount, Math.max(verticalCount, Math.max(secondaryDiagonalCount, primaryDiagonalCount)));

                if (max > maxCount){
                    maxCount = max;
                    bestElement = matrix[i][j];
                }
            }
        }

        if(maxCount == 1){
            bestElement = matrix[0][0];
        }

        PrintResult(maxCount, bestElement);
    }

    private static int FindSecondaryDiagonalCount(String[][] matrix, int i, int j) {
        int count = 1;
        boolean br = false;

        for (int k = i + 1; k < matrix.length; k++) {
            for (int l = j - 1; l >= 0; l--) {
                if (k == matrix[k].length - l - 1
                        && matrix[i][j].equals(matrix[k][l])){
                    count++;
                }
                else if (k == matrix[k].length - l - 1
                        && !matrix[i][j].equals(matrix[k][l])){
                    br = true;
                    break;
                }
            }
            if (br){
                break;
            }
        }

        return count;
    }

    private static void PrintResult(int maxCount, String bestElement) {
        for (int i = 0; i < maxCount; i++) {
            System.out.printf("%s, ", bestElement);
        }
    }

    private static int FindDiagonalCount(String[][] matrix, int i, int j) {
        int count = 1;
        boolean br = false;

        for (int k = i + 1; k < matrix.length; k++) {
            for (int l = j + 1; l < matrix[i].length; l++) {
                if (k == l && matrix[i][j].equals(matrix[k][l])){
                    count++;
                }
                else if(k == l && !matrix[i][j].equals(matrix[k][l])){
                    br = true;
                    break;
                }
            }
            if (br){
                break;
            }
        }

        return count;
    }

    private static int FindVerticalCount(String[][] matrix, int i, int j) {
        int count = 1;

        for (int k = i + 1; k < matrix.length; k++) {
            if (matrix[i][j].equals(matrix[k][j])){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }

    private static int FindHorizontalCount(String[][] matrix, int i, int j) {
        int count = 1;

        for (int k = j + 1; k < matrix[i].length; k++) {
            if (matrix[i][j].equals(matrix[i][k])){
                count++;
            }
            else{
                break;
            }
        }

        return count;
    }

    private static String[][] ReadMatrix(Scanner scan, int rows, int cols) {
        String[][]matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input[j];
            }
        }

        return matrix;
    }
}
