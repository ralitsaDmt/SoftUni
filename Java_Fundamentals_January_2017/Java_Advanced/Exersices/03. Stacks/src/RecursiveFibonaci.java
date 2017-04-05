import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonaci {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        long[] numbers = new long[n + 2];

        numbers[0] = 1;
        numbers[1] = 1;

        long result = Fib(numbers, n);
        System.out.println(result);
    }

    static long Fib(long[] numbers, int n){
        if(numbers[n] == 0){
            numbers[n] = Fib(numbers, n - 1) + Fib(numbers, n - 2);
        }

        return numbers[n];
    }
}
