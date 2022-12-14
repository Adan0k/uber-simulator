package map;

import entity.Buildings;
import entity.Car;
import entity.Entity;
import entity.Passenger;
import in_out.Inputs;

import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.util.Arrays;
import java.util.Collections;

public enum Level {
    level1(new Passenger(new Position(0,1),"\uD83D\uDD7A"),new Car(new Position(0,0),"\uD83D\uDE97"));
private Entity[][] map;
private Car car;
private Passenger passenger;

    Level(Passenger passenger, Car car) {
        this.car = car;
        this.passenger = passenger;
    }

    public Entity[][] getMap() {
        return map;
    }


    public static void buildLevel1(){
        Entity level1Map[][] = new Entity[6][6];
        Buildings building = new Buildings("\uD83C\uDFE0");
        level1Map[level1.car.getPosition().getRow()][level1.car.getPosition().getColunm()] = level1.car;
        level1Map[level1.passenger.getPosition().getRow()][level1.passenger.getPosition().getColunm()] = level1.passenger;
        level1Map[1][0] = building;
        level1Map[2][0] = building;
        level1Map[3][0] = building;
        level1Map[4][0] = building;
        level1Map[5][0] = building;

        level1Map[0][2] = building;
        level1Map[1][2] = building;
        level1Map[2][2] = building;
        level1Map[3][2] = building;
        level1Map[4][2] = building;

        level1Map[1][4] = building;
        level1Map[2][4] = building;
        level1Map[3][4] = building;
        level1Map[4][4] = building;
        level1Map[5][4] = building;


        level1.map = level1Map;
}
    public void move(){
        String direction = Inputs.inputDirection();
        while (verifyDirection(direction)){
            direction = Inputs.inputDirection();
        }
        if (direction.equals("S")){
            map[car.getPosition().getRow() + 1][car.getPosition().getColunm()] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = null;
            car.move(car.getPosition().getRow() + 1,car.getPosition().getColunm());

        }
        if (direction.equals("A")){
            map[car.getPosition().getRow()][car.getPosition().getColunm() -1] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = null;
            car.move(car.getPosition().getRow(),car.getPosition().getColunm() - 1);
        }
        if (direction.equals("W")){
            map[car.getPosition().getRow() - 1][car.getPosition().getColunm()] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = null;
            car.move(car.getPosition().getRow() - 1,car.getPosition().getColunm());
        }
        if (direction.equals("D")){
            map[car.getPosition().getRow()][car.getPosition().getColunm() + 1] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = null;
            car.move(car.getPosition().getRow(),car.getPosition().getColunm() + 1);
        }
    }
    public boolean isEmpty(int row, int column){
        if (map[row][column] == null){
            return true;
        }
        return false;
    }
    public boolean verifyDirection(String direction){
        if (direction.equals("S") && car.getPosition().getRow() + 1 > 5){
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("A") && car.getPosition().getColunm() - 1 < 0){
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("W") && car.getPosition().getRow() - 1 < 0){
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("D") && car.getPosition().getColunm() + 1 > 5){
            System.out.println("you cant go");
            return true;
        }
        return false;
    }
}
