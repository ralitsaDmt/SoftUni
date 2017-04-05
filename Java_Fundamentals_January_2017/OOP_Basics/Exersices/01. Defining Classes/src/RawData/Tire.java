package RawData;

public class Tire {
    private Double pressure;
    private Integer age;

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Tire(Double pressure, Integer age) {

        this.pressure = pressure;
        this.age = age;
    }
}
