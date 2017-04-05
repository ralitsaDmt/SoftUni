package CatLady;

public class Cymric extends Cat{

    private String furLength;

    public Cymric(String name, String furLength){
        super(name);

        this.setFurLength(furLength);
    }

    private void setFurLength(String value){
        // validation

        this.furLength = value;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.furLength;
    }
}
