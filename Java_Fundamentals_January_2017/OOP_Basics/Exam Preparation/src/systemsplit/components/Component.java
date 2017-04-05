package systemsplit.components;

public abstract class Component {

    private String name;
    private String type;

    private void setName(String name){
        this.name = name;
    }

    private void setType(String type){
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    protected int getCapacity() {
        return 0;
    };

    protected int getMemory() {
        return 0;
    }

    public Component(String name, String type){
        this.setName(name);
        this.setType(type);
    }
}
