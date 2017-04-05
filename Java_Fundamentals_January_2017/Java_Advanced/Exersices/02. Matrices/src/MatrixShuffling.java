import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = ReadMatrix(scan, rows, cols);

        while(true){
            String[] command = scan.nextLine().split("\\s+");
            if (command[0].equals("END")){
                break;
            }

            boolean isValid = checkCommand(command, matrix);
            if (!isValid){
                System.out.println("Invalid input!");
            }
            else{
                int initialRow = Integer.parseInt(command[1]);
                int initialCol = Integer.parseInt(command[2]);
                int swapRow = Integer.parseInt(command[3]);
                int swapCol = Integer.parseInt(command[4]);

                String temp = matrix[initialRow][initialCol];
                matrix[initialRow][initialCol] = matrix[swapRow][swapCol];
                matrix[swapRow][swapCol] = temp;
                PrintMatrix(matrix, rows, cols);
            }
        }
    }

    private static void PrintMatrix(String[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkCommand(String[] command, String[][]matrix) {
        if (command.length != 5){
            return false;
        }

        if (!command[0].equals("swap")){
            return false;
        }

        int initialRow = Integer.parseInt(command[1]);
        int initialCol = Integer.parseInt(command[2]);
        int swapRow = Integer.parseInt(command[3]);
        int swapCol = Integer.parseInt(command[4]);

        if (initialRow < 0 || initialRow > matrix.length
                || swapRow < 0 || swapRow > matrix.length
                || initialCol >= matrix[initialRow].length || initialCol < 0
                || swapCol >= matrix[swapCol].length || swapCol < 0){
            return false;
        }

        return true;
    }

    private static String[][] ReadMatrix(Scanner scan, int rows, int cols) {
        String[][]matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j];
            }
        }

        return matrix;
    }
}
