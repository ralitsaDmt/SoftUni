import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int decimal = Integer.parseInt(scan.nextLine());

        ArrayDeque<Integer> binary = new ArrayDeque<>();
        
        if (decimal == 0){
            System.out.println(0);
            return;
        }
        else{
            while (decimal != 0){
                binary.push(decimal % 2);
                decimal /= 2;
            }
        }

        while (!binary.isEmpty()){
            System.out.print(binary.pop());
        }
    }
}
