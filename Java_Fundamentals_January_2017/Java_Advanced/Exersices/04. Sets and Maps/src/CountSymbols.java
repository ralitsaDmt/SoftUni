import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<Character, Integer> symbols = new TreeMap<>();
        char[] line = scan.nextLine().toCharArray();

        for (int i = 0; i < line.length; i++) {
            if (symbols.containsKey(line[i])){
                symbols.put(line[i], symbols.get(line[i]) + 1);
            }
            else{
                symbols.put(line[i], 1);
            }
        }


        for( char symbol : symbols.keySet()){
            System.out.printf("%s: %d time/s\n", symbol, symbols.get(symbol));
        }



    }
}
