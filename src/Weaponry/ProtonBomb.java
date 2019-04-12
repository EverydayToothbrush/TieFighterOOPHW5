package Weaponry;

public class ProtonBomb {
    private String ModelNumber;
    private int Yield;
    private boolean Dropped;

    public String getModelNumber() {
        return ModelNumber;
    }

    public void setModelNumber(String ModelNumber) {
        this.ModelNumber = ModelNumber;
    }

    public int getYield() {
        return Yield;
    }

    public void setYield(int Yield) {
        this.Yield = Yield;
    }

    public boolean isDropped() {
        return Dropped;
    }

    public void setDropped(boolean Dropped) {
        this.Dropped = Dropped;
    }

    public ProtonBomb(String ModelNumber, boolean Dropped) {
        this.ModelNumber = ModelNumber;
        this.Yield = 7;
        this.Dropped = Dropped;
    }
    public ProtonBomb() {
        
    }
    
    // another console print to verify execution
    public void Release() {
        if(this.Dropped == false) {
            System.out.println("Dropped " + this.ModelNumber + "!");
            this.Dropped = true;
        } else {
            System.out.println("Bombs Expended");
        }
    }
    
    
}
