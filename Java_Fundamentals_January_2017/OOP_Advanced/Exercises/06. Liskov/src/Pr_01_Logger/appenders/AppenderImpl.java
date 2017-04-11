package Pr_01_Logger.appenders;

import Pr_01_Logger.enums.Report;
import Pr_01_Logger.layouts.Layout;

public abstract class AppenderImpl implements Appender {

    private Layout layout;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
    }

    protected String formatMessage(String dateTime, Report reportLevel, String message){
        String formattedMessage = this.layout.formatMessage(dateTime, reportLevel, message);
        return formattedMessage;
    }

}
