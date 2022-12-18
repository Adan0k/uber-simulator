package in_out;

import java.util.Scanner;

public class Inputs {
    static private Scanner scanner = new Scanner(System.in);

    public static String inputString(){
        return scanner.nextLine();
    }
    public static String inputDirection(){
        String direction = inputString().toUpperCase();
        boolean check = direction.equals("W") || direction.equals("A") || direction.equals("S") || direction.equals("D");
        if (direction.length() == 1 && check){
            return direction;
        }
        System.out.println("The directions are only W,A,S,D");
        return inputDirection();
    }
    public static int inputMenuOptions(int initial, int finale){
        int op = scanner.nextInt();
        if (op >= initial && op <= finale){
            return op;
        }
        System.out.println("this is not a option");
        return inputMenuOptions(initial,finale);
    }
}
