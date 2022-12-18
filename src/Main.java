import in_out.Prints;
import map.Level;
import menu.Menu;
import save.Save;

import java.io.IOException;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        try {
            Menu.startMenu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}