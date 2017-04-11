package Pr_01_Logger.appenders;

import Pr_01_Logger.enums.Report;

public interface Appender {
    void appendMessage(String dateTime, String message, Report reportLevel);
}
