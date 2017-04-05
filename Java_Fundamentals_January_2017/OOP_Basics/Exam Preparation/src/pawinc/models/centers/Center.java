package pawinc.models.centers;

import pawinc.models.animals.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Center {

    private String name;
    private List<Animal> animals;

    protected void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List<Animal> getAnimals(){
        return Collections.unmodifiableList(this.animals);
    }

    protected Center(String name) {
        this.setName(name);
        this.animals = new ArrayList<>();
    }

    public void regiter(Animal animal) {
        this.animals.add(animal);
    }

    public void regiterAll(List<Animal> animals) {
        this.animals.addAll(animals);
    }

    public void removeAnimals(List<Animal> animals) {
        this.animals.removeAll(animals);
    }
}
