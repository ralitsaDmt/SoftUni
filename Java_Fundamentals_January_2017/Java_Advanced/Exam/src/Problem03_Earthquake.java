import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem03_Earthquake {

    private static Deque<List<Integer>> quake;
    private static Integer count;
    private static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(in.readLine());

        quake = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] data = in.readLine().split("\\s+");
            List<Integer> waves = new ArrayList<>();
            for (int j = 0; j < data.length; j++) {
                waves.add(Integer.parseInt(data[j]));
            }
            quake.offer(waves);
        }

        result = new ArrayList<>();
        count = 0;

        while (!quake.isEmpty()){

            List<Integer> current = quake.poll();

            Integer seismicity = current.get(0);
            result.add(seismicity);
            count++;

            if (current.size() > 1 && seismicity >= current.get(1)){
                while (current.size() > 1 && seismicity >= current.get(1)){
                    current.remove(1);
                }
            }

            if (current.size() > 1){
                current.remove(0);
                quake.offer(current);
            }
        }

        System.out.println(count);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }
}
