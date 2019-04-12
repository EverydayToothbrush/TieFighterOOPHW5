package FighterBehavior;

import GeoSpatial.Location;

public interface Maneuver {
    void SearchForTarget();
    double DetermineTargetRange(Location L);
}
