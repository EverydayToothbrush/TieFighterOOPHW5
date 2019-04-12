package ImperialFighter;

import FighterBehavior.Maneuver;
import FighterBehavior.Scanning;
import GeoSpatial.Location;
import Pilots.TiePilot;
import Weaponry.LaserCannon;

public abstract class TieFighter implements Maneuver,Scanning {
    public static String largesep = "==============================";
    private String Manufacturer;
    private String FighterID;
    private String Model;
    private String FighterClass;
    private double Length;
    private double Width;
    private double Height;
    private int FuelCapacity;
    private int MaxSpeed;
    // Instantiated objects here, do not know whether I should have done so within constructor
    // This is consistent along all Child classes
    private TiePilot Crew = new TiePilot();
    private LaserCannon Armament = new LaserCannon();
    private Location CurrentPosition = new Location();
    private int CurrentSpeed;

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getFighterID() {
        return FighterID;
    }

    public void setFighterID(String FighterID) {
        this.FighterID = FighterID;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getFighterClass() {
        return FighterClass;
    }

    public void setFighterClass(String FighterClass) {
        this.FighterClass = FighterClass;
    }

    public double getLength() {
        return Length;
    }

    public void setLength(double Length) {
        this.Length = Length;
    }

    public double getWidth() {
        return Width;
    }

    public void setWidth(double Width) {
        this.Width = Width;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double Height) {
        this.Height = Height;
    }

    public int getFuelCapacity() {
        return FuelCapacity;
    }

    public void setFuelCapacity(int FuelCapacity) {
        this.FuelCapacity = FuelCapacity;
    }

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    public void setMaxSpeed(int MaxSpeed) {
        this.MaxSpeed = MaxSpeed;
    }

    public TiePilot getCrew() {
        return Crew;
    }

    public void setCrew(TiePilot Crew) {
        this.Crew = Crew;
    }

    public LaserCannon getArmament() {
        return Armament;
    }

    public void setArmament(LaserCannon Armament) {
        this.Armament = Armament;
    }

    public Location getCurrentPosition() {
        return CurrentPosition;
    }

    public void setCurrentPosition(Location CurrentPosition) {
        this.CurrentPosition = CurrentPosition;
    }

    public int getCurrentSpeed() {
        return CurrentSpeed;
    }
    
    // Tried to make sure the speed could not go over max speed, and also no negative speeds
    public void setCurrentSpeed(int CurrentSpeed) {
        if(this.CurrentSpeed + CurrentSpeed < MaxSpeed && this.CurrentSpeed + CurrentSpeed > 0) {
            this.CurrentSpeed = CurrentSpeed;
        } else if(this.CurrentSpeed + CurrentSpeed <= 0){
            this.CurrentSpeed = 0;
        } else if(this.CurrentSpeed + CurrentSpeed >= MaxSpeed) {
            this.CurrentSpeed = MaxSpeed;
        }
    }   
    
    public TieFighter(String FighterID, String FighterClass, double Length, double Width, double Height, int FuelCapacity, int MaxSpeed) {
        this.FighterID = FighterID;
        this.FighterClass = FighterClass;
        this.Length = Length;
        this.Width = Width;
        this.Height = Height;
        this.FuelCapacity = FuelCapacity;
        this.MaxSpeed = MaxSpeed;
        this.Armament = Armament;
        this.Crew = Crew;
    }
    
    // All child classes required a constructor matching super if there was no default constructor
    // This is contrary to instruction, but I honestly did not know how to work around it
    public TieFighter() {
        
    }
    
    public void MoveLeft() {
        this.CurrentPosition.setX(this.CurrentPosition.getX() - 1); 
    }
    public void MoveRight() {
        this.CurrentPosition.setX(this.CurrentPosition.getX() + 1);
    }
    public void MoveForward() {
        this.CurrentPosition.setY(this.CurrentPosition.getY() + 1);
    }
    public void MoveBackward() {
        this.CurrentPosition.setY(this.CurrentPosition.getY() - 1);
    }
    public void Ascend() {
        this.CurrentPosition.setZ(this.CurrentPosition.getZ() + 1);
    }
    public void Descend() {
        this.CurrentPosition.setZ(this.CurrentPosition.getZ() - 1);
    }
    public boolean Land() {
        this.CurrentPosition.setZ(0);
        return true;
    }
    public boolean Takeoff() {
        this.CurrentPosition.setZ(10);
        return true;
    }
    public abstract void FireCannons(String target);

}
