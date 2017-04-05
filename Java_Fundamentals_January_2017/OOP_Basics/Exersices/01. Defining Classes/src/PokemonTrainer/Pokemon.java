package PokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private Integer health;

    public Pokemon(String name, String element, Integer health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public Integer getHealth(){
        return health;
    }

    public void decreaseHealth(){
        this.health -= 10;
    }
}
