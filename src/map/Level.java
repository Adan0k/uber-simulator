package map;

import entity.*;
import in_out.Inputs;
import in_out.Prints;

import javax.swing.*;
import java.awt.*;
import java.io.Console;
import java.util.Arrays;
import java.util.Collections;

public enum Level {
    level1(new Passenger("Leo",new Position(0,0),"\uD83D\uDD7A",new Position(5,5)),new Car(new Position(5,5),"\uD83D\uDE97"));
private Entity[][] map;
private Car car;
private static Empty empty = new Empty("  ");
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

        for (int i = 0; i < level1Map.length; i++){
            for (int j = 0; j < level1Map[i].length; j++){
                if (level1Map[i][j] == null){
                    level1Map[i][j] = empty;
                }
            }
        }


        level1.map = level1Map;
}
    public void move(){
        String direction = Inputs.inputDirection();
        while (verifyDirection(direction)){
            direction = Inputs.inputDirection();
        }
        if (direction.equals("S")){
            pickPassenger("S");
            map[car.getPosition().getRow() + 1][car.getPosition().getColunm()] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = empty;
            car.move(car.getPosition().getRow() + 1,car.getPosition().getColunm());

        }
        if (direction.equals("A")){
            pickPassenger("A");
            map[car.getPosition().getRow()][car.getPosition().getColunm() -1] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = empty;
            car.move(car.getPosition().getRow(),car.getPosition().getColunm() - 1);
        }
        if (direction.equals("W")){
            pickPassenger("W");
            map[car.getPosition().getRow() - 1][car.getPosition().getColunm()] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = empty;
            car.move(car.getPosition().getRow() - 1,car.getPosition().getColunm());
        }
        if (direction.equals("D")){
            pickPassenger("D");
            map[car.getPosition().getRow()][car.getPosition().getColunm() + 1] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = empty;
            car.move(car.getPosition().getRow(),car.getPosition().getColunm() + 1);
        }
        win();
    }
    public boolean isEmpty(int row, int column){
        if (map[row][column] == null){
            return true;
        }
        return false;
    }
    public boolean verifyDirection(String direction){
        if (direction.equals("S") && (car.getPosition().getRow() + 1 >= map.length || map[car.getPosition().getRow() + 1][car.getPosition().getColunm()].isColision())){
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("A") && (car.getPosition().getColunm() - 1 < 0 || map[car.getPosition().getRow()][car.getPosition().getColunm() - 1].isColision())){
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("W") && (car.getPosition().getRow() - 1 < 0 || map[car.getPosition().getRow() - 1][car.getPosition().getColunm()].isColision())){
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("D") && (car.getPosition().getColunm() + 1 >= map.length || map[car.getPosition().getRow()][car.getPosition().getColunm() + 1].isColision())){
            System.out.println("you cant go");
            return true;
        }
        return false;
    }
    private void pickPassenger(String direction){
        if (direction.equals("W") && map[car.getPosition().getRow() - 1][car.getPosition().getColunm()] == passenger){
            car.setPassenger(passenger);
            map[passenger.getDestination().getRow()][passenger.getDestination().getColunm()] = new Empty("\uD83D\uDCCD");
        }
        if (direction.equals("A") && map[car.getPosition().getRow()][car.getPosition().getColunm() - 1] == passenger){
            car.setPassenger(passenger);
            map[passenger.getDestination().getRow()][passenger.getDestination().getColunm()] = new Empty("\uD83D\uDCCD");
        }
        if (direction.equals("S") && map[car.getPosition().getRow() + 1][car.getPosition().getColunm()] == passenger){
            car.setPassenger(passenger);
            map[passenger.getDestination().getRow()][passenger.getDestination().getColunm()] = new Empty("\uD83D\uDCCD");
        }
        if (direction.equals("D") && map[car.getPosition().getRow()][car.getPosition().getColunm() + 1] == passenger){
            car.setPassenger(passenger);
            map[passenger.getDestination().getRow()][passenger.getDestination().getColunm()] = new Empty("\uD83D\uDCCD");
        }
    }
    public void win(){
        if (car.getPosition().getColunm() == passenger.getDestination().getColunm() && car.getPosition().getRow() == passenger.getDestination().getRow()){
            passenger.setInDestination(true);
        }

    }

    public void start(){
        Prints.printGrid(map);
        do {
            move();
            Prints.printGrid(map);
        }while (!passenger.isInDestination());
    }
}
