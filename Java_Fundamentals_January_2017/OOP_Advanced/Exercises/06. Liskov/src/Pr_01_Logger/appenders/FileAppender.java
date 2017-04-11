package Pr_01_Logger.appenders;

import Pr_01_Logger.enums.Report;
import Pr_01_Logger.files.CustomFile;
import Pr_01_Logger.layouts.Layout;

public class FileAppender extends AppenderImpl {

    private CustomFile file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(String dateTime, String message, Report reportLevel) {
        String messageToAppend = super.formatMessage(dateTime, reportLevel, message);

    }

    public void setFile(CustomFile file) {
        this.file = file;
    }
}
