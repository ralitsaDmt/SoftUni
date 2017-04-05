
public class Lottery {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10; k++) {
                    if (k > j && j > i){
                        System.out.printf("%d %d %d\n", i, j, k);
                    }
                }
            }
        }

    }
}
