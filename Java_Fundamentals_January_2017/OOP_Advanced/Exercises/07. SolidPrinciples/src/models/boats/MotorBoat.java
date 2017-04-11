//package models.boats;
//
//import Utility.Constants;
//import Utility.Validator;
//import contracts.Modelable;
//import contracts.Race;
//import models.engines.JetBoatEngine;
//import models.engines.SterndriveBoatEngine;
//
//import java.util.List;
//
//public final class MotorBoat implements Modelable {
//    private String model;
//    private int weight;
//    private int oars;
//    private int sailEfficiency;
//    private int cargoWeight;
//    private List<JetBoatEngine> jetEngines;
//    private List<SterndriveBoatEngine> sterndriveEngines;
//    public Boolean isSailboat;
//
//    public MotorBoat(String model, int weight, int sailEfficiency, int oars, int cargoWeight, List<JetBoatEngine> jetEngines, List<SterndriveBoatEngine> sterndriveEngines, Boolean isSailboat) {
//        this.setSailEfficiency(sailEfficiency);
//        this.cargoWeight = cargoWeight;
//        this.setOars(oars);
//        this.model = model;
//        this.setWeight(weight);
//        this.jetEngines = jetEngines;
//        this.sterndriveEngines = sterndriveEngines;
//        this.isSailboat = isSailboat;
//    }
//
//    @Override
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        Validator.ValidateModelLength(model, Constants.MinBoatModelLength);
//        this.model = model;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        Validator.ValidatePropertyValue(weight, "Weight");
//        this.weight = weight;
//    }
//
//    public int getOars() {
//        return oars;
//    }
//
//    public void setOars(int oars) {
//        Validator.ValidatePropertyValue(oars, "Oars");
//        this.oars = oars;
//    }
//
//    public int getSailEfficiency() {
//        return sailEfficiency;
//    }
//
//    public void setSailEfficiency(int sailEfficiency) {
//        if (sailEfficiency < 1 || sailEfficiency > 100) {
//            throw new IllegalArgumentException(Constants.IncorrectSailEfficiencyMessage);
//        }
//        this.sailEfficiency = sailEfficiency;
//    }
//
//    public int getCargoWeight() {
//        return cargoWeight;
//    }
//
//    public void setCargoWeight(int cargoWeight) {
//        Validator.ValidatePropertyValue(cargoWeight, "Cargo Weight");
//        this.cargoWeight = cargoWeight;
//    }
//
//    public List<JetBoatEngine> getJetEngines() {
//        return jetEngines;
//    }
//
//    public void setJetEngines(List<JetBoatEngine> jetEngines) {
//        this.jetEngines = jetEngines;
//    }
//
//    public List<SterndriveBoatEngine> getSterndriveEngines() {
//        return sterndriveEngines;
//    }
//
//    public void setSterndriveEngines(List<SterndriveBoatEngine> sterndriveEngines) {
//        this.sterndriveEngines = sterndriveEngines;
//    }
//
//    public double CalculateRaceSpeed(Race race) {
//        //if (this.getJetEngines().size() + this.getSterndriveEngines().size() == 2) {
//        //    var speed = this.JetEngines.Sum(x = > x.Output)+this.SterndriveEngines.Sum(x = > x.Output)
//        //    -this.Weight + (race.OceanCurrentSpeed / 5d);
//        //    return speed;
//        //} else if (this.getJetEngines().size() + this.getSterndriveEngines().size() == 1) {
//        //    var speed = this.JetEngines.Sum(x = > x.Output)+this.SterndriveEngines.Sum(x = > x.Output)
//        //    -this.Weight - this.CargoWeight + (race.OceanCurrentSpeed / 2d);
//        //    return speed;
//        //} else if (isSailboat) {
//        //    var speed = (race.WindSpeed * (this.SailEfficiency / 100d)) - this.Weight + (race.OceanCurrentSpeed / 2d);
//        //    return speed;
//        //} else {
//        //    var speed = (this.Oars * 100) - this.Weight + race.OceanCurrentSpeed;
//        //    return speed;
//        //}
//        return 0;
//    }
//}
//
//
