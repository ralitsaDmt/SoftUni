package ShoppingSpree;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Map<String, Person> people;
    private static Map<String, Product> products;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));
        String peopleData = in.readLine();
        String productsData = in.readLine();

        people = new LinkedHashMap<>();
        products = new LinkedHashMap<>();

        fillData(peopleData, "People");
        fillData(productsData, "Product");

        if (people.size() > 0 && products.size() > 0){
            while (true){
                String[] purchase = in.readLine().split("\\s+");
                if (purchase[0].equals("END")) break;

                String personName = purchase[0];
                String productName = purchase[1];

                Person person = people.get(personName);
                Product product = products.get(productName);

                try {
                    person.buyProduct(product);
                    System.out.println(personName + " bought " + productName);
                }
                catch (Exception e){
                    System.out.println(String.format(e.getMessage(), personName, productName));
                }
            }
        }

        printResults();
    }

    private static void printResults() {
        for (String name : people.keySet()) {
            System.out.println(people.get(name));
        }
    }

    private static void fillData(String data, String type) {
        String[] splitData = data.split(";");

        for (String dd : splitData) {
            String[] innerData = dd.split("=");

            String name = innerData[0];
            Double money = Double.parseDouble(innerData[1]);

            try{
                if (type.equals("People")){
                    Person person = new Person(name, money);
                    people.put(name, person);
                } else {
                    Product product = new Product(name, money);
                    products.put(name, product);
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }


}
