package Pr_01_Logger.layouts;

import Pr_01_Logger.enums.Report;

public class SimpleLayout implements Layout {

    private final String format = "%s - %s - %s";

    @Override
    public String formatMessage(String dateTime, Report report, String message) {
        String output = String.format(format, dateTime, report, message);
        return output;
    }
}
