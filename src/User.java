/**
 * Description: implement user login and register; and check user account
 */


import java.util.Scanner;

public class User {
    String path = "user.txt";
    FileUtil fileUtil = new FileUtil();
    Scanner in = new Scanner(System.in);

    User() {
        System.out.println("***User***");
        fileUtil.createFile(path);
    }

    public void login(){
        while (true){
            System.out.println("\nLOGIN");
            System.out.print("Name: ");
            String name =  in.next();
            in.nextLine();

            System.out.print("Password: ");
            String psw =  in.next();
            in.nextLine();

            if (fileUtil.containsString(path,name+" "+psw)) {
                System.out.println("Login success!");
                break;
            } else {
                System.out.println("Account name or password error!");
            }
        }
    }

    public void register(){
        while (true){
            System.out.print("Please enter your account name: ");
            String name =  in.next();
            in.nextLine();
            if (!fileUtil.writeFile(path,name,true)) {
                System.out.println("Name already exist");
                break;
            }
            System.out.print("Please enter your password: ");
            String psw1 =  in.next();
            in.nextLine();

            while (true) {
                System.out.print("Please enter your password again: ");
                String psw2 =  in.next();
                in.nextLine();
                if (!psw1.equals(psw2)){
                    System.out.println("\nThe passwords are different!");
                    System.out.println("   Please try again\n");
                }
                else{
                    break;
                }
            }

            System.out.print("Please enter your phone number: ");
            String phoneNumber =  in.next();
            in.nextLine();

            System.out.print("Please enter your address: ");
            String address =  in.next();
            in.nextLine();


            if(fileUtil.writeFile(path,name+" "+psw1,true) && fileUtil.writeFile(path,name+" "+phoneNumber+" "+address,true)){
                System.out.println("Register success!");
                break;
            }
        }
    }

    public void LoginOrRegister(){
        System.out.print("Login(1) or Register(2): ");
        int c = in.nextInt();
        in.nextLine();
        switch (c){
            case 1 -> login();
            case 2 -> {
                register();
                login();
            }
        }
    }

    //Calculate the total prices
    public void Account() {
        System.out.println("***Account***");
        Bill bill = new Bill();
        String[] array1 = fileUtil.readFile(path);
        System.out.println("Name: " + array1[1]);
        String contact = bill.separate(array1[3], 1);
        System.out.println("Contact Number: " + contact);
        String address = bill.separate(array1[3], 2);
        System.out.println("Address: " + address);
        Double total = 0.0;
        String[] array = fileUtil.readFile("bill.txt");
        for (int i = 0; i < array.length; i += 3) {
            String price = bill.separate(array[i], 1);
            if (!price.equals("No item")) { // 检查是否成功获取到了价格
                String priceStr = price.substring(0, price.length() - 1);
                Double priceDouble = Double.parseDouble(priceStr);
                total += priceDouble;
            }
        }
        System.out.println("Amount: " + total);
    }


    // public static void main(String[] args) {
    //     User user = new User();
    //     user.Account();
    // }
}
