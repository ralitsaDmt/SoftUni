package Pr_01_Logger.controllers;

import Pr_01_Logger.appenders.Appender;
import Pr_01_Logger.appenders.ConsoleAppender;
import Pr_01_Logger.appenders.FileAppender;
import Pr_01_Logger.files.CustomFile;
import Pr_01_Logger.files.LogFile;
import Pr_01_Logger.layouts.Layout;
import Pr_01_Logger.layouts.SimpleLayout;
import Pr_01_Logger.loggers.Logger;
import Pr_01_Logger.loggers.MessageLogger;

public class LoggerController implements Controller {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        CustomFile file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logError("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");


    }
}
