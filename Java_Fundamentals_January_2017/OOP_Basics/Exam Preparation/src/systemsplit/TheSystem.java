package systemsplit;

import systemsplit.components.hardwareComponents.HardwareComponent;
import systemsplit.components.hardwareComponents.HeavyHardwareComponent;
import systemsplit.components.hardwareComponents.PowerHardwareComponent;
import systemsplit.components.softwareComponents.ExpressSoftwareComponent;
import systemsplit.components.softwareComponents.LightSoftwareComponent;
import systemsplit.components.softwareComponents.SoftwareComponent;

import java.util.*;

public class TheSystem {
    private LinkedHashMap<String, HardwareComponent> hardwareComponents;

    public TheSystem(){
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void interpretCommand (String command, String[] data) {

        String hardwareComponentName = "";
        String softwareComponentName = "";
        String name = "";
        int capacity = 0;
        int memory = 0;

        switch (command) {
            case "RegisterPowerHardware":
                name = data[0];
                capacity = Integer.parseInt(data[1]);
                memory = Integer.parseInt(data[2]);
                this.registerPowerHardware(name, capacity, memory);
                break;
            case "RegisterHeavyHardware":
                name = data[0];
                capacity = Integer.parseInt(data[1]);
                memory = Integer.parseInt(data[2]);
                this.registerHeavyHardware(name, capacity, memory);
                break;
            case "RegisterExpressSoftware":
                hardwareComponentName = data[0];
                name = data[1];
                capacity = Integer.parseInt(data[2]);
                memory = Integer.parseInt(data[3]);
                this.registerExpressSoftware(hardwareComponentName, name, capacity, memory);
                break;
            case "RegisterLightSoftware":
                hardwareComponentName = data[0];
                name = data[1];
                capacity = Integer.parseInt(data[2]);
                memory = Integer.parseInt(data[3]);
                this.registerLightSoftware(hardwareComponentName, name, capacity, memory);
                break;
            case "ReleaseSoftwareComponent":
                hardwareComponentName = data[0];
                softwareComponentName = data[1];
                releaseSoftwareComponent(hardwareComponentName, softwareComponentName);
                break;
            case "Analyze":
                String analysis = this.analyze();
                System.out.println(analysis);
                break;
            case "System Split":
                System.out.println(this.split());
                break;
        }
    }

    private void registerPowerHardware(String name, int capacity, int memory){
        PowerHardwareComponent component = new PowerHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, component);
    }

    private void registerHeavyHardware(String name, int capacity, int memory){
        HeavyHardwareComponent component = new HeavyHardwareComponent(name, capacity, memory);
        this.hardwareComponents.put(name, component);
    }

    private void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory){

        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);

            ExpressSoftwareComponent softwareComponent = new ExpressSoftwareComponent(name, capacity, memory);

            hardwareComponent.registerSoftwareComponent(softwareComponent);
        }
    }

    private void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);

            LightSoftwareComponent softwareComponent = new LightSoftwareComponent(name, capacity, memory);

            hardwareComponent.registerSoftwareComponent(softwareComponent);
        }
    }

    private void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {

            HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);

            hardwareComponent.removeSoftwareComponent(softwareComponentName);
        }
    }

    private String analyze(){
        StringBuilder builder = new StringBuilder();

        int countOfHardwareComponents = HardwareComponent.ComponentsCount;
        int countOfSoftwareComponents = countSoftwareComponents();

        String memoryInfo = getMemoryInfo();
        String capacityInfo = getCapacityInto();

        builder.append("System Analysis\n")
                .append(String.format("Hardware Components: %d\n", countOfHardwareComponents))
                .append(String.format("Software Components: %d\n", countOfSoftwareComponents))
                .append(memoryInfo)
                .append(capacityInfo);

        return builder.toString();
    }

    private String split(){
        List<PowerHardwareComponent> powerPowerHardwareComponents = getPowerHardwareComponents();
        List<HeavyHardwareComponent> heavyHeavyHardwareComponents = getHeavyHardwareComponents();

        StringBuilder builder = new StringBuilder();

        String powerComponentsInfo = getPowerHardwareComponentsInfo(powerPowerHardwareComponents);
        String heavyComponentsInfo = getHeavyHardwareComponentsInfo(heavyHeavyHardwareComponents);

        builder.append(powerComponentsInfo)
                .append(heavyComponentsInfo);

        return builder.toString();
    }

    private int countSoftwareComponents() {
        int countOfSoftwareComponents = 0;

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            countOfSoftwareComponents += hardwareComponent.getSoftwareComponents().size();
        }

        return countOfSoftwareComponents;
    }

    private String getMemoryInfo() {
        long memoryInUse = 0;
        long maximumMemory = 0;

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            maximumMemory += hardwareComponent.getMemory();

            for (SoftwareComponent softwareComponent : hardwareComponent.getSoftwareComponents().values()) {
                memoryInUse += softwareComponent.getMemory();
            }
        }

        String memoryInfo = String.format("Total Operational Memory: %d / %d\n", memoryInUse, maximumMemory);
        return memoryInfo;
    }

    private String getCapacityInto(){
        long capacityInUse = 0;
        long maximumCapacity = 0;

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            maximumCapacity += hardwareComponent.getCapacity();

            for (SoftwareComponent  component: hardwareComponent.getSoftwareComponents().values()) {
                capacityInUse += component.getCapacity();
            }
        }

        String capacityInfo = String.format("Total Capacity Taken: %d / %d", capacityInUse, maximumCapacity);
        return capacityInfo;
    }

    private List<PowerHardwareComponent> getPowerHardwareComponents() {
        List<PowerHardwareComponent> powerHardwareComponents = new LinkedList<>();

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            String hardwareComponentType = hardwareComponent.getType();
            if (hardwareComponentType.equals("Power")) {
                powerHardwareComponents.add((PowerHardwareComponent) hardwareComponent);
            }
        }

        return powerHardwareComponents;
    }

    private List<HeavyHardwareComponent> getHeavyHardwareComponents() {
        List<HeavyHardwareComponent> heavyHardwareComponents = new LinkedList<>();

        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            String hardwareComponentType = hardwareComponent.getType();
            if (hardwareComponentType.equals("Heavy")) {
                heavyHardwareComponents.add((HeavyHardwareComponent) hardwareComponent);
            }
        }

        return heavyHardwareComponents;
    }

    private String getPowerHardwareComponentsInfo (List<PowerHardwareComponent> hardwareComponents) {

        StringBuilder builder = new StringBuilder();

        for (HardwareComponent hardwareComponent : hardwareComponents) {

            String name = hardwareComponent.getName();
            int expressSoftwareComponentsCount = getSoftwareComponentsCount(hardwareComponent, "Express");
            int lightSoftwareComponentsCount = getSoftwareComponentsCount(hardwareComponent, "Light");
            long memoryUsage = getMemoryUsage(hardwareComponent);
            long capacityUsage = getCapacityUsage(hardwareComponent);
            int maximumMemory = hardwareComponent.getMemory();
            int maximumCapacity = hardwareComponent.getCapacity();
            String softwareComponentsNames = getSoftwareComponentsNames(hardwareComponent);

            builder.append(String.format("Hardware Component - %s\n", name))
                    .append("Express Software Components - " + expressSoftwareComponentsCount + "\n")
                    .append("Light Software Components - " + lightSoftwareComponentsCount + "\n")
                    .append(String.format("Memory Usage: %d / %d\n", memoryUsage, maximumMemory))
                    .append(String.format("Capacity Usage: %d / %d\n", capacityUsage, maximumCapacity))
                    .append(String.format("Type: %s\n", hardwareComponent.getType()))
                    .append(String.format("Software Components: %s\n", softwareComponentsNames));
        }

        return builder.toString();
    }

    private String getHeavyHardwareComponentsInfo (List<HeavyHardwareComponent> hardwareComponents) {

        StringBuilder builder = new StringBuilder();

        for (HardwareComponent hardwareComponent : hardwareComponents) {

            String name = hardwareComponent.getName();
            int expressSoftwareComponentsCount = getSoftwareComponentsCount(hardwareComponent, "Express");
            int lightSoftwareComponentsCount = getSoftwareComponentsCount(hardwareComponent, "Light");
            long memoryUsage = getMemoryUsage(hardwareComponent);
            long capacityUsage = getCapacityUsage(hardwareComponent);
            int maximumMemory = hardwareComponent.getMemory();
            int maximumCapacity = hardwareComponent.getCapacity();
            String softwareComponentsNames = getSoftwareComponentsNames(hardwareComponent);

            builder.append(String.format("Hardware Component - %s\n", name))
                    .append("Express Software Components - " + expressSoftwareComponentsCount + "\n")
                    .append("Light Software Components - " + lightSoftwareComponentsCount + "\n")
                    .append(String.format("Memory Usage: %d / %d\n", memoryUsage, maximumMemory))
                    .append(String.format("Capacity Usage: %d / %d\n", capacityUsage, maximumCapacity))
                    .append(String.format("Type: %s\n", hardwareComponent.getType()))
                    .append(String.format("Software Components: %s\n", softwareComponentsNames));
        }

        return builder.toString();
    }

    private int getSoftwareComponentsCount (HardwareComponent hardwareComponent, String type) {
        int softwareComponentCount = 0;

        for (SoftwareComponent softwareComponent : hardwareComponent.getSoftwareComponents().values()) {
            String softwareComponentType = softwareComponent.getType();

            if (softwareComponentType.equals(type)) {
                softwareComponentCount++;
            }
        }

        return softwareComponentCount;
    }

    private long getMemoryUsage (HardwareComponent hardwareComponent) {
        long memoryUsage = 0;

        for (SoftwareComponent softwareComponent : hardwareComponent.getSoftwareComponents().values()) {
            memoryUsage += softwareComponent.getMemory();
        }

        return memoryUsage;
    }

    private long getCapacityUsage (HardwareComponent hardwareComponent) {
        long capacityUsage = 0;

        for (SoftwareComponent softwareComponent : hardwareComponent.getSoftwareComponents().values()) {
            capacityUsage += softwareComponent.getCapacity();
        }

        return capacityUsage;
    }

    private String getSoftwareComponentsNames(HardwareComponent hardwareComponent) {
        StringBuilder builder = new StringBuilder();

        for (String componentName : hardwareComponent.getSoftwareComponents().keySet()) {
            builder.append(componentName + ", ");
        }

        String result = builder.substring(0, builder.length() - 2);

        return result;
    }
}
