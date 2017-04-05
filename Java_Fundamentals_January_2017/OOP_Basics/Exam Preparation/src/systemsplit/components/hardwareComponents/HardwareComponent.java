package systemsplit.components.hardwareComponents;

import systemsplit.components.Component;
import systemsplit.components.ComponentTypes;
import systemsplit.components.softwareComponents.SoftwareComponent;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class HardwareComponent extends Component {

    private LinkedHashMap<String, SoftwareComponent> softwareComponents;

    private int maximumCapacity;
    private int maximumMemory;
    private int currentCapacity;
    private int currentMemory;

    public static int ComponentsCount;

    private void setMaximumCapacity(int capacity){
        this.maximumCapacity = capacity;
    }

    private void setMaximumMemory(int memory){
        this.maximumMemory = memory;
    }

    private void setCurrentCapacity (int capacity) {
        this.currentCapacity = capacity;
    }

    private void setCurrentMemory (int memory) {
        this.currentMemory = memory;
    }

    @Override
    public int getMemory() {
        return this.maximumMemory;
    }

    @Override
    public int getCapacity(){
        return this.maximumCapacity;
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent){
        String softwareComponentName = softwareComponent.getName();

        if (this.currentCapacity >= softwareComponent.getCapacity()
                && this.currentMemory >= softwareComponent.getMemory()) {
            this.softwareComponents.put(softwareComponentName, softwareComponent);

            int decreasedCapasity = this.currentCapacity - softwareComponent.getCapacity();
            int decreasedMemory = this.currentMemory - softwareComponent.getMemory();

            this.setCurrentCapacity(decreasedCapasity);
            this.setCurrentMemory(decreasedMemory);
        }
    }

    public Map<String, SoftwareComponent> getSoftwareComponents(){
        return Collections.unmodifiableMap(this.softwareComponents);
    }

    public void removeSoftwareComponent(String softwareComponentName) {
        if (this.softwareComponents.containsKey(softwareComponentName)) {
            this.softwareComponents.remove(softwareComponentName);
        }
    }

    public HardwareComponent(String name, int capacity, int memory){
        super(name, String.valueOf(ComponentTypes.HARDWARE));
        this.setMaximumCapacity(capacity);
        this.setMaximumMemory(memory);
        this.currentCapacity = this.getCapacity();
        this.currentMemory = this.getMemory();
        this.softwareComponents = new LinkedHashMap<>();
        ComponentsCount++;
    }
}
