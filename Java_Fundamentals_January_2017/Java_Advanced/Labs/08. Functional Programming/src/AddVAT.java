import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        UnaryOperator<Double> addVat = (x) -> x * 1.2;



        List<Double> prices = new ArrayList<>();
        String[] input = in.readLine().split(", ");
        for (String anInput : input) {
            prices.add(Double.parseDouble(anInput));
        }



        System.out.println("Prices with VAT:");
        for (Double pr:prices) {
            System.out.printf("%1$.2f\n", addVat.apply(pr));
        }
    }
}
