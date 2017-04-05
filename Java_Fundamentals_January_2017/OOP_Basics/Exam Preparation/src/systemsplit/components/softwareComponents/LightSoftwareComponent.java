package systemsplit.components.softwareComponents;

import systemsplit.components.ComponentTypes;

public class LightSoftwareComponent extends SoftwareComponent {

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    public int getCapacity() {
        int increasedCapacityConsumption = (int)(super.getCapacity() * 1.5);
        return increasedCapacityConsumption;
    }

    @Override
    public int getMemory() {
        int decreasedMemoryConsumption = (int)(super.getMemory() * 0.5);
        return decreasedMemoryConsumption;
    }

    @Override
    public String getType () {
        return String.valueOf(ComponentTypes.Light);
    }
}
