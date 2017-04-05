package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

    private static Map<String, Team> teams;

    public static void main(String[] args) throws Exception {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        teams = new HashMap<>();

        while (true){
            String line = in.readLine();
            if (line.equals("END")){
                break;
            }

            String[] data = line.split(";");

            String command = data[0];

            try{
                switch (command){
                    case "Team": createTeam(data); break;
                    case "Add": addPlayer(data); break;
                    case "Remove": removePlayer(data); break;
                    case "Rating": printTeamRating(data); break;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printTeamRating(String[] data) throws Exception {

        String teamName = "";

        if (data.length != 1){
            teamName = data[1];
        }

        if (!teams.containsKey(teamName)){
            throw new Exception(String.format(ExceptionMessages.MISSING_TEAM, teamName));
        }

        double rating = teams.get(teamName).averageSkillLevel();

        System.out.printf("%s - %s\n", teamName, Math.round(rating));
    }

    private static void removePlayer(String[] data) throws Exception {
        String teamName= data[1];
        String playerName = data[2];

        if (!teams.containsKey(teamName)){
            throw new Exception(String.format(ExceptionMessages.MISSING_TEAM, teamName));
        }

        try {
            teams.get(teamName).removePlayer(playerName);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    private static void addPlayer(String[] data) throws Exception {

        String teamName = data[1];

        String playerName = data[2];
        int endurance = Integer.parseInt(data[3]);
        int sprint = Integer.parseInt(data[4]);
        int dribble = Integer.parseInt(data[5]);
        int passing = Integer.parseInt(data[6]);
        int shooting = Integer.parseInt(data[7]);

        Player player;
        Stat stat;

        try{
            stat = new Stat(endurance, sprint, dribble, passing, shooting);
            player = new Player(playerName, stat);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        if (!teams.containsKey(teamName)){
            throw new Exception(String.format(ExceptionMessages.MISSING_TEAM, teamName));
        }

        teams.get(teamName).addPlayer(player);
    }

    private static void createTeam(String[] data) {

        String teamName = "";

        if (data.length > 1) {
            teamName = data[1];
        }

        if (!teams.containsKey(teamName)){
            Team team = new Team(teamName);
            teams.put(teamName, team);
        }
    }
}
