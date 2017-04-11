package P04_DetailPrinter;

public class Employee {
    private String name;

    protected Employee(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
