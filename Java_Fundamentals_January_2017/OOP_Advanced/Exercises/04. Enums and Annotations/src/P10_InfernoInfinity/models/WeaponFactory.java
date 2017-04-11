package P10_InfernoInfinity.models;

public class WeaponFactory {

    public Weapon createWeapon(String kind, String name) {

        switch (kind) {
            case "AXE": return new Axe(name);
            case "SWORD": return new Sword(name);
            case "KNIFE": return new Knife(name);
            default: return null;
        }
    }

}
