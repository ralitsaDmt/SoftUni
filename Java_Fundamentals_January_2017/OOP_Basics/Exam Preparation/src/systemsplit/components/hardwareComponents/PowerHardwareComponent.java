package systemsplit.components.hardwareComponents;

import systemsplit.components.ComponentTypes;

public class PowerHardwareComponent extends HardwareComponent {

    public PowerHardwareComponent(String name, int capacity, int memory)
    {
        super(name, capacity, memory);
    }

    @Override
    public int getCapacity() {
        int decreasedCapacity = (int)Math.round(super.getCapacity() * 0.25);
        return decreasedCapacity;
    }

    @Override
    public int getMemory() {
        int increasedMemory = (int)Math.round(super.getMemory() * 1.75);
        return increasedMemory;
    }

    @Override
    public String getType () {
        return String.valueOf(ComponentTypes.Power);
    }
}
