import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class RadioactiveBunny {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(in.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] lair = ReadLair(in, rows);
        char[][] copy = CopyLair(lair);

        char[] moves = in.readLine().toCharArray();

        StartGame(lair, copy, moves);
    }

    private static char[][] CopyLair(char[][] lair) {
        char[][] copy = new char[lair.length][lair[0].length];

        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                copy[i][j] = lair[i][j];
            }
        }

        return copy;
    }

    private static void StartGame(char[][] lair, char[][] copy, char[] moves) {

        int[] playerPosition = LocatePlayer(lair);

        for (int i = 0; i < moves.length; i++) {
            char move = moves[i];

            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            playerPosition = MovePlayer(lair, move, playerPosition);

            if(playerPosition[0] < 0 || playerPosition[0] >= lair.length
                    || playerPosition[1] < 0 || playerPosition[1] >= lair[i].length){

                lair = MultiplyBunnies(lair, copy);
                PrintLair(lair);
                System.out.println("won: " + playerRow + " " + playerCol);
                return;
            }
            else if(lair[playerPosition[0]][playerPosition[1]] == 'B'){

                    lair = MultiplyBunnies(lair, copy);
                    PrintLair(lair);
                    System.out.println("dead: " + playerPosition[0] + " " + playerPosition[1]);
                    return;

            }

            lair = MultiplyBunnies(lair, copy);
        }
    }

    private static void PrintLair(char[][] lair) {
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                System.out.print(lair[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] MovePlayer(char[][] lair, char move, int[] position) {
        switch (move){
            case 'U': return new int[] {position[0] - 1, position[1]};
            case 'R': return new int[] {position[0], position[1] + 1};
            case 'L': return new int[] {position[0], position[1] - 1};
            case 'D': return new int[] {position[0] + 1, position[1]};
            default: return null;
        }
    }

    private static char[][] MultiplyBunnies(char[][] lair, char[][] copy) {
        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                if(lair[i][j] == 'B'){
                    copy[Math.max(0, i - 1)][j] = 'B';
                    copy[i][Math.max(0, j - 1)] = 'B';
                    copy[Math.min(lair.length - 1, i + 1)][j] = 'B';
                    copy[i][Math.min(lair[i].length - 1, j + 1)] = 'B';
                }
            }
        }

        // PrintLair(copy);
        // System.out.println();

        lair = CopyLair(copy);
        return lair;
    }

    private static int[] LocatePlayer(char[][] lair) {

        for (int i = 0; i < lair.length; i++) {
            for (int j = 0; j < lair[i].length; j++) {
                if(lair[i][j] == 'P'){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    private static char[][] ReadLair(BufferedReader in, int rows) throws IOException {
        char[][] lair = new char[rows][];

        for (int i = 0; i < rows; i++) {
            lair[i] = in.readLine().toCharArray();
        }
        return lair;
    }
}
