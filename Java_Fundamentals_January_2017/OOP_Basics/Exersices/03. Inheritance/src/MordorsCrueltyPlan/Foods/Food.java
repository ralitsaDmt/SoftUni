package MordorsCrueltyPlan.Foods;

public abstract class Food {
    private int happinessPoints;

    public int getHappinessPoints(){
        return happinessPoints;
    }

    public void setHappinessPoints(int happinessPoints){
        this.happinessPoints = happinessPoints;
    }

    public Food(int happinessPoints) {
        this.setHappinessPoints(happinessPoints);
    }

}
