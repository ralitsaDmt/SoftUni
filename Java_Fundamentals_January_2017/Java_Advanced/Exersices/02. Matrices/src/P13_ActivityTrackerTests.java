import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P13_ActivityTrackerTests {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        Map<Integer, Map<String, Double>> people = readRecords(in, n);

        people.entrySet().forEach(p -> {
            System.out.printf("%s: ",
                    p.getKey());

            StringBuilder sb = new StringBuilder();
            p.getValue().entrySet().forEach(d ->
                sb.append(String.format("%s(%s), ",d.getKey(), format(d.getValue()))
            ));
            System.out.println(sb.substring(0, sb.length() - 2));
        });
    }

    private static Object format(double value) {
        if(value == (long)value){
            return (long)value;
        }
        return value;
    }


    private static Map<Integer, Map<String, Double>> readRecords(BufferedReader in, int n) throws IOException {
        Map<Integer, Map<String, Double>> people = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] record = in.readLine().split("\\s+");

            int month = extractMonth(record[0]);
            String name = record[1];
            double distance = Double.parseDouble(record[2]);

            if(!people.containsKey(month)){
                people.put(month, new TreeMap<>());
            }

            if(!people.get(month).containsKey(name)){
                people.get(month).put(name, distance);
            }
            else{
                people.get(month).put(name, people.get(month).get(name) + distance);
            }
        }

        return people;
    }

    private static int extractMonth(String s) {
        int month = 0;

        String[] date = s.split("/");
        month = Integer.parseInt(date[1]);

        return month;
    }
}

//class Person{
//    public String name;
//    public double distance;
//
//    public Person(String name, double distance){
//        this.name = name;
//        this.distance = distance;
//    }
//}
