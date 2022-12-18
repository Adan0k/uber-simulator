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
    level1(new Passenger("Jose", new Position(0, 0), "\uD83D\uDD7A", new Position(5, 5)), new Car(new Position(5, 5), "\uD83D\uDE97")),
    level2(new Passenger("Ednaldo", new Position(9, 2), "\uD83E\uDDCD\u200D", new Position(0, 9)), new Car(new Position(9, 9), "\uD83D\uDE99"));
    private Entity[][] map;
    private Car car;
    private static Empty empty = new Empty("  ");
    private Passenger passenger;

    private Trigger trigger;

    Level(Passenger passenger, Car car) {
        this.car = car;
        this.passenger = passenger;
    }

    public Entity[][] getMap() {
        return map;
    }


    public static void buildLevel1() {
        level1.map = new Entity[6][6];
        Buildings building = new Buildings("\uD83C\uDFE0");
        level1.map[level1.car.getPosition().getRow()][level1.car.getPosition().getColunm()] = level1.car;
        level1.map[level1.passenger.getPosition().getRow()][level1.passenger.getPosition().getColunm()] = level1.passenger;
        level1.map[1][0] = building;
        level1.map[2][0] = building;
        level1.map[3][0] = building;
        level1.map[4][0] = building;
        level1.map[5][0] = building;

        level1.map[0][2] = building;
        level1.map[1][2] = building;
        level1.map[2][2] = building;
        level1.map[3][2] = building;
        level1.map[4][2] = building;

        level1.map[1][4] = building;
        level1.map[2][4] = building;
        level1.map[3][4] = building;
        level1.map[4][4] = building;
        level1.map[5][4] = building;

        fillEmpty(level1.map);
    }

    private static void fillEmpty(Entity[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == null) {
                    map[i][j] = empty;
                }
            }
        }
    }

    public static void buildLevel2() {
        level2.map = new Entity[10][10];
        Buildings building = new Buildings("\uD83C\uDFEF");

        level2.map[level2.car.getPosition().getRow()][level2.car.getPosition().getColunm()] = level2.car;
        level2.map[level2.passenger.getPosition().getRow()][level2.passenger.getPosition().getColunm()] = level2.passenger;

        level2.trigger = new Trigger("  ", new Position(9, 6), new Position(9, 7),new Position(5,1) ,level2.car.getPassenger() != null);

        level2.map[6][9] = building;
        level2.map[5][9] = building;

        level2.map[8][8] = building;
        level2.map[5][8] = building;
        level2.map[3][8] = building;
        level2.map[2][8] = building;
        level2.map[1][8] = building;
        level2.map[0][8] = building;

        level2.map[0][7] = building;
        level2.map[1][7] = building;

        level2.map[7][7] = building;
        level2.map[8][7] = building;

        level2.map[0][6] = building;
        level2.map[1][6] = building;
        level2.map[3][6] = building;
        level2.map[4][6] = building;
        level2.map[5][6] = building;
        level2.map[6][6] = building;
        level2.map[7][6] = building;

        level2.map[0][5] = building;
        level2.map[1][5] = building;
        level2.map[3][5] = building;
        level2.map[4][5] = building;
        level2.map[5][5] = building;
        level2.map[6][5] = building;
        level2.map[9][5] = building;

        level2.map[0][4] = building;
        level2.map[3][4] = building;
        level2.map[4][4] = building;
        level2.map[5][4] = building;
        level2.map[6][4] = building;
        level2.map[8][4] = building;
        level2.map[9][4] = building;

        level2.map[0][3] = building;
        level2.map[2][3] = building;
        level2.map[3][3] = building;
        level2.map[4][3] = building;
        level2.map[5][3] = building;
        level2.map[6][3] = building;
        level2.map[9][3] = building;

        level2.map[0][2] = building;
        level2.map[5][2] = building;
        level2.map[6][2] = building;
        level2.map[7][2] = building;

        level2.map[0][1] = building;
        level2.map[1][1] = building;
        level2.map[2][1] = building;
        level2.map[3][1] = building;
        level2.map[5][1] = building;
        level2.map[9][1] = building;

        level2.map[5][0] = building;
        level2.map[6][0] = building;
        level2.map[7][0] = building;
        level2.map[8][0] = building;
        level2.map[9][0] = building;



        fillEmpty(level2.map);


    }

    public void move() {
        String direction = Inputs.inputDirection();
        while (verifyDirection(direction)) {
            direction = Inputs.inputDirection();
        }
        pickPassenger(direction);
        if (direction.equals("S")) {
            map[car.getPosition().getRow() + 1][car.getPosition().getColunm()] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = empty;
            car.move(car.getPosition().getRow() + 1, car.getPosition().getColunm());

        }
        if (direction.equals("A")) {
            map[car.getPosition().getRow()][car.getPosition().getColunm() - 1] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = empty;
            car.move(car.getPosition().getRow(), car.getPosition().getColunm() - 1);
        }
        if (direction.equals("W")) {
            map[car.getPosition().getRow() - 1][car.getPosition().getColunm()] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = empty;
            car.move(car.getPosition().getRow() - 1, car.getPosition().getColunm());
        }
        if (direction.equals("D")) {
            map[car.getPosition().getRow()][car.getPosition().getColunm() + 1] = car;
            map[car.getPosition().getRow()][car.getPosition().getColunm()] = empty;
            car.move(car.getPosition().getRow(), car.getPosition().getColunm() + 1);
        }
        block(direction);
        win();
    }

    public boolean isEmpty(int row, int column) {
        if (map[row][column] == null) {
            return true;
        }
        return false;
    }

    public boolean verifyDirection(String direction) {
        if (direction.equals("S") && (car.getPosition().getRow() + 1 >= map.length || map[car.getPosition().getRow() + 1][car.getPosition().getColunm()].isColision())) {
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("A") && (car.getPosition().getColunm() - 1 < 0 || map[car.getPosition().getRow()][car.getPosition().getColunm() - 1].isColision())) {
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("W") && (car.getPosition().getRow() - 1 < 0 || map[car.getPosition().getRow() - 1][car.getPosition().getColunm()].isColision())) {
            System.out.println("you cant go");
            return true;
        }
        if (direction.equals("D") && (car.getPosition().getColunm() + 1 >= map.length || map[car.getPosition().getRow()][car.getPosition().getColunm() + 1].isColision())) {
            System.out.println("you cant go");
            return true;
        }
        return false;
    }

    private void pickPassenger(String direction) {
        if (direction.equals("W") && map[car.getPosition().getRow() - 1][car.getPosition().getColunm()] == passenger) {
            car.setPassenger(passenger);
            map[passenger.getDestination().getRow()][passenger.getDestination().getColunm()] = new Empty("\uD83D\uDCCD");
        }
        if (direction.equals("A") && map[car.getPosition().getRow()][car.getPosition().getColunm() - 1] == passenger) {
            car.setPassenger(passenger);
            map[passenger.getDestination().getRow()][passenger.getDestination().getColunm()] = new Empty("\uD83D\uDCCD");
        }
        if (direction.equals("S") && map[car.getPosition().getRow() + 1][car.getPosition().getColunm()] == passenger) {
            car.setPassenger(passenger);
            map[passenger.getDestination().getRow()][passenger.getDestination().getColunm()] = new Empty("\uD83D\uDCCD");
        }
        if (direction.equals("D") && map[car.getPosition().getRow()][car.getPosition().getColunm() + 1] == passenger) {
            car.setPassenger(passenger);
            map[passenger.getDestination().getRow()][passenger.getDestination().getColunm()] = new Empty("\uD83D\uDCCD");
        }
    }
    public void block(String direction){
        if (car.getPosition().equals(trigger.getPosition()) && car.getPassenger() != null){
            map[trigger.getActionPosition().getRow()][trigger.getActionPosition().getColunm()] = new Buildings("\uD83D\uDEA7");
            map[trigger.getAction2Position().getRow()][trigger.getAction2Position().getColunm()] = empty;

        }

    }

    public void win() {
        if (car.getPosition().getColunm() == passenger.getDestination().getColunm() && car.getPosition().getRow() == passenger.getDestination().getRow()) {
            passenger.setInDestination(true);
        }

    }

    public void start() {
        Prints.printGrid(map);
        System.out.println("you have to take " + passenger.getName() + "to their destination");
        do {
            move();
            Prints.printGrid(map);
        } while (!passenger.isInDestination());
    }
}
