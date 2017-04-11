package P10_InfernoInfinity;

import P10_InfernoInfinity.models.Weapon;
import P10_InfernoInfinity.models.WeaponFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandInterpreter {

    private Map<String, Weapon> weapons;
    private WeaponFactory weaponFactory;

    public CommandInterpreter(){
        this.weapons = new LinkedHashMap<>();
        this.weaponFactory = new WeaponFactory();
    }

    public void interpretCommand(String command, String[] data){
        switch (command) {
            case "Create":
                createWeapon(data);
                break;
            case "Add":
                addGemToWeapon(data);
                break;
            case "Remove":
                removeGem(data);
                break;
            case "Compare":
                compareWeapons(data);
                break;
            case "Print":
                printWeapon(data);
                break;
            case "END":
                printAllWeapons();
                break;
        }
    }

    private void createWeapon(String[] data) {
        String weaponType = data[1];
        String weaponName = data[2];

        Weapon weapon = this.weaponFactory.createWeapon(weaponType, weaponName);
        this.weapons.put(weaponName,weapon);
    }

    private void addGemToWeapon(String[] data) {
        String weaponName = data[1];
        int socketIndex = Integer.parseInt(data[2]);
        String gemType = data[3];

        Weapon weapon = this.weapons.get(weaponName);
        weapon.insertGem(socketIndex, gemType);
    }

    private void removeGem(String[] data){
        String weaponName = data[1];
        int socketIndex = Integer.parseInt(data[2]);

        Weapon weapon = this.weapons.get(weaponName);
        weapon.removeGem(socketIndex);
    }

    private void compareWeapons(String[] data){
        String firstWeaponName = data[1];
        String secondWeaponName = data[2];

        Weapon firstWeapon = this.weapons.get(firstWeaponName);
        Weapon secondWeapon = this.weapons.get(secondWeaponName);

        int comparator = firstWeapon.compareTo(secondWeapon);
        Weapon greaterWeapon = comparator >= 0 ? firstWeapon : secondWeapon;
        System.out.println(greaterWeapon);
    }

    private void printWeapon(String[] data){
        String weaponName = data[1];
        Weapon weapon = this.weapons.get(weaponName);
        System.out.println(weapon);
    }

    private void printAllWeapons(){
//        for (Weapon weapon : weapons.values()) {
//            System.out.println(weapon);
//        }
    }
}
