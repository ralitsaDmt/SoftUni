package P04_DetailPrinter;

public class Worker extends Employee {
    int workHours;

    protected Worker(String name, int workHours) {
        super(name);
        this.workHours = workHours;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.workHours;
    }
}
