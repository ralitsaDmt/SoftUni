package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String[] data = in.readLine().split("\\s+");
            if (data[0].equals("END")){
                break;
            }

            String product = data[0];

            if (product.equals("Pizza")){
                String name = data[1];
                Integer numberOfToppings = Integer.parseInt(data[2]);

                boolean isPizzaMade = false;
                try {
                    Pizza pizza = new Pizza(name, numberOfToppings);

                    String[] doughData = in.readLine().split("\\s+");

                    try{
                        Dough dough = makeDough(doughData);
                        pizza.setDough(dough);

                        for (int i = 0; i < numberOfToppings; i++) {
                            String[] toppingData = in.readLine().split("\\s+");
                            Topping topping = makeTopping(toppingData);
                            pizza.addTopping(topping);
                        }
                        isPizzaMade = true;
                        System.out.printf("%s - %.2f", pizza.getName(), pizza.getTotalCalories());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        return;
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }

                if (!isPizzaMade){
                    return;
                }

            } else if (product.equals("Dough")){

                try {
                    Dough dough = makeDough(data);
                    System.out.printf("%.2f\n", dough.getCaloriesPerGram());
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }

            } else if (product.equals("Topping")){
                try {
                    Topping topping = makeTopping(data);
                    System.out.printf("%.2f\n", topping.getCalories());
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
    }

    private static Topping makeTopping(String[] data) throws Exception {
        String type = data[1];
        double weight = Double.parseDouble(data[2]);

        try {
            Topping topping = new Topping(type, weight);
            return topping;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    private static Dough makeDough(String[] data) throws Exception {
        String type = data[1];
        String technique = data[2];
        double weight = Double.parseDouble(data[3]);

        try{
            Dough dought = new Dough(type, technique, weight);
            return dought;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
