package systemsplit.components.hardwareComponents;

import systemsplit.components.ComponentTypes;

public class HeavyHardwareComponent extends HardwareComponent {

    public HeavyHardwareComponent(
            String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    public int getCapacity() {
        int doubledCapacity = super.getCapacity() * 2;
        return doubledCapacity;
    }

    @Override
    public int getMemory() {
        int decreasedMemory = (int)Math.round(super.getMemory() * 0.75);
        return decreasedMemory;
    }

    @Override
    public String getType () {
        return String.valueOf(ComponentTypes.Heavy);
    }
}
