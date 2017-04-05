import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TargetPractice
{
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String str = in.readLine();

        char[][] stairs = FillMatrix(str, arr);

        int[] shot = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int impactRow = shot[0];
        int impactCol = shot[1];
        int radius = shot[2];

        Shoot(stairs, impactRow, impactCol, radius);

        FallDown(stairs);

        PrintStairs(stairs);
    }

    private static void FallDown(char[][] stairs) {

        for(int row = stairs.length - 1; row >= 1; row--){
             for(int col = 0; col < stairs[row].length; col++){

                 if(stairs[row][col] == ' '){
                     int currentRow = row;
                     while(currentRow > 0 && stairs[currentRow][col] == ' '){
                         currentRow--;
                     }

                     stairs[row][col] = stairs[currentRow][col];
                     stairs[currentRow][col] = ' ';
                 }
             }
        }
    }

    private static void Shoot(char[][] stairs, int impactRow, int impactCol, int radius) {
        int upperRow = Math.max(0, impactRow - radius);
        int leftCol = Math.max(0, impactCol - radius);
        int rightCol = Math.min(stairs[impactRow].length - 1, impactCol + radius);

        for(int row = impactRow; row >= upperRow; row--){
            for(int col = leftCol; col <= rightCol; col++){
                stairs[row][col] = ' ';
            }
            leftCol = leftCol == 0 ? 0 : ++leftCol;
            rightCol = rightCol == stairs[row].length - 1 ? stairs[row].length - 1 : --rightCol;

            PrintStairs(stairs);
        }

        upperRow = Math.min(impactRow + 1, stairs.length - 1);
        int lowerRow = Math.min(impactRow + radius, stairs.length - 1);
        leftCol = Math.max(0, impactCol - radius + 1);
        rightCol = Math.min(stairs[impactRow].length - 1, impactCol + radius - 1);

        for(int row = upperRow; row <= lowerRow; row++){
            for(int col = leftCol; col <= rightCol; col++){
                stairs[row][col] = ' ';
            }
            leftCol = leftCol == 0 ? 0 : ++leftCol;
            rightCol = rightCol == stairs[row].length - 1 ? stairs[row].length - 1 : --rightCol;

            PrintStairs(stairs);
        }
    }

    private static void PrintStairs(char[][] stairs) {
        for (int i = 0; i < stairs.length; i++) {
            for (int j = 0; j < stairs[i].length; j++) {
                System.out.print(stairs[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] FillMatrix(String str, int[] arr) {
        int rows = arr[0];
        int cols = arr[1];

        char[][] stairs = new char[rows][cols];
        char[] chars = str.toCharArray();

        int filler = 0;

        for(int row = rows - 1; row >= 0; row--){

            if(rows % 2 != 0 && row % 2 == 0){
                for(int col = cols - 1; col >= 0; col--){
                    stairs[row][col] = chars[filler % chars.length];
                    filler++;
                }
            }
            else if(rows % 2 != 0 && row % 2 != 0){
                for(int col = 0; col < cols; col++){
                    stairs[row][col] = chars[filler % chars.length];
                    filler++;
                }
            }
            else if(rows % 2 == 0 && row % 2 != 0){
                for(int col = 0; col < cols; col++){
                    stairs[row][col] = chars[filler % chars.length];
                    filler++;
                }
            }
            else if(rows % 2 == 0 && row % 2 == 0){
                for(int col = cols - 1; col >= 0; col--){
                    stairs[row][col] = chars[filler % chars.length];
                    filler++;
                }
            }
        }

        return stairs;
    }
}
