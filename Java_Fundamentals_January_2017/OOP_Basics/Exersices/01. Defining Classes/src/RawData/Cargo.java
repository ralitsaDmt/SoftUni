package RawData;

public class Cargo {
    private Integer weight;
    private String type;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cargo(Integer weight, String type) {

        this.weight = weight;
        this.type = type;
    }
}
