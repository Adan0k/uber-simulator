import entity.Car;
import entity.Entity;
import map.Position;
import prints.Prints;

public class Main {
    public static void main(String[] args) {
        Prints.wellcome();
        Car car = new Car(new Position(14,14),"\uD83D\uDE97");
        Entity[][] grid = new Entity[15][15];
        grid[0][0] = car;

        Prints.printGrid(grid);
    }
}