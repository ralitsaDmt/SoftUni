package Pr_01_Logger.enums;

public enum Report {

    INFO(1),
    WARNING(2),
    ERROR(3),
    CRITICAL(4),
    FATAL(5);

    final int value;

    Report(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
