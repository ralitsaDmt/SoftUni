package p02_services;

public class EmailNotificationService extends Service {

    public static final String EMAIL_NOTIFICATION = "Email notification";

    public EmailNotificationService(boolean isActive) {
        super(isActive);
    }

    @Override
    public void sendNotification(){
        System.out.println(EMAIL_NOTIFICATION);
    }
}
