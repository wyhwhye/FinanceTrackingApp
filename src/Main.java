/**
 * FinanceTracking
 * 3, Feb, 2024
 * Description: This program helps individuals to manage their daily expense.
 */

import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);
    /**
     * list the menu
     *
     */
    public void showMenu(){
        System.out.println();
        System.out.println("Menus:");
        System.out.println("1. Add items");
        System.out.println("2. Categories");
        System.out.println("3. Time line");
        System.out.println("4. Account");
        System.out.print("What would you like to do? Please enter number 1-4. (-1 to exit): ");
    }


    /**
     * Continually waiting and analyze user's input.
     * According to the input, it will call relevant function.
     *
     */
    public void Loop(){
        Scanner in = new Scanner(System.in);
        int cmd = 0;
        for(;;){
            showMenu();
            cmd = in.nextInt();
            in.nextLine();
            switch (cmd){
                case 1 -> new AddItems();
                case 2 -> new Categories();
                case 3 -> new TimeLine();
                case 4 -> new Account();
                case -1 -> {
                    return;
                }
                default -> System.out.println("Please enter correct number!");
            }
        }
    }


    public static void main(String[] args) {
        LoginRegister loginRegister = new LoginRegister();
        Main FT = new Main();

        loginRegister.LoginOrRegister();
        FT.Loop();
    }

}
