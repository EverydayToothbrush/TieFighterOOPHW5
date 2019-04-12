package Weaponry;

import Pilots.TiePilot;

public class LaserCannon {
    private String ModelNumber;
    private int MaxFiringRange;
    private int AmmunitionCapacity;
    private int CurrentAmmoCount;
    
    public String getModelNumber() {
        return ModelNumber;
    }

    public void setModelNumber(String ModelNumber) {
        this.ModelNumber = ModelNumber;
    }

    public int getMaxFiringRange() {
        return MaxFiringRange;
    }

    public void setMaxFiringRange(int MaxFiringRange) {
        this.MaxFiringRange = MaxFiringRange;
    }

    public int getAmmunitionCapacity() {
        return AmmunitionCapacity;
    }

    public void setAmmunitionCapacity(int AmmunitionCapacity) {
        this.AmmunitionCapacity = AmmunitionCapacity;
    }

    public int getCurrentAmmoCount() {
        return CurrentAmmoCount;
    }

    // Checking ammo cap versus the value imputted
    public void setCurrentAmmoCount(int CurrentAmmoCount) {
        if(CurrentAmmoCount >= 0 && CurrentAmmoCount <= this.AmmunitionCapacity) {
            this.CurrentAmmoCount = CurrentAmmoCount;
        } else {
            System.out.println("The amount of ammunition entered is not possible to load.");
        }
    }
    
    // output of object information
    public void laserInfo() {
        System.out.println("[" + TiePilot.sep + "]");
        System.out.println("Cannon Model: " + ModelNumber);
        System.out.println("Max Fire Range: " + MaxFiringRange);
        System.out.println("Ammo Cap: " + AmmunitionCapacity);
        System.out.println("Current Ammo: " + CurrentAmmoCount);
        System.out.println("[" + TiePilot.sep + "]");
    }
    
    // instructions said to not put ammo count in parameters?
    public LaserCannon(String ModelNumber) {
        this.ModelNumber = ModelNumber;
        this.MaxFiringRange = 1000;
        this.AmmunitionCapacity = 500;
        this.CurrentAmmoCount = CurrentAmmoCount;
    }
    
    public LaserCannon() {
        
    }
    
    // another console print to verify execution
    public void Fire() {
        if(this.CurrentAmmoCount > 0) {
            System.out.println(this.ModelNumber + " is firing off a shot!");
            this.CurrentAmmoCount -= 1;
        } else {
            System.out.println("Ammunition Expended");
        }
    }
    
}
