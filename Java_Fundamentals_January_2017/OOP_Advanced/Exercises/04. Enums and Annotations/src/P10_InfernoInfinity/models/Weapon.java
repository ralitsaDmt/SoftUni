package P10_InfernoInfinity.models;

import P10_InfernoInfinity.enums.Gem;

public abstract class Weapon implements Comparable {

    private String name;
    private int minDamage;
    private int maxDamage;
    private Gem[] sockets;

    protected Weapon(String name, int numberOfSockets, int minDamage, int maxDamage){
        this.name = name;
        this.setSockets(numberOfSockets);
        this.setMinDamage(minDamage);
        this.setMaxDamage(maxDamage);
    }

    private void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    private void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    private void setSockets(int socketsCount) {
        this.sockets = new Gem[socketsCount];
    }

    private int getStrength() {
        int totalStrength = 0;

        for (Gem gem : sockets) {
            if (gem != null) {
                totalStrength += gem.getStrength();
            }
        }
        return totalStrength;
    }

    private int getAgility(){
        int totalAgility = 0;
        for (Gem gem : sockets) {
            if (gem != null) {
                totalAgility += gem.getAgility();
            }
        }
        return totalAgility;
    }

    private int getVitality(){
        int totalVitality = 0;
        for (Gem gem : sockets) {
            if (gem != null) {
                totalVitality += gem.getVitality();
            }
        }
        return totalVitality;
    }

    private double getLevel(){
        int strength = this.getStrength();
        int agility = this.getAgility();
        int vitality = this.getVitality();
        int minDamage = this.getMinDamage(strength, agility);
        int maxDamage = this.getMaxDamage(strength, agility);

        double level = (minDamage + maxDamage) / 2.0 + strength + agility + vitality;
        return level;
    }

    private int getMinDamage(int strength, int agility) {
        int bonusDamageFromStrength = strength * 2;
        int bonusDamageFromAgility = agility;

        int currentMinDamage = this.minDamage + bonusDamageFromStrength + bonusDamageFromAgility;
        return currentMinDamage;
    }

    private int getMaxDamage(int strength, int agility) {
        int bonusDamageFromStrength = strength * 3;
        int bonusDamageFromAgility = agility * 4;

        int currentMaxDamage = this.maxDamage + bonusDamageFromStrength + bonusDamageFromAgility;
        return currentMaxDamage;
    }

    public void insertGem(int socketIndex, String gemType){

        if (socketIndex >= 0 && socketIndex < this.sockets.length){
            Gem gem = Enum.valueOf(Gem.class, gemType);
            this.sockets[socketIndex] = gem;
        }
    }

    public void removeGem(int socketIndex){
        if (socketIndex >= 0 && socketIndex < this.sockets.length){
            this.sockets[socketIndex] = null;
        }
    }

    @Override
    public String toString() {
        int strength = this.getStrength();
        int agility = this.getAgility();
        int vitality = this.getVitality();

        int minDamage = this.getMinDamage(strength, agility);
        int maxDamage = this.getMaxDamage(strength, agility);

        double level = this.getLevel();
        String strLevel = String.format("%.1f", level).replace(',', '.');

        String name = this.name;

        String ouput = String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %s)",
                name, minDamage, maxDamage, strength, agility, vitality, strLevel);
        return ouput;
    }

    @Override
    public int compareTo(Object o) {
        Weapon other = (Weapon)o;
        double comparator = this.getLevel() - other.getLevel();
        return (int)comparator;
    }
}
