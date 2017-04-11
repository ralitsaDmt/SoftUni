package p02_services;

public class CompositeNotificationService {

    private NotificationService[] services;

    public CompositeNotificationService(NotificationService... services){
        this.services = services;
    }

    public void sendNotifications(){
        for (NotificationService service : this.services) {
            if (service.isActive()) {
                service.sendNotification();
            }
        }
    }
}
