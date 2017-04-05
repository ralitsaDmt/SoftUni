import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(scan.readLine());

        ArrayDeque<Integer> roli = new ArrayDeque<>();


        for (int i = 0; i < count; i++) {
            String[] tokens = scan.readLine().split("\\s+");
            int index = Integer.parseInt(tokens[0]);
            int element = 0;

            if (tokens.length == 2){
                element = Integer.parseInt(tokens[1]);
            }

            if (index == 1){
                roli.push(element);
            }
            else if(index == 2){
                roli.pop();
            }
            else if (index == 3){
                int maxElement = FindMaxElement(roli);
                System.out.println(maxElement);
            }
        }
    }

    private static int FindMaxElement(ArrayDeque<Integer> roli) {
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < roli.size(); i++) {
            int element = roli.pop();
            if (element > maxElement){
                maxElement = element;
            }
            roli.add(element);
        }

        return maxElement;
    }
}
