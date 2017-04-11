package Problem_08_PetClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Clinic> clinics = new HashMap<>();
        Map<String, Pet> pets = new HashMap<>();

        int numberOfCommands = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandLine = reader.readLine().split("\\s+");

            String command = commandLine[0];

            switch (command){
                case "Create":
                    String itemToCreate = commandLine[1];
                    switch (itemToCreate){
                        case "Pet":
                            createPet(commandLine, pets);
                            break;
                        case "Clinic":
                            createClinic(commandLine, clinics);
                            break;
                    }
                    break;
                case "Add":
                    try {
                        boolean petAdded = addPetToAClinic(commandLine, clinics, pets);
                        System.out.println(petAdded);
                    } catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Release":
                    boolean petReleased = releasePet(commandLine, clinics);
                    System.out.println(petReleased);
                    break;
                case "HasEmptyRooms":
                    boolean hasAvailableRooms = hasEmptyRooms(commandLine, clinics);
                    System.out.println(hasAvailableRooms);
                    break;
                case "Print":
                    if (commandLine.length == 2){
                        printClinic(commandLine, clinics);
                    } else {
                        printClinicRoomContent(commandLine, clinics);
                    }
                    break;
            }
        }
    }

    private static void createPet(String[] data, Map<String, Pet> pets){
        String name = data[2];
        int age = Integer.parseInt(data[3]);
        String kind = data[4];

        Pet pet = new Pet(name, age, kind);

        pets.put(name, pet);
    }

    private static void createClinic(String[] data, Map<String, Clinic> clinics){
        String name = data[2];
        int numberOfRooms = Integer.parseInt(data[3]);

        try {
            Clinic clinic = new Clinic(name, numberOfRooms);
            clinics.put(name, clinic);
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static boolean addPetToAClinic(String[] data, Map<String, Clinic> clinics, Map<String, Pet> pets){
        String petName = data[1];
        String clinicName = data[2];

        Clinic clinic = clinics.get(clinicName);
        Pet pet = pets.get(petName);

        boolean petSuccessfullyAdded = clinic.addPet(pet);

        return petSuccessfullyAdded;
    }

    private static boolean releasePet(String[] data, Map<String, Clinic> clinics){
        String clinicName = data[1];

        Clinic clinic = clinics.get(clinicName);
        boolean petReleased = clinic.releasePet();
        return petReleased;
    }

    private static boolean hasEmptyRooms(String[] data, Map<String, Clinic> clinics){
        String clinicName = data[1];

        Clinic clinic = clinics.get(clinicName);
        boolean hasRooms = clinic.hasEmptyRoom();
        return hasRooms;
    }

    private static void printClinic(String[] data, Map<String, Clinic> clinics){
        String clinicName = data[1];

        Clinic clinic = clinics.get(clinicName);
        String clinicInfo = clinic.printRooms();
        System.out.println(clinicInfo);
    }

    private static void printClinicRoomContent(String[] data, Map<String, Clinic> clinics){
        String clinicName = data[1];
        int roomNumber = Integer.parseInt(data[2]) - 1;

        Clinic clinic = clinics.get(clinicName);
        String clinicInfo = clinic.printRoomByIndex(roomNumber);
        System.out.println(clinicInfo);
    }
}
