package pawinc.models;

import pawinc.models.animals.Animal;
import pawinc.models.animals.Cat;
import pawinc.models.animals.Dog;
import pawinc.models.centers.AdoptionCenter;
import pawinc.models.centers.CastrationCenter;
import pawinc.models.centers.Center;
import pawinc.models.centers.CleansingCenter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private Map<String, AdoptionCenter> adoptionCenters;
    private Map<String, CleansingCenter> cleansingCenters;
    private Map<String, CastrationCenter> castrationCenters;
    private List<Animal> cleansedAnimals;
    private List<Animal> adoptedAnimals;
    private List<Animal> castratedAnimals;

    public AnimalCenterManager(){
        this.adoptionCenters = new HashMap();
        this.cleansingCenters = new HashMap();
        this.castrationCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter center = new CleansingCenter(name);
        this.cleansingCenters.put(name, center);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter center = new AdoptionCenter(name);
        this.adoptionCenters.put(name, center);
    }

    public void registerCastratingCenter(String name) {
        CastrationCenter center = new CastrationCenter(name);
        this.castrationCenters.put(name, center);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, adoptionCenterName, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).regiter(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName){
        Cat cat = new Cat(name, age, adoptionCenterName, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).regiter(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName){

        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(cleansingCenter);
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        CastrationCenter castrationCenter = this.castrationCenters.get(castrationCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCastration(castrationCenter);
    }

    public void adopt(String adoptionCenterName){
        List<Animal> adoptedAnimals = this.adoptionCenters.get(adoptionCenterName).adoptCleansedAnimals();

        this.adoptedAnimals.addAll(adoptedAnimals);
    }

    public void cleanse(String cleansingCenterName){
        List<Animal> cleansedAnimals = this.cleansingCenters.get(cleansingCenterName).cleanse();

        this.cleansedAnimals.addAll(cleansedAnimals);

        for (Animal cleansedAnimal : cleansedAnimals) {
            this.adoptionCenters.get(cleansedAnimal.getAdoptionCenter()).regiter(cleansedAnimal);
        }
    }

    public void castrate(String castrationCenter){
        List<Animal> castrated = this.castrationCenters.get(castrationCenter).castrate();

        this.castratedAnimals.addAll(castrated);

        for (Animal castratedAnimal : castrated) {
            this.adoptionCenters.get(castratedAnimal.getAdoptionCenter()).regiter(castratedAnimal);
        }
    }

    public void castrationStatistics(){

        StringBuilder builder = new StringBuilder();

        builder.append("Paw Inc. Regular Castration Statistics\n")
                .append(String.format("Castration Centers: %d\n", this.castrationCenters.size()))
                .append(String.format("Castrated Animals: %s", getSortedAnimals(this.castratedAnimals)));

        System.out.println(builder);
    }

    public void printStatistics(){

        StringBuilder builder = new StringBuilder();

        builder.append("Paw Incorporative Regular Statistics\n")
                .append(String.format("Adoption Centers: %d\n", this.adoptionCenters.size()))
                .append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()))
                .append(String.format("Adopted Animals: %s\n", getSortedAnimals(this.adoptedAnimals)))
                .append(String.format("Cleansed Animals: %s\n", getSortedAnimals(this.cleansedAnimals)))
                .append(String.format("Animals Awaiting Adoption: %d\n", getAwaitingAdoptionCount(true)))
                .append(String.format("Animals Awaiting Cleansing: %d", getAwaitingCleansingCount(false)));

        System.out.println(builder);
    }

    private int getAwaitingCleansingCount(boolean flag) {
        int awaitingAnimalsCount = this.cleansingCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .collect(Collectors.toList())
                .size();

        return awaitingAnimalsCount;
    }

    private int getAwaitingAdoptionCount(boolean flag) {

        int awaitingAnimalsCount = this.adoptionCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .filter(a -> a.getCleansingStatus() == flag)
                .collect(Collectors.toList())
                .size();

        return awaitingAnimalsCount;
    }

    private Object getSortedAnimals(List<Animal> animals) {
        if (animals.isEmpty()) {
            return "None";
        }

        List<String> animalNames = animals.stream()
                .map(Animal::getName)
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());

        String result = String.join(", ", animalNames);
        return result;
    }

    public static void main(String[] args) {
        AnimalCenterManager acm = new AnimalCenterManager();

        acm.registerAdoptionCenter("Destiny");
        acm.registerDog("Sharo", 5, 5, "Destiny");

        acm.registerCleansingCenter("Hope");

        acm.sendForCleansing("Destiny", "Hope");

        acm.cleanse("Hope");

        acm.adopt("Destiny");

        acm.printStatistics();

    }
}
