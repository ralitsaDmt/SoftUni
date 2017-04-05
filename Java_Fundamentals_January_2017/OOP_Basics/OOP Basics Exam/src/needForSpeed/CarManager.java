package needForSpeed;

import needForSpeed.models.cars.Car;
import needForSpeed.models.cars.PerformanceCar;
import needForSpeed.models.cars.ShowCar;
import needForSpeed.models.garages.Garage;
import needForSpeed.models.races.CasualRace;
import needForSpeed.models.races.DragRace;
import needForSpeed.models.races.DriftRace;
import needForSpeed.models.races.Race;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarManager {

    private static final String CASUAL_RACE = "CasualRace";
    private static final String DRAG_RACE = "DragRace";
    private static final String DRIFT_RACE = "DriftRace";

    private Map<Integer, Car> registeredCars;
    private Map<Integer, Race> openedRaces;
    private Map<Integer, Race> closedRaces;
    private Garage garage;

    public CarManager(){
        this.registeredCars = new HashMap<>();
        this.openedRaces = new HashMap<>();
        this.closedRaces = new HashMap<>();
        this.garage = new Garage();
    }

    public void interpretCommand(String command, String[] data) {

        switch (command) {
            case "register":
                int carId = Integer.parseInt(data[0]);
                String type = data[1];
                String brand = data[2];
                String model = data[3];
                int year = Integer.parseInt(data[4]);
                int horsePower = Integer.parseInt(data[5]);
                int acceleration = Integer.parseInt(data[6]);
                int suspension = Integer.parseInt(data[7]);
                int durability = Integer.parseInt(data[8]);
                this.register(carId, type, brand, model, year, horsePower, acceleration, suspension, durability);
                break;
            case "check":
                carId = Integer.parseInt(data[0]);
                String result = check(carId);
                if (result != null) {
                    System.out.println(result);
                }
                break;
            case "open":
                int raceId = Integer.parseInt(data[0]);
                type = data[1];
                int length = Integer.parseInt(data[2]);
                String route = data[3];
                int prizePool = Integer.parseInt(data[4]);
                open(raceId, type, length, route, prizePool);
                break;
            case "participate":
                carId = Integer.parseInt(data[0]);
                raceId = Integer.parseInt(data[1]);
                participate(carId, raceId);
                break;
            case "start":
                raceId = Integer.parseInt(data[0]);
                result = start(raceId);
                if (result != null) {
                    System.out.println(result);
                }
                break;
            case "park":
                carId = Integer.parseInt(data[0]);
                park(carId);
                break;
            case "unpark":
                carId = Integer.parseInt(data[0]);
                unpark(carId);
                break;
            case "tune":
                int tuneIndex = Integer.parseInt(data[0]);
                String addOn = data[1];
                tune(tuneIndex, addOn);
                break;
        }
    }

    public void register(
            int id, String type, String brand, String model,
            int yearOfProduction,int horsePower,
            int acceleration, int suspension,int durability) {

        Car car = createCar(
                type, brand, model, yearOfProduction,
                horsePower, acceleration, suspension,
                durability);

        this.registeredCars.put(id, car);
    }

    public String check(int carId) {
        if (this.registeredCars.containsKey(carId)) {
            Car car = registeredCars.get(carId);
            return car.toString();
        }

        return null;
    }

    public void open (int raceId, String type, int lenght,
                      String route, int prizePool) {
        Race race = createRace(type, lenght, route, prizePool);

        this.openedRaces.put(raceId, race);
    }

    public void participate (int carId, int raceId) {
        if (!this.garage.getParkedCars().containsKey(carId)) {
            if (this.openedRaces.containsKey(raceId)) {
                Race race = this.openedRaces.get(raceId);

                Car car = this.registeredCars.get(carId);

                race.addCar(car);
            }
        }
    }

    public String start (int raceId) {

        String raceResult = null;

        if (this.openedRaces.containsKey(raceId)) {
            Race race = this.openedRaces.get(raceId);

            int raceCarsCount = race.getCars().size();
            if (raceCarsCount > 0) {
                raceResult = initiateRace(race);
                closeRace(raceId);
            }
        }

        return raceResult;
    }

    public void park (int carId) {

        if (this.registeredCars.containsKey(carId)) {
            Car car = this.registeredCars.get(carId);
            boolean isCarInRace = checkIfCarIsInRace(car);

            if (!isCarInRace) {
                this.garage.parkCar(carId, car);
            }
        }
    }

    private boolean checkIfCarIsInRace(Car car) {
        for (Race openedRace : this.openedRaces.values()) {
            if (openedRace.getCars().contains(car)) {
                return true;
            }
        }

        for (Race race : this.closedRaces.values()) {
            if (race.getCars().contains(car)) {
                return true;
            }
        }

        return false;
    }

    public void unpark (int carId) {
        if (this.garage.getParkedCars().containsKey(carId)) {
            this.garage.unparkCar(carId);
        }
    }

    public void tune (int tuneIndex, String addOn) {
        Map<Integer, Car> parkedCars = this.garage.getParkedCars();

        for (Car car : parkedCars.values()) {
            car.getTuned(tuneIndex, addOn);
        }
    }

    private Car createCar(String type, String brand,
                          String model, int yearOfProduction,
                          int horsePower, int acceleration,
                          int suspension,int durability) {
        Car car = null;
        switch (type) {
            case "Performance": car = new PerformanceCar(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
            break;
            case "Show": car = new ShowCar(brand, model, yearOfProduction, horsePower, acceleration, suspension, durability);
            break;
        }

        return car;
    }

    private Race createRace(String type, int length, String route, int prizePool) {
        Race race = null;

        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
        }

        return race;
    }

    private String initiateRace(Race race) {

        List<Car> racingCars = race.getCars();
        String raceName = race.getClass().getSimpleName();
        racingCars = startTheRace(racingCars, raceName);

        String results = getOutput(race, racingCars);
        
        return results;
    }

    private List<Car> startTheRace(List<Car> racingCars, String raceType) {

        switch (raceType) {
            case CASUAL_RACE:
                List<Car> orderedCars = racingCars.stream()
                        .sorted((c1, c2) -> {
                            if (c2.getCasualPerformancePoints() > c1.getCasualPerformancePoints()) {
                                return 1;
                            } else if (c1.getCasualPerformancePoints() > c2.getCasualPerformancePoints()) {
                                return -1;
                            }
                            return 0;
                        })
                        .limit(3)
                        .collect(Collectors.toList());
                return orderedCars;
            case DRAG_RACE:
                orderedCars = racingCars.stream()
                        .sorted((c1, c2) -> {
                            if (c2.getDragPerformancePoints() > c1.getDragPerformancePoints()) {
                                return 1;
                            } else if (c1.getDragPerformancePoints() > c2.getDragPerformancePoints()) {
                                return -1;
                            }
                            return 0;
                        })
                        .limit(3)
                        .collect(Collectors.toList());
                return orderedCars;
            case DRIFT_RACE:
                orderedCars = racingCars.stream()
                        .sorted((c1, c2) -> {
                            if (c2.getDriftHorsePoints() > c1.getDriftHorsePoints()) {
                                return 1;
                            } else if (c1.getDriftHorsePoints() > c2.getDriftHorsePoints()) {
                                return -1;
                            }
                            return 0;
                        })
                        .limit(3)
                        .collect(Collectors.toList());
                return orderedCars;
        }

        return null;
    }

    private String getOutput(Race race, List<Car> racingCars) {
        StringBuilder builder = new StringBuilder();

        String route = race.getRoute();
        int length = race.getLength();
        String routeLengthLine = String.format("%s - %d\n",route, length);

        builder.append(routeLengthLine);

        int place = 1;
        for (Car car : racingCars) {
            String brand = car.getBrand();
            String model = car.getModel();
            long performancePoints = calculatePerformancePoints(car, race);
            int moneyWon = calculatePrize(race.getPrizePool(), place);

            String carLine = String.format("%d. %s %s %dPP - $%d\n",
                    place, brand, model, performancePoints, moneyWon);

            builder.append(carLine);

            place++;
        }

        return builder.toString().trim();
    }

    private int calculatePrize(int prizePool, int place) {
        int moneyWon = 0;
        switch (place) {
            case 1: moneyWon = prizePool / 2; break;
            case 2: moneyWon = prizePool * 30 / 100; break;
            case 3: moneyWon = prizePool / 5; break;
        }
        return moneyWon;
    }

    private long calculatePerformancePoints(Car car, Race race) {
        long performancePoints = 0;

        String raceType = race.getClass().getSimpleName();
        switch (raceType){
            case CASUAL_RACE:
                performancePoints = car.getCasualPerformancePoints(); break;
            case DRAG_RACE:
                performancePoints = car.getDragPerformancePoints(); break;
            case DRIFT_RACE:
                performancePoints = car.getDriftHorsePoints(); break;
        }

        return performancePoints;
    }

    private void closeRace(int raceId) {
        Race race = this.openedRaces.get(raceId);
        this.openedRaces.remove(raceId);
        this.closedRaces.put(raceId, race);
    }
}
