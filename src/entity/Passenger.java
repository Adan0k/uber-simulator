package entity;

import map.Position;

public class Passenger extends NotFixed{
    String name;
    Position destination;
    boolean inDestination;

    public Passenger(String name,Position position,String symbol, Position destination) {
        super(symbol,position);
        this.destination = destination;
        colision = false;
    }

    public Position getDestination() {
        return destination;
    }

    public void setDestination(Position destination) {
        this.destination = destination;
    }

    public boolean isInDestination() {
        return inDestination;
    }

    public void setInDestination(boolean inDestination) {
        this.inDestination = inDestination;
    }
}
