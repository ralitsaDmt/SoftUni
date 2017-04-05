package FootballTeamGenerator;

public class Player {
    private String name;
    private Stat stat;

    public Player(String name, Stat stat){
        setName(name);
        this.stat = stat;
    }

    private void setName(String name){
        if (name.isEmpty() || name.trim().length() == 0 || name.equals("")){
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_NAME);
        }

        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public double getSkillLevel(){
        return this.stat.getOveralSkill();
    }
}


