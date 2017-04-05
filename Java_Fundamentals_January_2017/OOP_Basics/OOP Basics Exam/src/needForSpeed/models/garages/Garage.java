package needForSpeed.models.garages;

import needForSpeed.models.cars.Car;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Garage {

    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap();
    }

    public void parkCar(int carId, Car car) {
        this.parkedCars.put(carId, car);
    }

    public void unparkCar(int carId) {
        this.parkedCars.remove(carId);
    }

    public Map<Integer, Car> getParkedCars() {
        return Collections.unmodifiableMap(this.parkedCars);
    }
}
