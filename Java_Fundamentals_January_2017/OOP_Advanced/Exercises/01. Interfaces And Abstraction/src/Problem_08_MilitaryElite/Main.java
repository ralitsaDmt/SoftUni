package Problem_08_MilitaryElite;

import Problem_08_MilitaryElite.models.Mission;
import Problem_08_MilitaryElite.models.Repair;
import Problem_08_MilitaryElite.models.Soldiers.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<Soldier> soldiers = new LinkedList<>();
        Map<Integer, Private> privates = new HashMap<>();

        while (true) {
            String input = reader.readLine();
            if ("End".equals(input)) {
                break;
            }

            String[] soldierData = input.split("\\s+");

            String position = soldierData[0];
            int id = Integer.parseInt(soldierData[1]);
            String firstName = soldierData[2];
            String lastName = soldierData[3];

            switch (position) {
                case "Private":
                    double salary = Double.parseDouble(soldierData[4]);
                    Private aprivite = new Private(id, firstName, lastName, salary);
                    privates.put(id, aprivite);
                    soldiers.add(aprivite);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(soldierData[4]);
                    LeutenantGeneral soldier = new LeutenantGeneral(id, firstName, lastName, salary);
                    for (int i = 5; i < soldierData.length; i++) {
                        int privateId = Integer.parseInt(soldierData[i]);
                        Private privateToAdd = privates.get(privateId);
                        soldier.addPrivate(privateToAdd);
                    }
                    soldiers.add(soldier);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(soldierData[4]);
                    String corps = soldierData[5];
                    Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);
                    for (int i = 6; i < soldierData.length; i+=2) {
                        String partName = soldierData[i];
                        int hoursWorked = Integer.parseInt(soldierData[i + 1]);
                        try{
                            Repair repair = new Repair(partName, hoursWorked);
                            engineer.addRepair(repair);
                        } catch (IllegalArgumentException ex){
                            continue;
                        }
                    }
                    soldiers.add(engineer);
                    break;
                case "Commando":
                    salary = Double.parseDouble(soldierData[4]);
                    corps = soldierData[5];
                    Commando commando = new Commando(id, firstName, lastName, salary, corps);
                    for (int i = 6; i < soldierData.length; i += 2) {
                        String missionName = soldierData[i];
                        String missionState = soldierData[i + 1];

                        try{
                            Mission mission = new Mission(missionName, missionState);
                            commando.addMission(mission);
                        } catch (IllegalArgumentException ex){
                            continue;
                        }
                    }
                    soldiers.add(commando);
                    break;
                case "Spy":
                    int codeNumber = Integer.parseInt(soldierData[4]);
                    Spy spy = new Spy(id, firstName, lastName, codeNumber);
                    soldiers.add(spy);
                    break;
            }

        }

        for (Soldier soldier : soldiers) {
            System.out.println(soldier);
        }
    }
}
