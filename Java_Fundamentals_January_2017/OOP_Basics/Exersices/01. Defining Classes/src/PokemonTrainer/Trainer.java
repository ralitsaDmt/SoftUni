package PokemonTrainer;

import java.util.List;

public class Trainer {

    private String name;
    private Integer badges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, List<Pokemon> pokemonList) {

        this.name = name;
        this.badges = 0;
        this.pokemonList = pokemonList;
    }

    public Integer getBadges(){
        return this.badges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void incrementBadges(){
        this.badges++;
    }

    public void setPokemonList(List<Pokemon> pokemonList){
        this.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        return this.name + " " + this.badges + " " + this.pokemonList.size();
    }
}
