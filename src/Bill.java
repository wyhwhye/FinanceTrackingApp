import java.util.Scanner;

/**
 * Description: implement add bill and check bills(category and time line)
 */

public class Bill {
    String path = "bill.txt";
    FileUtil fileUtil = new FileUtil();
    Scanner in = new Scanner(System.in);
    Bill(){
        System.out.println("***Bills***");
        fileUtil.createFile(path);
    }

    public void AddItems(){
        System.out.println("***AddItems***");

        System.out.println("Please enter your bill:");
        System.out.println("(Name) (Price) (Date)");
        System.out.println("goggle 14$ 2/12/2024");
        String input1 = in.nextLine();

        System.out.println("(Type)");
        System.out.println("clothes");
        String input2 = in.nextLine();

        System.out.println("(Notes)");
        System.out.println("black, the magic 5");
        String input3 = in.nextLine();

        fileUtil.writeFile(path, input1);
        fileUtil.writeFile(path, input2);
        fileUtil.writeFile(path, input3);
    }

    public void Categories(){
        System.out.println("***Categories***");
    }

    public void TimeLine(){
        System.out.println("***TimeLine***");
    }

}
