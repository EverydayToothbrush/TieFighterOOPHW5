package ImperialFighter;

import GeoSpatial.Location;
import Pilots.TiePilot;
import Weaponry.LaserCannon;

public class TieFighter_S extends TieFighter {
    
    // As the Parent class variables were set to private
    // (And assuming we didn't want to repeatedly redeclare the same variables)
    // I could have either set the Parent variables to package-private
    // or in this case, I had to use the Setters
    // However, netbeans provides a warning saying "Overridable method call in constructor"
    // But I don't know any other workaround that will be consistent with assignment instructions
    public TieFighter_S(String FighterID) {
        this.setFighterID(FighterID);
        this.setManufacturer("Sienar Fleet Systems");
        this.setModel("Tie Standard");
        this.setFighterClass("Superiority");
        this.setLength(6.3);
        this.setWidth(6.4);
        this.setHeight(7.5);
        this.setFuelCapacity(200);
        this.setMaxSpeed(1200);
        this.setCrew(this.getCrew());
        this.setArmament(this.getArmament());
        this.setCurrentPosition(this.getCurrentPosition());
        this.setCurrentSpeed(0);
    }
    
    // Created separate method to set certain components
    public void equipShip(TiePilot pilot, LaserCannon cannon) {
        this.setCrew(pilot);
        this.setArmament(cannon);
    }
    
    // Outputing results for all methods and components
    public void StandardTest(String targetcannon, Location range) {
        this.FireCannons(targetcannon);
        this.SearchForTarget();
        this.BarrelRoll();
        this.Loop();
        this.Chase();
        System.out.println("Target Range: " + this.DetermineTargetRange(range));
        this.getCurrentPosition().getLocation(0);
        System.out.println(largesep);
        System.out.println("Manufacturer: " + this.getManufacturer());
        System.out.println("Fighter ID: " + this.getFighterID());
        System.out.println("Model: " + this.getModel());
        System.out.println("Fighter Class: " + this.getFighterClass());
        System.out.println("Length: " + this.getLength());
        System.out.println("Width: " + this.getWidth());
        System.out.println("Height: " + this.getHeight());
        System.out.println("Fuel Cap: " + this.getFuelCapacity());
        System.out.println("Max Speed: " + this.getMaxSpeed());
        this.getCrew().displaysInfo();
        this.getArmament().laserInfo();
        System.out.println("Current Speed: " + this.getCurrentSpeed());
        System.out.println(largesep);
    }

    @Override
    public void FireCannons(String target) {
        this.getArmament().Fire();
        System.out.println(this.getFighterID() + " is a Standard Tie Fighter firing at " + target);
    }

    @Override
    public void SearchForTarget() {
        System.out.println(this.getFighterID() + " is a Standard Tie Fighter currently searching for a target");
    }

    @Override
    public double DetermineTargetRange(Location L) {
        double x_val = Math.pow(this.getCurrentPosition().getX() - L.getX(), 2);
        double y_val = Math.pow(this.getCurrentPosition().getY() - L.getY(), 2);
        double z_val = Math.pow(this.getCurrentPosition().getZ() - L.getZ(), 2);
        double dist = Math.sqrt(x_val + y_val + z_val);
        return dist;
    }

    @Override
    public void BarrelRoll() {
        this.getCurrentPosition().setX(this.getCurrentPosition().getX() + 1);
        this.getCurrentPosition().setZ(this.getCurrentPosition().getZ() - 2);
        this.setCurrentSpeed(this.getCurrentSpeed() - 10);
        System.out.println(this.getFighterID() + " is barrel rolling");
    }

    @Override
    public void Loop() {
        this.getCurrentPosition().setX(this.getCurrentPosition().getX() + 1);
        this.getCurrentPosition().setZ(this.getCurrentPosition().getZ() - 4);
        this.setCurrentSpeed(this.getCurrentSpeed() - 20);
        System.out.println(this.getFighterID() + " is looping");
    }

    @Override
    public void Chase() {
        this.MoveForward();
        this.setCurrentSpeed(this.getCurrentSpeed() + 40);
        System.out.println(this.getFighterID() + " is in pursuit");
    }
    
}
