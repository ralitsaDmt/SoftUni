import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] robotTokens = scan.nextLine().split(";");

        int robotsCount = robotTokens.length;

        String[] robotNames = new String[robotsCount];
        int[] processingTimes = new int[robotsCount];
        int[] currentProcess = new int[robotsCount];

        for (int i = 0; i < robotsCount; i++) {
            String[] tokens = robotTokens[i].split("-");

            robotNames[i] = tokens[0];
            processingTimes[i] = Integer.parseInt(tokens[1]);
        }

        LocalTime time = ReadTime(scan);

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (true){
            String product = scan.nextLine();
            if (product.equals("End")) break;
            queue.offer(product);
        }

        int duration = 0;
        while (!queue.isEmpty()){
            duration++;
            String product = queue.poll();

            for (int i = 0; i < robotsCount; i++) {
                currentProcess[i]--;
            }

            boolean isProcessed = false;
            for (int i = 0; i < robotsCount; i++) {
                if (currentProcess[i] <= 0){
                    currentProcess[i] = processingTimes[i];
                    LocalTime lt = time.plusSeconds(duration);
                    System.out.printf("%s - %s [%02d:%02d:%02d]\n",
                            robotNames[i], product,
                            lt.getHour(), lt.getMinute(), lt.getSecond());
                    isProcessed = true;
                    break;
                }
            }
            if (!isProcessed){
                queue.offer(product);
            }
        }
    }

    private static LocalTime ReadTime(Scanner scan) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
        String strTime = scan.nextLine();
        LocalTime time = LocalTime.parse(strTime, formatter);

        return time;
    }
}
