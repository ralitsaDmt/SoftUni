package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService email = new EmailNotificationService(true);
        NotificationService sms = new SmsNotificationService(false);

        CompositeNotificationService service = new CompositeNotificationService(email, sms);

        OnlineStoreOrder order = new OnlineStoreOrder();
        order.process(service);
    }
}
