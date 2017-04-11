package p01_system_resources;

import p01_system_resources.contracts.TimeProvider;
import p01_system_resources.contracts.Writer;
import p01_system_resources.models.GreetingClock;
import p01_system_resources.models.TimeProviderImpl;
import p01_system_resources.models.WriterImpl;

public class Main {
    public static void main(String[] args) {
        TimeProvider timeProvider = new TimeProviderImpl();
        Writer writer = new WriterImpl();

        GreetingClock clock = new GreetingClock(timeProvider, writer);
        clock.greeting();
    }
}
