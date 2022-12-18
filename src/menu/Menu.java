package menu;

import in_out.Inputs;
import in_out.Prints;
import map.Level;
import save.Save;

import java.util.EnumSet;
import java.util.concurrent.ExecutionException;

public class Menu {
    public static void startMenu() throws Exception {
        Prints.wellcome();
        Prints.printMenu();
        int op = Inputs.inputMenuOptions(0,3);
        Level.buildAllLevels();

        switch (op){
            case 1:
                Level.level1.start();
                backToMain();
                Level.level2.start();
                backToMain();
                break;
            case 2:
                if (Save.getSave() == EnumSet.allOf(Level.class).size()){
                    Prints.loadMenu(EnumSet.allOf(Level.class));
                    int lOp = Inputs.inputMenuOptions(1,EnumSet.allOf(Level.class).size());
                    Level.fromInt(lOp).start();
                    backToMain();
                    break;
                }
                Level.fromInt(Save.getSave()).start();
                backToMain();
                break;
            case 3:
                backToMain();
                break;
            case 0:
                System.out.println("bye bye");
                return;
        }
    }
    public static void backToMain() throws Exception {
        System.out.println("Do you want to back to main menu? 1-yes 2-no");
        int op = Inputs.inputMenuOptions(1,2);
        if (op == 2){
            System.out.println("bye bye");
            return;
        }
        startMenu();
    }
}
