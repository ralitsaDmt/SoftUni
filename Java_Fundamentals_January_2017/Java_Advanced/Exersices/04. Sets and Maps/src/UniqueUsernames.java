import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());

        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            usernames.add(scan.nextLine());
        }

        for(String name  : usernames){
            System.out.println(name);
        }
    }
}
