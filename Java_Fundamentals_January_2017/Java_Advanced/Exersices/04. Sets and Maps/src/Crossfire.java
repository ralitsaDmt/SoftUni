import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        List<List<Integer>> matrix = readMatrix(in, rows, cols);

        while(true){
            String input = in.readLine();
            if(input.equals("Nuke it from orbit")) break;

            int[] commands = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int targetRow = commands[0];
            int targetCol = commands[1];
            int targetRadius = commands[2];

            int upRow = Math.max(0, targetRow - targetRadius);
            int downRow = Math.min(matrix.size() - 1, targetRow + targetRadius);
            int leftCol = Math.max(0, targetCol - targetRadius);
            int rightCol = Math.min(targetRow >=  0 && targetRow < matrix.size() ? matrix.get(targetRow).size() - 1 : 50000, targetCol + targetRadius);

            for (int i = upRow; i <= downRow; i++) {
                if(i == targetRow){
                    for (int j = rightCol; j >= leftCol; j--) {
                        matrix.get(i).remove(j);
                    }
                }
                else{
                    if(matrix.get(i).size() > targetCol){
                        matrix.get(i).remove(targetCol);
                    }
                }
            }

        }

        PrintMatrix(matrix);
    }

    private static void PrintMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            if(matrix.get(i).size() != 0){
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    System.out.print(matrix.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    private static List<List<Integer>> readMatrix(BufferedReader in, int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(cols * i + j + 1);
            }
        }

        return matrix;
    }
}
