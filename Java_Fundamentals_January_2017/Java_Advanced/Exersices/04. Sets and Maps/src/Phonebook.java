import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        while (true){
            String[] contact = scan.nextLine().split("-");
            if (contact[0].toLowerCase().equals("search")) break;

            String name = contact[0];
            String number = contact[1];

            phonebook.put(name, number);
        }

        while (true){
            String contact = scan.nextLine();
            if (contact.toLowerCase().equals("stop")) break;

            if (phonebook.containsKey(contact)){
                System.out.printf("%s -> %s\n", contact, phonebook.get(contact));
            }
            else {
                System.out.printf("Contact %s does not exist.\n", contact);
            }
        }


    }
}
