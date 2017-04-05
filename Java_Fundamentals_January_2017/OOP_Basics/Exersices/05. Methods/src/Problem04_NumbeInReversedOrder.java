import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem04_NumbeInReversedOrder {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String inputNumber = reader.readLine();

        DecimalNumber number = new DecimalNumber(inputNumber);

        System.out.println(number.getReversedNumber());
    }
}

class DecimalNumber{
    private String number;

    private void setNumber(String number) {
        this.number = number;
    }

    public DecimalNumber(String number) {
        this.setNumber(number);
    }

    public String getReversedNumber(){
        StringBuilder builder = new StringBuilder();

        for (int i = this.number.length() - 1; i >= 0; i--) {
            builder.append(this.number.charAt(i));
        }

        return builder.toString();
    }
}
