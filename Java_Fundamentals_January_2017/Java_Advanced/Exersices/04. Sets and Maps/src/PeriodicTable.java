import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            String[] compounds = scan.nextLine().split("\\s+");
            for(String compound : compounds){
                  elements.add(compound);
            }
        }


        Iterator it = elements.iterator();

        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }

    }
}
