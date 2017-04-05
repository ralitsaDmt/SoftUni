package pawinc.models.centers;

import pawinc.models.animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleansing(CleansingCenter center) {
        List<Animal> uncleansedAnimals = super.getAnimals().stream()
                .filter(a -> !a.getCleansingStatus())
                .collect(Collectors.toList());

        super.removeAnimals(uncleansedAnimals);
        center.regiterAll(uncleansedAnimals);
    }

    public void sendForCastration(CastrationCenter center) {
        List<Animal> uncleansedAnimals = super.getAnimals().stream()
                .filter(a -> !a.getCleansingStatus())
                .collect(Collectors.toList());

        super.removeAnimals(uncleansedAnimals);
        center.regiterAll(uncleansedAnimals);
    }

    public List<Animal> adoptCleansedAnimals() {

        List<Animal> cleansedAnimas = super.getAnimals().stream()
                .filter(Animal::getCleansingStatus)
                .collect(Collectors.toList());

        super.removeAnimals(cleansedAnimas);
        return cleansedAnimas;
    }
}
