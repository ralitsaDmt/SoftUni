package Pr_01_Logger.appenders;

import Pr_01_Logger.enums.Report;
import Pr_01_Logger.layouts.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(String dateTime, String message, Report reportLevel) {
        String messageToAppend = super.formatMessage(dateTime, reportLevel, message);
        System.out.println(messageToAppend);
    }

}
