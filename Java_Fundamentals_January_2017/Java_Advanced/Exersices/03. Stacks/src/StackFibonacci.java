import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class StackFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        ArrayDeque<Long> fibNumbers = new ArrayDeque<>();
        fibNumbers.push((long)1);
        fibNumbers.push((long)1);

        while (fibNumbers.size() <= n){
            long f0 = fibNumbers.pop();
            long f1 = fibNumbers.peek();

            fibNumbers.push(f0);
            fibNumbers.push(f0 + f1);
        }

        System.out.println(fibNumbers.peek());
    }
}
