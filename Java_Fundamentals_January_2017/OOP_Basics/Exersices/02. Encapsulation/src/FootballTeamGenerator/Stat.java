package FootballTeamGenerator;

class Stat {
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Stat(int endurance, int sprint, int dribble, int passing, int shooting){
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        serPassing(passing);
        setShooting(shooting);
    }

    private void setEndurance(int endurance){
        checkRange(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint){
        checkRange(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble){
        checkRange(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void serPassing(int passing){
        checkRange(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting){
        checkRange(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void checkRange(int value, String statName){
        if (value < 0 || value > 100){
            throw new IllegalArgumentException(String.format(ExceptionMessages.STAT_OUT_OF_RANGE, statName));
        }
    }

    public double getOveralSkill(){
        double overalSkill = (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
        return overalSkill;
    }
}

