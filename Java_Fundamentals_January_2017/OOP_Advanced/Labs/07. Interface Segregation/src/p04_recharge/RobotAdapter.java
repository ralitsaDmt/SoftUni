package p04_recharge;

public class RobotAdapter implements Rechargeable {

    private Robot robot;

    public RobotAdapter(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void recharge() {
        // recharge
    }
}
