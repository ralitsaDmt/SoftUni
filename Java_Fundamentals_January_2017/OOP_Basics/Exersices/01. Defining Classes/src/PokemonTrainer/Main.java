package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, Trainer> trainers;

    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        trainers = new HashMap<>();

        while (true){
            String[] line = in.readLine().split("\\s+");
            if ("Tournament".equals(line[0])){
                break;
            }

            String trainerName = line[0];
            String pokemonName = line[1];
            String pokemonElement = line[2];
            Integer pokemonHealth = Integer.parseInt(line[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainers.containsKey(trainerName)){
                trainers.put(trainerName, new Trainer(trainerName, new LinkedList<>()));
            }

            trainers.get(trainerName).getPokemonList().add(pokemon);
        }

        while (true){
            String command = in.readLine();
            if ("End".equals(command)){
                break;
            }

            trainers.entrySet().stream()
                    .filter(t -> t.getValue().getPokemonList().stream().anyMatch(p -> p.getElement().equals(command)))
                    .forEach(t -> t.getValue().incrementBadges());

            trainers.entrySet().stream()
                    .filter(t -> t.getValue().getPokemonList().stream().noneMatch(p -> p.getElement().equals(command)))
                    .forEach(t -> t.getValue().getPokemonList().forEach(Pokemon::decreaseHealth));
        }

        for (Trainer trainer : trainers.values()) {

            List<Pokemon> filtered = trainer.getPokemonList().stream().filter(p -> p.getHealth() > 0).collect(Collectors.toList());
            trainer.setPokemonList(filtered);
        }

        trainers.entrySet().stream()
                .sorted((t1, t2) -> t2.getValue().getBadges().compareTo(t1.getValue().getBadges()))
                .forEach(t -> System.out.println(t.getValue()));
    }
}
