import java.util.Scanner;

public class CollectTheCoins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] board = new char[4][];

        for (int i = 0; i < 4; i++) {
            board[i] = scan.nextLine().toCharArray();
        }

        char[] commands = scan.nextLine().toCharArray();

        Play(board, commands);
    }

    private static void Play(char[][] board, char[] commands) {
        int coins = 0, walls = 0;
        int currentRow = 0, currentCol = 0, moveRow = 0, moveCol = 0;

        for (char command:
             commands) {
            if (command == '<'){
                moveRow = currentRow;
                moveCol = currentCol - 1;
            }
            else if(command == '>'){
                moveRow = currentRow;
                moveCol = currentCol + 1;
            }
            else if(command == '^'){
                moveRow = currentRow - 1;
                moveCol = currentCol;
            }
            else{
                moveRow = currentRow + 1;
                moveCol = currentCol;
            }

            try{
                char currentCell = board[moveRow][moveCol];
                currentRow = moveRow;
                currentCol = moveCol;
                if (currentCell == '$'){
                    coins++;
                }
            }
            catch (IndexOutOfBoundsException ex){
                walls++;
            }
        }

        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + walls);
    }
}
