package CatLady;

public abstract class Cat {
    private String name;

    public Cat(String name){
        this.setName(name);
    }

    private void setName(String value){
        // validation

        this.name = value;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + " " + this.name;
    }

}
