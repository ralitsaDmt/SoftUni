package CatLady;

public class StreetExtraordinaire extends Cat{

    private String decibelsOfMeows;

    public StreetExtraordinaire(String name, String decibelsOfMeows){
        super(name);

        this.setDecibelsOfMeows(decibelsOfMeows);
    }

    private void setDecibelsOfMeows(String value){
        // validation

        this.decibelsOfMeows = value;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.decibelsOfMeows;
    }
}
