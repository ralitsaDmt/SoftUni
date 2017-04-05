import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        long[][] pascal = new long[n][];

        for (int i = 0; i < n; i++) {
            pascal[i] = new long[i + 1];
        }

        pascal[0][0] = 1;
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < pascal[row].length; col++) {
                if (col == 0 || col == pascal[row].length - 1){
                    pascal[row][col] = 1;
                }
                else{
                    pascal[row][col] = pascal[row - 1][col - 1] + pascal[row - 1][col];
                }
            }
        }

        for (int i = 0; i < pascal.length; i++) {
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }
    }
}
