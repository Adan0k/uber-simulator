package entity;

import map.Position;

public abstract class Entity {
    protected Position position;
    protected String simbol;

    public Entity(Position position, String simbol) {
        this.position = position;
        this.simbol = simbol;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }
}
