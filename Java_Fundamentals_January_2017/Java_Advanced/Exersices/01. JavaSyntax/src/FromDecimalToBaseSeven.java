import java.util.ArrayList;
import java.util.Scanner;

public class FromDecimalToBaseSeven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        ArrayList<Integer> result = new ArrayList<>();

        while (num > 0){
            result.add(num % 7);
            num /= 7;
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
    }
}
