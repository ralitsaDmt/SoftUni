package Problem_10_Mood3.models;

import Problem_10_Mood3.contracts.IGameObject;

public abstract class GameObject<T, V> implements IGameObject {

    private String userName;
    private T hashedPassword;
    private V specialPoints;
    private int level;

    protected GameObject(String username, T hashedPassword, V specialPoints, int level) {
        this.setUserName(username);
        this.setHashedPassword(hashedPassword);
        this.setSpecialPoints(specialPoints);
        this.setLevel(level);
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setHashedPassword(T hashedPassword){
        this.hashedPassword = hashedPassword;
    }

    private void setSpecialPoints(V specialPoints){
        this.specialPoints = specialPoints;
    }

    private void setLevel(int level) {
        this.level = level;
    }



    @Override
    public String toString() {
        String username = this.userName;
        String password = String.valueOf(this.hashedPassword);
        String characterType = this.getClass().getSimpleName();
        //V totalPoints = this.specialPoints * this.level;

        String firstLine = String.format("%s | %s->%s",
                username, password, characterType);
        return firstLine;
    }
}
