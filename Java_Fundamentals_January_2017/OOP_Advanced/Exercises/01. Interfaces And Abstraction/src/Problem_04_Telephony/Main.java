package Problem_04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().split("\\s+");

        String[] websites = reader.readLine().split("\\s+");

        Smartphone smartphone = new Smartphone();

        for (String phoneNumber : phoneNumbers) {
            try{
                smartphone.call(phoneNumber);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (String website : websites) {
            try {
                smartphone.browse(website);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
