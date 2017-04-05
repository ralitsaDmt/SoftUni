import java.util.HashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> users = new HashMap<>();

        while (true){
            String name = scan.nextLine();
            if(name.toLowerCase().equals("stop")) break;

            String email = scan.nextLine();
            if (email.toLowerCase().equals("stop")) break;

            //String lastDomain = email.substring(email.length() - 2, email.length()).toLowerCase();
            int indexBg = email.toLowerCase().indexOf(".bg");

//            if (!lastDomain.equals("uk") && !lastDomain.equals("us")){
//                users.put(name, email);
//            }

            if (indexBg != -1){
                users.put(name, email);
            }
        }

        for(String name  : users.keySet()){
            System.out.printf("%s -> %s\n",
                    name, users.get(name));
        }
    }
}
