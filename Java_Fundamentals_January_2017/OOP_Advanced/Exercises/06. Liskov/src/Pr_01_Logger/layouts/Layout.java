package Pr_01_Logger.layouts;

import Pr_01_Logger.enums.Report;

public interface Layout {
    String formatMessage(String dateTime, Report report, String message);
}
