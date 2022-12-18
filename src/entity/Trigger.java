package entity;

import map.Position;

public class Trigger extends Entity{
    private Position position;
    private Position actionPosition;
    private Position action2Position;
    private boolean condition;

    public Trigger(String symbol, Position position, Position actionPosition, Position action2Position,boolean condition) {
        super(symbol);
        this.position = position;
        this.actionPosition = actionPosition;
        this.action2Position = action2Position;
        this.condition = condition;
        colision = false;
    }

    public Position getPosition() {
        return position;
    }

    public Position getActionPosition() {
        return actionPosition;
    }

    public Position getAction2Position() {
        return action2Position;
    }

    public void setAction2Position(Position action2Position) {
        this.action2Position = action2Position;
    }

    public boolean getCondition() {
        return condition;
    }
}
