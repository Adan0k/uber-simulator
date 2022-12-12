package entity;

import map.Position;

public class Car extends Entity {
    Passenger passenger;

    public Car(Position position, String simbol) {
        super(position, simbol);
    }
}
