package entity;

import map.Position;

public class Car extends NotFixed implements Movable {
    Passenger passenger;

    public Car(Position position, String symbol) {
        super(symbol,position);
        this.colision = true;
    }
    @Override
    public void move(int row, int column) {
      position.setRow(row);
      position.setColunm(column);
    }
}
