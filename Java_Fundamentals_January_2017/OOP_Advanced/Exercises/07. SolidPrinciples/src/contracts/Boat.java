package contracts;

public interface Boat extends Modelable {
    int getWeight();

    double calculateRaceSpeed(int oceanCurrentSpeed, int windSpeed);
}
