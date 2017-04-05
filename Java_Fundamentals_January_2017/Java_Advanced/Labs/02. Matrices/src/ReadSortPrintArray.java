import java.util.Arrays;
import java.util.Scanner;

public class ReadSortPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLine();
        }

        Arrays.sort(arr);

        for (String var :
                arr) {
            System.out.println(var);
        }
    }
}
