/**
 * FinanceTracking
 * 3, Feb, 2024
 * Description: This program helps individuals to manage their daily expense.
 */

import java.text.ParseException;
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
        System.out.print("What would you like to do? Please enter number 1-4. (-1 to exit): \n");
    }


    /**
     * Continually waiting and analyze user's input.
     * According to the input, it will call relevant function.
     * @throws ParseException
     *
     */
    public static void Loop(User user, Bill bill) throws ParseException{
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


    public static void main(String[] args) throws ParseException {
        String smileyFace =
                "\n  *****  \n" +
                        " *     * \n" +
                        "*  O O  *\n" +
                        "*   ∇   *\n" +
                        " *     * \n" +
                        "  *****  \n" +
                        "\n MADE BY\n" +
                        " ZHUA WA \n";
        System.out.println(smileyFace);
        User user = new User();
        Bill bill = new Bill();

        user.LoginOrRegister();

        Loop(user, bill);
    }

}
