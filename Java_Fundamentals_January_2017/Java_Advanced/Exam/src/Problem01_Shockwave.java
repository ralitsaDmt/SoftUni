import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem01_Shockwave {

    private static Integer[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = in.readLine().split("\\s+");
        Integer rows = Integer.parseInt(dimensions[0]);
        Integer cols = Integer.parseInt(dimensions[1]);

        matrix = new Integer[rows][];

        for (int i = 0; i < rows; i++){
            matrix[i] = new Integer[cols];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }



        startShockwaves(in);

        printMatrix();
    }

    private static void startShockwaves(BufferedReader in) throws IOException {

        while (true){
            String input = in.readLine();
            if (input.equals("Here We Go")) {
                break;
            }

            String[] data = input.split("\\s+");
            Integer[] wave = new Integer[4];
            for (int i = 0; i < data.length; i++) {
                wave[i] = Integer.parseInt(data[i]);
            }

            shock(wave);
        }
    }

    private static void shock(Integer[] wave) {
        Integer upLeftRow = wave[0];
        Integer upLeftCol = wave[1];
        Integer downRightRow = wave[2];
        Integer downRightCol = wave[3];

        for (int i = upLeftRow; i <= downRightRow; i++) {
            for (int j = upLeftCol; j <= downRightCol; j++) {
                matrix[i][j]++;
            }
        }
    }

    private static void printMatrix() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
