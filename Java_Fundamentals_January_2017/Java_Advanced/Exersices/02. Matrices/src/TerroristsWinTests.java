
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWinTests {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] text = scan.nextLine().toCharArray();

        char[][] matrix = new char[2][];
        matrix[0] = text;
        matrix[1] = text;

        for (int i = 0; i < matrix[0].length; i++) {
            long sum = 0;
            int startIndex = 0, endIndex = 0;
            if (matrix[0][i] == '|'){
                startIndex = i;
                i++;
                while (matrix[0][i] != '|'){
                    sum += matrix[0][i];
                    i++;
                }
                endIndex = i;

                int bombIndex = (int)(sum % 10);

                startIndex -= bombIndex;
                endIndex += bombIndex;

                int start = Math.max(startIndex, 0);
                int end = Math.min(endIndex, matrix[0].length - 1);

                for (int j = start; j <= end; j++) {
                    matrix[0][j] = '.';
                }

                i = end;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(matrix[0][i]);
        }

    }
}
