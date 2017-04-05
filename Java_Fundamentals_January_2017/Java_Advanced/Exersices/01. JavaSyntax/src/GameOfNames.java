import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());

        int maxPoints = Integer.MIN_VALUE;
        String winnerName = "";

        for (int i = 0; i < count; i++) {
            String name = scan.nextLine();
            int initialPoints = Integer.parseInt(scan.nextLine());
            initialPoints += CalculatePoints(name);

            if (initialPoints > maxPoints){
                maxPoints = initialPoints;
                winnerName = name;
            }
        }

        System.out.printf("The winner is %s - %d points",
                winnerName, maxPoints);
    }

    private static int CalculatePoints(String name) {
        int sum = 0;

        for (int i = 0; i < name.length(); i++) {
             char ch = name.charAt(i);
            if (ch % 2 == 0){
                sum += ch;
            }
            else{
                sum -= ch;
            }
        }

        return sum;
    }
}
