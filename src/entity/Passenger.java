package entity;

import map.Position;

public class Passenger extends NotFixed{
    String name;
    Position destination;
    boolean inDestination;

    public Passenger(Position position, String symbol) {
        super(symbol,position);
        colision = false;
    }
}
