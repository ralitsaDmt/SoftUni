package FootballTeamGenerator;

import java.util.HashMap;
import java.util.Map;

public class Team {
    private String name;
    private Map<String, Player> players;

    public Team(String name){
        setName(name);
        this.players = new HashMap<>();
    }

    private void setName(String name){
        if (name.isEmpty() || name.trim().length() == 0 || name.equals("")){
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_NAME);
        }

        this.name = name;
    }

    public void addPlayer(Player player){
        this.players.put(player.getName(), player);
    }

    public void removePlayer(String playerName){
        if (!this.players.containsKey(playerName)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.MISSING_PLAYER, playerName, this.name));
        }

        this.players.remove(playerName);
    }

    public double averageSkillLevel(){
        double totalSkillLevel = 0;
        for (Player player : this.players.values()) {
            totalSkillLevel += player.getSkillLevel();
        }

        double averageSkillSet = this.players.size() > 0 ? totalSkillLevel / this.players.size() : 0;
        return averageSkillSet;
    }

}
