package p02_services;

public class SmsNotificationService extends Service {

    public static final String SMS_NOTIFICATION = "SMS notification";

    public SmsNotificationService(boolean isActive) {
        super(isActive);
    }

    @Override
    public void sendNotification(){
        System.out.println(SMS_NOTIFICATION);
    }
}
