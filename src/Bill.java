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
        System.out.println("(Name) (Price) (Date) (Type) (Notes)");
        String input = in.nextLine();
        fileUtil.writeFile(path, input);
    }

    public void Categories(){
        System.out.println("***Categories***");
    }

    public void TimeLine(){
        System.out.println("***TimeLine***");
    }

}
