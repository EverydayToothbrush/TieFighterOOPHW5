package mainHW5;

import ImperialFighter.*;
import GeoSpatial.*;
import Pilots.*;
import Weaponry.*;
import java.util.Random;

public class MainHW5 {
    // set a random target to test against
    // all values within 20
    public static Location targetGen() {
        Random ran = new Random();
        Location someTarget = new Location(ran.nextInt(20), ran.nextInt(20), ran.nextInt(20));
        someTarget.getLocation(1);
        return someTarget;
    }
    
    public static void main(String[] args) {
        // creating pilots
        TiePilot TP_1 = new TiePilot("DSTFP-1", "LT", "Veteran");
        TiePilot TP_2 = new TiePilot("DSTFP-2", "LT", "Veteran");
        TiePilot TP_3 = new TiePilot("DSTFP-3", "CAPT", "Veteran");
        
        // creating cannons
        LaserCannon LC_1 = new LaserCannon("LS1");
        LaserCannon LC_2 = new LaserCannon("LS10");
        LaserCannon LC_3 = new LaserCannon("LS11");
        LaserCannon LC_4 = new LaserCannon("LS12");
        LaserCannon LC_5 = new LaserCannon("LS20");
        LaserCannon LC_6 = new LaserCannon("LS21");
        
        // creating torpedo
        TorpedoLauncher Torp_1 = new TorpedoLauncher("TL01", 0);
        
        // setting ammunition for lasers
        LC_1.setCurrentAmmoCount(475);
        LC_2.setCurrentAmmoCount(450);
        LC_3.setCurrentAmmoCount(450);
        LC_4.setCurrentAmmoCount(450);
        LC_5.setCurrentAmmoCount(450);
        LC_6.setCurrentAmmoCount(450);
        
        // creating tiefighters and equipping them with created components
        TieFighter_S TS_1 = new TieFighter_S("TFS-001");
        TS_1.equipShip(TP_1, LC_1);
        TieFighter_I TI_1 = new TieFighter_I("TFI-001");
        TI_1.equipShip(TP_2, LC_2, LC_3, LC_4);
        TieFighter_H TH_1 = new TieFighter_H("TFH-001");
        TH_1.equipShip(TP_3, LC_5, LC_6, Torp_1);
        
        // loaded the 6 bombs here
        TH_1.loadBomb(6);
        
        // testing and output of everything I could think of
        TS_1.StandardTest("Enemy_1", targetGen());
        TI_1.InterceptorTest("Enemy_2", targetGen());
        TH_1.HeavyTest("Enemy_3", targetGen());    
       
    }
    
}
