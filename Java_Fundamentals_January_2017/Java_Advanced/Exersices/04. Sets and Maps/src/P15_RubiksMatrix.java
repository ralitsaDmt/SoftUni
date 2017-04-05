import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15_RubiksMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = in.readLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] rubik = fillMatrix(rows, cols);

        int countOfCommands = Integer.parseInt(in.readLine());

        shuffleCube(rubik, rows, cols, countOfCommands, in);

        arrangeCube(rubik, rows, cols);
    }

    private static void arrangeCube(int[][] rubik, int rows, int cols) {
        int element = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(rubik[i][j] == element){
                    System.out.println("No swap required");
                }
                else{
                    String swap = swapElements(rubik, element, i, j);
                    System.out.println(swap);
                }
                element++;
            }
        }
    }

    private static String swapElements(int[][] rubik, int element, int currentRow, int currentCol) {

        int swapRow = -1, swapCol = -1;

        for (int i = currentRow + 1; i < rubik.length; i++) {
            for (int j = currentCol + 1; j < rubik[currentRow].length; j++) {
                if (rubik[i][j] == element){
                    swapRow = i;
                    swapCol = j;

                    int temp = rubik[i][j];
                    rubik[i][j] = rubik[currentRow][currentCol];
                    rubik[currentRow][currentCol] = temp;
                }
            }
        }

        return String.format("Swap (%s, %s) with (%s, %s)",
                currentRow, currentCol, swapRow, swapCol);
    }

    private static void shuffleCube(
            int[][] rubik,
            int rows,
            int cols,
            int countOfCommands,
            BufferedReader in) throws IOException {

        for (int i = 0; i < countOfCommands; i++) {
            String[] command = in.readLine().split("\\s+");

            int rowCol = Integer.parseInt(command[0]);
            String direction = command[1];
            int moves = Integer.parseInt(command[2]);

            switch (direction){
                case "up": slideUp(rowCol, moves, rubik); break;
                case "down": slideDown(rowCol, moves, rubik); break;
                case "right": slideRight(rowCol, moves, rubik); break;
                case "left": slideLeft(rowCol, moves, rubik); break;
            }
        }
    }

    private static void slideRight(int rowCol, int moves, int[][] rubik) {
        int[] temp = new int[rubik[rowCol].length];
        System.arraycopy(rubik[rowCol], 0, temp, 0, temp.length);

        for (int i = 0; i < rubik[rowCol].length; i++) {
            rubik[rowCol][i] = temp[(rubik[rowCol].length - (moves - i)) % rubik[rowCol].length];
        }

    }

    private static void slideLeft(int rowCol, int moves, int[][] rubik) {
        int[] temp = new int[rubik[rowCol].length];
        System.arraycopy(rubik[rowCol], 0, temp, 0, temp.length);

        for (int i = 0; i < rubik[rowCol].length; i++) {
            rubik[rowCol][i] = temp[(moves - i) % rubik[rowCol].length];
        }
    }

    private static void slideDown(int rowCol, int moves, int[][] rubik) {
        int[] temp = new int[rubik.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rubik[i][rowCol];
        }

        for (int i = 0; i < rubik.length; i++) {
            rubik[i][rowCol] = temp[(rubik.length - (moves - i)) % rubik.length];
        }
    }

    private static void slideUp(int rowCol, int moves, int[][] rubik) {

        int[] temp = new int[rubik.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rubik[i][rowCol];
        }

        for (int i = 0; i < rubik.length; i++) {
            rubik[i][rowCol] = temp[(i + moves) % rubik.length];
        }
    }

    private static int[][] fillMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        int element = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = element;
                element++;
            }
        }

        return matrix;
    }
}
