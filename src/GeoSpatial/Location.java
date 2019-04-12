package GeoSpatial;

import java.util.Arrays;

public class Location {
    private int X;
    private int Y;
    private int Z;

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getZ() {
        return Z;
    }

    public void setZ(int Z) {
        this.Z = Z;
    }
    
    // differentiate purpose
    public void getLocation(int func) {
        int[] posits = {X, Y, Z};
        
        switch(func) {
            case 0: 
                System.out.println("Location [X, Y, Z]: " + Arrays.toString(posits));
                break;
            case 1:
                System.out.println("Target Location [X, Y, Z]: " + Arrays.toString(posits));
                break;
            default:
                System.out.println("Location [X, Y, Z]: " + Arrays.toString(posits));
                break;
        }
        
        
    }

    public Location(int X, int Y, int Z) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    public Location() {
        
    }
}
