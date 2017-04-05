package pawinc.models.animals;

public abstract class Animal {

    private String name;
    private int age;
    private boolean isCleansed;
    private String adoptionCenter;

    protected void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    protected void setAge(int age) {
        this.age = age;
    }


    public boolean getCleansingStatus(){
        return this.isCleansed;
    }

    protected void setAdoptionCenter(String adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    public String getAdoptionCenter(){
        return this.adoptionCenter;
    }

    protected Animal (String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.isCleansed = false;
        this.setAdoptionCenter("");
    }

    protected Animal(String name, int age, String adoptionCenter){
        this(name, age);
        this.setAdoptionCenter(adoptionCenter);
    }

    public void cleanse(){
        this.isCleansed = true;
    }
}
