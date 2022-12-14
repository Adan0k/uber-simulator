import entity.Car;
import entity.Entity;
import map.Level;
import map.Position;
import in_out.Prints;

public class Main {
    public static void main(String[] args) {
        Prints.wellcome();
        Car car = new Car(new Position(14,14),"\uD83D\uDE97");
        Entity[][] grid = new Entity[15][15];
        grid[0][0] = car;

        Level.buildLevel1();
        Level.level1.start();

    }
}