package entity;

import map.Position;

public abstract class NotFixed extends Entity{
    Position position;
    public NotFixed(String symbol,Position position) {
        super(symbol);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
