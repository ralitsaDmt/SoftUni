import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PlusRemoveTests {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<ArrayList<Character>> matrix = ReadMatrix(scan);
        boolean[][] board = new boolean[matrix.size()][];

        for (int i = 0; i < board.length; i++) {
            board[i] = new boolean[matrix.get(i).size()];
        }

        for (int i = 0; i < matrix.size() - 2; i++) {
            for (int j = 1; j < matrix.get(i).size(); j++) {

                if (matrix.get(i + 1).size() >= matrix.get(i).size() + 1
                        && matrix.get(i + 2).size() >= matrix.get(i).size()){
                    if (matrix.get(i + 1).size() > j + 1
                            && matrix.get(i).get(j) == matrix.get(i + 1).get(j - 1)
                            && matrix.get(i).get(j) == matrix.get(i + 1).get(j)
                            && matrix.get(i).get(j) == matrix.get(i + 1).get(j + 1)
                            && matrix.get(i).get(j) == matrix.get(i + 2).get(j)){
                        board[i][j] = true;
                        board[i + 1][j - 1] = true;
                        board[i + 1][j] = true;
                        board[i + 1][j + 1] = true;
                        board[i + 2][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            int index = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]){
                    matrix.get(i).remove(index);
                    index--;
                }
                index++;
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).forEach(System.out::print);
            System.out.println();
        }

    }

    private static ArrayList<ArrayList<Character>> ReadMatrix(Scanner scan){
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();

        while(true){
            String line = scan.nextLine().toLowerCase();
            if (line.equals("end")) break;

            ArrayList<Character> arr = new ArrayList<Character>();
            for(char c: line.toCharArray()){
                arr.add(c);
            }

            matrix.add(arr);
        }

        return matrix;
    }
}
