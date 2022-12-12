package entity;

import map.Position;

public class Passenger extends Entity{
    String name;
    Position destination;
    boolean inDestination;

    public Passenger(Position position, String simbol) {
        super(position, simbol);
    }
}
