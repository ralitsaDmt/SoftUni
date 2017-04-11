package Problem_01_DayOfWeek;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        String lower = this.name().substring(1).toLowerCase();
        String upcase = this.name().charAt(0) + lower;

        return upcase;
    }
}
