package Pr_01_Logger.loggers;

import Pr_01_Logger.appenders.Appender;
import Pr_01_Logger.enums.Report;

import java.util.Arrays;
import java.util.List;

public class MessageLogger implements Logger {

    private List<Appender> appenders;

    public MessageLogger(Appender... appender) {
        this.appenders = Arrays.asList(appender);

    }

    @Override
    public void logInfo(String dateTime, String message) {
        Report reportLevel = Report.INFO;
        this.callAppenders(dateTime, message, reportLevel);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        Report reportLevel = Report.WARNING;
        this.callAppenders(dateTime, message, reportLevel);
    }

    @Override
    public void logError(String dateTime, String message) {
        Report reportLevel = Report.ERROR;
        this.callAppenders(dateTime, message, reportLevel);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        Report reportLevel = Report.CRITICAL;
        this.callAppenders(dateTime, message, reportLevel);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        Report reportLevel = Report.FATAL;
        this.callAppenders(dateTime, message, reportLevel);
    }

    private void callAppenders(String dateTime, String message, Report reportLevel) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, message, reportLevel);
        }
    }
}
