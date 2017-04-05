import java.util.Scanner;

public class HitTheTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int target = scan.nextInt();

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == target){
                    System.out.printf("%d + %d = %s\n",
                            i, j, target);
                }
                else if(i - j == target){
                    System.out.printf("%d - %d = %s\n",
                            i, j, target);
                }
            }
        }
    }
}
