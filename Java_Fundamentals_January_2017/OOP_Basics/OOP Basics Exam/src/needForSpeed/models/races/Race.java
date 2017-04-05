package needForSpeed.models.races;

import needForSpeed.models.cars.Car;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private List<Car> cars;

    public Race (int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.cars = new LinkedList<>();
    }

    public int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
