import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeSet<String> regular = new TreeSet<>();
        TreeSet<String> vip = new TreeSet<>();

        while (true){
            String input = scan.nextLine();

            if ("PARTY".equals(input)){
                break;
            }

            if (Character.isDigit(input.charAt(0))){
                vip.add(input);
            }
            else regular.add(input);
        }

        vip.addAll(regular);

        while (true){
            String input = scan.nextLine();

            if("END".equals(input)) break;

            vip.remove(input);
        }

        System.out.println(vip.size());
        vip.forEach(System.out::println);
    }
}
