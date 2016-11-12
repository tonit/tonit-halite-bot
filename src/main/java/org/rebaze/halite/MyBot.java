package org.rebaze.halite;

import org.rebaze.halite.support.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyBot {
    public static void main(String[] args) throws java.io.IOException {

        InitPackage iPackage = Networking.getInit();

        Networking.sendInit("CircleBot");
        new MyBot().gameLoop(iPackage);
    }

    void gameLoop( InitPackage iPackage )
    {
        Map<Location,Direction> previous = new HashMap<>();
        // we could read the env here:


        while(true) {
            ArrayList<Move> moves = new ArrayList<>();

            GameMap gameMap = Networking.getFrame();
            for( int y = 0; y < gameMap.height; y++) {
                for( int x = 0; x < gameMap.width; x++) {
                    Location location = new Location( x, y );
                    Site site = gameMap.getSite( location );
                    if(site.owner == iPackage.myID) {
                        Direction dir = nextDirection(previous.get(location));
                        previous.put(location,dir);

                        if(site.strength <=5) {
                            dir = Direction.STILL;
                        }
                        moves.add(new Move( location, dir));
                    }
                }
            }
            Networking.sendFrame(moves);
        }
    }

    private static Direction nextDirection( Direction previous )
    {
        if (previous == null) {
            // start with  east.
            previous = Direction.WEST;
        }
        int next = Direction.fromDirection(previous)+1;
        if (next > 4) {
            next = 1;
        }
        //next = 1;
        return Direction.fromInteger( next );
    }
}
