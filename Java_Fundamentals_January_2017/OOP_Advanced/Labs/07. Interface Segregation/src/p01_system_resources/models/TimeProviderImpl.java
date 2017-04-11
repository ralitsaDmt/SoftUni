package p01_system_resources.models;

import p01_system_resources.contracts.TimeProvider;

import java.time.LocalTime;

public class TimeProviderImpl implements TimeProvider {

    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}
