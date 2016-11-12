package org.rebaze.halite.support;

import org.rebaze.halite.support.Direction;
import org.rebaze.halite.support.Location;

public class Move {
    public Location loc;
    public Direction dir;

    public Move(Location loc_, Direction dir_) {
        loc = loc_;
        dir = dir_;
    }
}
