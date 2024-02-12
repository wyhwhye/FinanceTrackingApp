/**
 * FinanceTracking
 * 3, Feb, 2024
 * Description: This program helps individuals to manage their daily expense.
 */

import java.util.Scanner;

public class Main {
    /**
     * list the menu
     *
     */
    public static void showMenu(){
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
    public static void Loop(User user, Bill bill){
        Scanner in = new Scanner(System.in);
        int cmd = 0;
        for(;;){
            showMenu();
            cmd = in.nextInt();
            in.nextLine();
            switch (cmd){
                case 1 -> bill.AddItems();
                case 2 -> bill.Categories();
                case 3 -> bill.TimeLine();
                case 4 -> user.Account();
                case -1 -> {
                    return;
                }
                default -> System.out.println("Please enter correct number!");
            }
        }
    }


    public static void main(String[] args) {
        User user = new User();
        Bill bill = new Bill();

        user.LoginOrRegister();

        Loop(user, bill);
    }

}
