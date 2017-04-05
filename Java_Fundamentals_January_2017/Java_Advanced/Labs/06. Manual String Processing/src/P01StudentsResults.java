import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class P01StudentsResults {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(in.readLine());

        Map<String, ArrayList<Double>> students = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] stInfo = in.readLine().split(" - ");

            String name = stInfo[0];

            students.put(name, new ArrayList<>());

            String[] strMarks = stInfo[1].split(", ");
            double sum = 0;
            for (String mark :
                    strMarks) {
                double num = Double.parseDouble(mark);
                sum += num;
                students.get(name).add(num);
            }

            double average = sum / 3;
            students.get(name).add(average);
        }

        PrintResults(students, count);

    }

    private static void PrintResults(Map<String, ArrayList<Double>> students, int count) {
        System.out.printf("%-10s|%7s|%7s|%7s|%7s|\n",
                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");

        students.entrySet().stream().forEach(s -> {
            System.out.printf("%-10s|", s.getKey());

            for (int i = 0; i < s.getValue().size(); i++) {
                if(i != s.getValue().size() - 1){
                    System.out.printf("%1$7.2f|", s.getValue().get(i));
                }
                else{
                    System.out.printf("%1$7.4f|", s.getValue().get(i));
                }
            }

            System.out.println();
        });
    }
}
