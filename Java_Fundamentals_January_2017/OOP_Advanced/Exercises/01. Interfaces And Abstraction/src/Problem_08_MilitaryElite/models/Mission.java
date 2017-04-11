package Problem_08_MilitaryElite.models;

import Problem_08_MilitaryElite.contracts.IMission;
import Problem_08_MilitaryElite.enums.MissionStates;

public class Mission implements IMission {

    private String codeName;
    private String state;

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(String state) {

        String stateInProgress = MissionStates.inProgress.toString();
        String stateFinished = MissionStates.Finished.toString();

        if (!state.equals(stateInProgress) && !state.equals(stateFinished)) {
            throw new IllegalArgumentException("Invalid state!");
        }

        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        String finishedState = MissionStates.Finished.toString();
        this.setState(finishedState);
    }

    public Mission(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    @Override
    public String toString() {
        String codeName = this.getCodeName();
        String state = this.getState();

        String output = String.format("Code Name: %s State: %s", codeName, state);
        return output;
    }
}
