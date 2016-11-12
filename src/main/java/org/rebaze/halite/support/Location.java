package org.rebaze.halite.support;

import java.util.Objects;

public class Location {
    @Override public boolean equals( Object o )
    {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        Location location = ( Location ) o;
        return x == location.x &&
            y == location.y;
    }

    @Override public int hashCode()
    {
        return Objects.hash( x, y );
    }

    public final int x;
    public final int y;

    public Location(int x_, int y_) {
        x = x_;
        y = y_;
    }
    public Location(Location l) {
        x = l.x;
        y = l.y;
    }
}
