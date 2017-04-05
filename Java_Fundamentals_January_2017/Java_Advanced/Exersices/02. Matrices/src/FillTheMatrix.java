import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        switch (pattern){
            case "A": PatternA(matrix); break;
            case "B": PatternB(matrix, size); break;
        }
    }

    static void PatternA(int[][] matrix){
        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = num++;
            }
        }

        PrintMatrix(matrix);
    }

    static void PatternB(int[][] matrix, int n){

        int element = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0){
                    matrix[j][i] = ++element;
                }
                else{
                    matrix[n - j - 1][i] = ++element;
                }
            }
        }

        PrintMatrix(matrix);
    }

    static void PrintMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
