package systemsplit.components.softwareComponents;

import systemsplit.components.Component;
import systemsplit.components.ComponentTypes;

public abstract class SoftwareComponent extends Component {

    private int capacityConsumption;
    private int memoryConsumption;

    public static int ComponentsCount;

    private void setCapacityConsumption(int capacityConsumption){
        this.capacityConsumption = capacityConsumption;
    }

    private void setMemoryConsumption(int memoryConsumption){
        this.memoryConsumption = memoryConsumption;
    }

    @Override
    public int getCapacity(){
        return this.capacityConsumption;
    }

    @Override
    public int getMemory(){
        return this.memoryConsumption;
    }

    public SoftwareComponent(String name, int capacity, int memory) {
        super(name, String.valueOf(ComponentTypes.SOFTWARE));
        this.setCapacityConsumption(capacity);
        this.setMemoryConsumption(memory);
        ComponentsCount++;
    }
}
