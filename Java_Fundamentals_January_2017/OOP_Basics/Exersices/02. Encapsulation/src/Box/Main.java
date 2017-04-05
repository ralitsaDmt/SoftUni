package Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.lang.reflect.Field;
//import java.lang.reflect.Modifier;
//import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));
        Double length = Double.parseDouble(in.readLine());
        Double width = Double.parseDouble(in.readLine());
        Double height = Double.parseDouble(in.readLine());

        try {
            Box box = new Box(length, width, height);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
//
//
//        System.out.printf("Surface Area - %.2f\n", box.surfaceArea());
//        System.out.printf("Lateral Surface Area - %.2f\n", box.lateralArea());
//        System.out.printf("Volume - %.2f\n", box.volume());
    }
}
