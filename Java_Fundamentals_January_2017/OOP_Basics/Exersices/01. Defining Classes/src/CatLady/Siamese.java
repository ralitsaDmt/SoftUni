package CatLady;


public class Siamese extends Cat{

    private String earSize;

    public Siamese(String name, String earSize){
        super(name);
        this.setEarSize(earSize);
    }

    private void setEarSize(String value){
        // validation

        this.earSize = value;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.earSize;
    }


}
