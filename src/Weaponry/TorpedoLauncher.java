package Weaponry;

import Pilots.TiePilot;

public class TorpedoLauncher {
    private String ModelNumber;
    private int MaxFiringRange;
    private int TorpedoCapacity;
    private int CurrentTorpedoCount;

    public int getCurrentTorpedoCount() {
        return CurrentTorpedoCount;
    }

    public void setCurrentTorpedoCount(int CurrentTorpedoCount) {
        this.CurrentTorpedoCount = CurrentTorpedoCount;
    }

    // output of object information
    public void torpedoInfo() {
        System.out.println("[" + TiePilot.sep + "]");
        System.out.println("Cannon Model: " + ModelNumber);
        System.out.println("Max Fire Range: " + MaxFiringRange);
        System.out.println("Torpedo Cap: " + TorpedoCapacity);
        System.out.println("Current Torpedo Count: " + this.getCurrentTorpedoCount());
        System.out.println("[" + TiePilot.sep + "]");
    }
    
    public TorpedoLauncher(String ModelNumber, int CurrentTorpedoCount) {
        this.ModelNumber = ModelNumber;
        this.MaxFiringRange = 3000;
        this.TorpedoCapacity = 10;
        // checking entered count value against the capacity
        if(CurrentTorpedoCount > this.TorpedoCapacity) {
            this.CurrentTorpedoCount = this.TorpedoCapacity;
        } else if(CurrentTorpedoCount < this.TorpedoCapacity && CurrentTorpedoCount >= 0){
            this.CurrentTorpedoCount = CurrentTorpedoCount;
        } else {
            this.CurrentTorpedoCount = 0;
        }
    }
    
    public TorpedoLauncher() {
        
    }
    
    // another console print to verify execution
    public void LaunchTorpedo() {
        if(this.CurrentTorpedoCount > 0) {
            System.out.println(this.ModelNumber + " is firing off a torpedo!");
            this.CurrentTorpedoCount -= 1;
        } else {
            System.out.println("Torpedoes Expended");
        }
    }
    
}
