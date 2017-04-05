import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());

        TreeMap<String, Double> students = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String studentName = scan.nextLine();

            double average = CalcAverage(scan);

            students.put(studentName, average);
        }

        for (String key : students.keySet()) {
            System.out.printf("%s is graduated with %s\n",
                    key, students.get(key));
        }
    }

    private static double CalcAverage(Scanner scan) {
        String[] line = scan.nextLine().split("\\s+");

        double sum = 0;

        for (int i = 0; i < line.length; i++) {
            sum += Double.parseDouble(line[i]);
        }

        return sum / line.length;
    }
}
