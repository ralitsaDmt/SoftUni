package systemsplit.components.softwareComponents;

import systemsplit.components.ComponentTypes;

public class ExpressSoftwareComponent extends SoftwareComponent {

    public ExpressSoftwareComponent(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public int getMemory() {
        int doubledMemory = super.getMemory() * 2;
        return doubledMemory;
    }

    @Override
    public String getType () {
        return String.valueOf(ComponentTypes.Express);
    }
}
