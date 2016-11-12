package org.rebaze.halite.support;
import java.util.Random;

public enum Direction {
    STILL, NORTH, EAST, SOUTH, WEST;

    public static final Direction[] DIRECTIONS = new Direction[]{STILL, NORTH, EAST, SOUTH, WEST};
    public static final Direction[] CARDINALS = new Direction[]{NORTH, EAST, SOUTH, WEST};

    public static Direction fromInteger(int value) {
        if(value == 0) {
            return STILL;
        }
        if(value == 1) {
            return NORTH;
        }
        if(value == 2) {
            return EAST;
        }
        if(value == 3) {
            return SOUTH;
        }
        if(value == 4) {
            return WEST;
        }
        throw new IllegalArgumentException("Not a valid direction: " + value);
    }


    public static int fromDirection(Direction direction) {
        if(direction == STILL) {
            return 0;
        }
        if(direction == NORTH) {
            return 1;
        }
        if(direction == EAST) {
            return 2;
        }
        if(direction == SOUTH) {
            return 3;
        }
        if(direction == WEST) {
            return 4;
        }
        throw new IllegalArgumentException("Not a valid direction: " + direction);
    }

    public static Direction randomDirection() {
        return fromInteger(new Random().nextInt(5));
    }
}
