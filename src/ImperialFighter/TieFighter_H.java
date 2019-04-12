package ImperialFighter;

import FighterBehavior.Bombing;
import GeoSpatial.Location;
import Pilots.TiePilot;
import Weaponry.LaserCannon;
import Weaponry.ProtonBomb;
import Weaponry.TorpedoLauncher;
import java.util.ArrayList;


public class TieFighter_H extends TieFighter implements Bombing{
    private LaserCannon Armament_2;
    private TorpedoLauncher HeavyWeapon = new TorpedoLauncher();
    // I used and ArrayList of ProtonBomb objects instead of a primitive array
    // I wanted to be able to load a certain amount of bombs
    // An alternate solution using a primitive array would have most likely been to loop through and set/check values at each index
    private ArrayList<ProtonBomb> Bombay = new ArrayList<ProtonBomb>(8);
    

    // As the Parent class variables were set to private
    // (And assuming we didn't want to repeatedly redeclare the same variables)
    // I could have either set the Parent variables to package-private
    // or in this case, I had to use the Setters
    // However, netbeans provides a warning saying "Overridable method call in constructor"
    // But I don't know any other workaround that will be consistent with assignment instructions
    public TieFighter_H(String FighterID) {
        this.setFighterID(FighterID);
        this.setManufacturer("Sienar Fleet Systems");
        this.setModel("Tie Heavy Fighter");
        this.setFighterClass("Close Suppport");
        this.setLength(7.8);
        this.setWidth(8.6);
        this.setHeight(5.0);
        this.setFuelCapacity(375);
        this.setMaxSpeed(850);
        this.setCrew(this.getCrew());
        this.setArmament(this.getArmament());
        this.Armament_2 = Armament_2;
        this.HeavyWeapon = HeavyWeapon;
        this.Bombay = Bombay;
        this.setCurrentPosition(this.getCurrentPosition());
        this.setCurrentSpeed(0);
    }
    
    // Created separate method to set certain components
    public void equipShip(TiePilot pilot, LaserCannon cannon1, LaserCannon cannon2, TorpedoLauncher torp) {
        this.setCrew(pilot);
        this.setArmament(cannon1);
        this.Armament_2 = cannon2;
        this.HeavyWeapon = torp;
    }
    
    // Adding to the arraylist of bombs
    // defaaulting the ModelNumber to "P" followed by the index number
    public void loadBomb(int amount) {
        if(this.Bombay.size() < 8) {
            for(int i = 0; i < amount; i++) {
                 this.Bombay.add(new ProtonBomb("P" + (i + 1), false));
            }  
        } else {
            System.out.println("Cannot load any more ProtonBombs");
        } 
    }
    
    // Outputing results for all methods and components
    public void HeavyTest(String targetcannon, Location range) {
        this.FireCannons(targetcannon);
        this.FireHeavyWeapon(targetcannon);
        this.DropBomb(targetcannon);
        this.SearchForTarget();
        this.BarrelRoll();
        this.Loop();
        this.Chase();
        this.AquireTarget(targetcannon);
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
        this.Armament_2.laserInfo();
        this.HeavyWeapon.torpedoInfo();
        System.out.println("Current Bomb Count: " + this.Bombay.size());
        System.out.println("Current Speed: " + this.getCurrentSpeed());
        System.out.println(largesep);
    }
    
    public void FireHeavyWeapon(String target) {
        if(this.HeavyWeapon.getCurrentTorpedoCount() > 0) {
           this.HeavyWeapon.LaunchTorpedo();
           System.out.println(this.getFighterID() + " is launching a torpedo at " + target);
        } else {
           this.HeavyWeapon.LaunchTorpedo();
        }
        
    }
    
    // simply removing the object from the ArrayList after dropping
    // in this case it seems the boolean value of the bomb itself is not used
    public void DropBomb(String target) {
        if(this.Bombay.size() > 0) {
                this.Bombay.get(0).Release();
                this.Bombay.remove(0);
                System.out.println(this.getFighterID() + " is dropping a proton bomb on " + target);
        } else {
            System.out.println("There are no more bombs");
        }
    }

    @Override
    public void FireCannons(String target) {
        this.getArmament().Fire();
        this.Armament_2.Fire();
        System.out.println(this.getFighterID() + " is a Heavy Tie Fighter firing Laser Cannons at " + target);
    }

    @Override
    public void SearchForTarget() {
        System.out.println(this.getFighterID() + " is a Heavy Tie Fighter currently searching for a target");
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
        this.getCurrentPosition().setZ(this.getCurrentPosition().getZ() - 1);
        this.setCurrentSpeed(this.getCurrentSpeed() - 20);
        System.out.println(this.getFighterID() + " is barrel rolling");
    }

    @Override
    public void Loop() {
        this.getCurrentPosition().setX(this.getCurrentPosition().getX() + 1);
        this.getCurrentPosition().setZ(this.getCurrentPosition().getZ() - 8);
        this.setCurrentSpeed(this.getCurrentSpeed() - 25);
        System.out.println(this.getFighterID() + " is looping");
    }

    @Override
    public void Chase() {
        this.MoveForward();
        this.setCurrentSpeed(this.getCurrentSpeed() + 5);
        System.out.println(this.getFighterID() + " is in pursuit");
    }

    @Override
    public void AquireTarget(String target) {
        System.out.println(this.getFighterID() + " is a Heavy Tie Fighter aquiring a target");
    }
    
}
