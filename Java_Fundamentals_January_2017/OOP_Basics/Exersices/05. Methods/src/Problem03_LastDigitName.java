import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem03_LastDigitName {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int inputNumber = Integer.parseInt(reader.readLine());

        Number number = new Number(inputNumber);

        System.out.println(number.lastDigitName());
    }
}

class Number {
    private int number;

    private void setNumber(int number) {
        this.number = number;
    }

    public Number(int number) {
        this.setNumber(number);
    }

    public String lastDigitName(){
        String lastDigitName = "";

        int lastDigit = this.number % 10;

        switch (lastDigit) {
            case 0: lastDigitName = "zero"; break;
            case 1: lastDigitName = "one"; break;
            case 2: lastDigitName = "two"; break;
            case 3: lastDigitName = "three"; break;
            case 4: lastDigitName = "four"; break;
            case 5: lastDigitName = "five"; break;
            case 6: lastDigitName = "six"; break;
            case 7: lastDigitName = "seven"; break;
            case 8: lastDigitName = "eight"; break;
            case 9: lastDigitName = "nine"; break;
        }

        return lastDigitName;
    }
}
