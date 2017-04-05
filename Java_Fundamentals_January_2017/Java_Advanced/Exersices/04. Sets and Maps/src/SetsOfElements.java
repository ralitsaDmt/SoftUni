import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<String> n = new LinkedHashSet<>();
        LinkedHashSet<String> m = new LinkedHashSet<>();

        String[] counts = scan.nextLine().split("\\s+");

        int sizeN = Integer.parseInt(counts[0]);
        int sizeM = Integer.parseInt(counts[1]);

        for (int i = 0; i < sizeN; i++) {
            n.add(scan.nextLine());
        }

        for (int i = 0; i < sizeM; i++) {
            m.add(scan.nextLine());
        }

        for(String element : n){
            if (m.contains(element)){
                System.out.print(element + " ");
            }
        }
    }
}
