package Problem_05_BorderControl;

public class Robot implements Identifiable {

    private String model;
    private String id;

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public Robot(String model, String id){
        this.setModel(model);
        this.setId(id);
    }
}
