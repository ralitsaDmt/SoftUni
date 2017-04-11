package p02_services;

public class OnlineStoreOrder {

    public void process(CompositeNotificationService service) {
        service.sendNotifications();
    }
}
