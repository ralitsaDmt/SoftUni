package Problem_01_DayOfWeek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        WeeklyCalendar calendar = new WeeklyCalendar();

        calendar.addEntry("Friday", "Sleep");
        calendar.addEntry("Monday", "Sport");

        Iterable<WeeklyEntry> schedule = calendar.getWeeklyShedule();

        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}
