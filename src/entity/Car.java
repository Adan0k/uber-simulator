package entity;

import map.Position;

public class Car extends NotFixed implements Movable {
    Passenger passenger;

    public Car(Position position, String symbol) {
        super(symbol,position);
    }
    @Override
    public void move(int row, int column) {
      position.setRow(row);
      position.setColunm(column);
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
