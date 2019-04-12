package Pilots;


public class TiePilot {
    private String IDNumber;
    private String Rank;
    private String PilotRating;
    public static String sep = "-----------------------------------";

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }

    public String getPilotRating() {
        return PilotRating;
    }

    public void setPilotRating(String PilotRating) {
        this.PilotRating = PilotRating;
    }
    
    public TiePilot(String IDNumber, String Rank, String PilotRating) {
        this.IDNumber = IDNumber;
        this.Rank = Rank;
        this.PilotRating = PilotRating;
    }
    
    public TiePilot() {
        
    }
    
    public void displaysInfo() {
        System.out.println(sep);
        System.out.println("Tie Fighter Pilot: " + this.getIDNumber());
        System.out.println("Rank: " + this.getRank());
        System.out.println("Pilot Rating: " + this.getPilotRating());
        System.out.println(sep);
    }
}
