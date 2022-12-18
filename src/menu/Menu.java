package menu;

import in_out.Inputs;
import in_out.Prints;
import map.Level;

public class Menu {
    public static void startMenu(){
        Prints.wellcome();
        Prints.printMenu();
        int op = Inputs.inputMenuOptions(0,3);

        switch (op){
            case 1:
                Level.buildLevel2();
                Level.level2.start();
                break;
            case 2:
                break;
            case 3:
                break;
            case 0:
                System.out.println("bye bye");
                return;
        }
    }
}
