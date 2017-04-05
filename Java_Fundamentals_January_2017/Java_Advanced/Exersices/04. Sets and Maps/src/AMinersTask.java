import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class AMinersTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, Long> mine = new HashMap<>();

        while (true){
            String ore = scan.nextLine();

            if (ore.toLowerCase().equals("stop")) break;

            String qtyString = scan.nextLine();
            if (qtyString.toLowerCase().equals("stop")) break;

            long qty = Long.parseLong(qtyString);

            if (mine.containsKey(ore)){
                mine.put(ore, mine.get(ore) + qty);
            }
            else{
                mine.put(ore, qty);
            }
        }

        for(String ore  : mine.keySet()){
            System.out.printf("%s -> %s\n",
                    ore, mine.get(ore));
        }

    }
}
