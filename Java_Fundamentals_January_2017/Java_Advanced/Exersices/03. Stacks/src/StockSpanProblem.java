import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        double[] prices = readPrices(n, in);
        int[] span = CalculateSpans(prices);

        for(int s : span){
            System.out.println(s);
        }
    }

    private static int[] CalculateSpans(double[] prices) {
        int[] span = new int[prices.length];

        span[0] = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            int index = 0;
            span[i] = 1;
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                index = stack.pop();
                span[i] = i - index + span[index];
            }
            stack.push(i);
        }

        return span;
    }

    private static double[] readPrices(int n, BufferedReader in) throws IOException {
        double[] prices = new double[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Double.parseDouble(in.readLine());
        }

        return prices;
    }
}
