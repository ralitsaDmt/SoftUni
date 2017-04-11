package p01_system_resources.models;

import p01_system_resources.contracts.TimeProvider;
import p01_system_resources.contracts.Writer;

public class GreetingClock {


    public static final String GOOD_MORNING = "Good morning...";
    public static final String GOOD_AFTERNOON = "Good afternoon...";
    public static final String GOOD_EVENING = "Good evening...";
    private TimeProvider timeProvider;
    private Writer writer;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
    }

    public void greeting() {
        int time = timeProvider.getHour();
        if (time < 12) {
            this.writer.println(GOOD_MORNING);
        } else if (time < 18) {
            this.writer.println(GOOD_AFTERNOON);
        } else {
            this.writer.println(GOOD_EVENING);
        }
    }
}
