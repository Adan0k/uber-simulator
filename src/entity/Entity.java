package entity;

public abstract class Entity {
    protected String symbol;
    protected boolean colision;

    public Entity(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isColision() {
        return colision;
    }
}