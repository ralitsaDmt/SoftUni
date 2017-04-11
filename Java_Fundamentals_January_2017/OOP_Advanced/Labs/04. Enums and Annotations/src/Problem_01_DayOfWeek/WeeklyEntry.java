package Problem_01_DayOfWeek;

import java.util.Comparator;

public class WeeklyEntry {

    public final static Comparator<WeeklyEntry> BY_WEEKDAY = getCompByDay();

    private Weekday weekday;
    private String note;

    public WeeklyEntry(String weekday, String note){
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.note = note;
    }

    @Override
    public String toString() {
        String output = String.format("%s - %s",
                this.weekday, this.note);
        return output;
    }

    private static Comparator<WeeklyEntry> getCompByDay(){
        return (e1, e2) -> e1.weekday.compareTo(e2.weekday);
    }
}
