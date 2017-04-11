package p02_services;

public abstract class Service implements NotificationService {

    private boolean isActive;

    protected Service(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive(){
        return this.isActive;
    }

    public void sendNotification(){

    }
}
