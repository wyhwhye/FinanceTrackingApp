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

            System.out.print("Please enter your password: ");
            String psw1 =  in.next();
            in.nextLine();

            System.out.print("Please enter your password again: ");
            String psw2 =  in.next();
            in.nextLine();

            System.out.print("Please enter your phone number: ");
            String phoneNumber =  in.next();
            in.nextLine();

            System.out.print("Please enter your address: ");
            String address =  in.next();
            in.nextLine();


            if (!psw1.equals(psw2)){
                System.out.println("The passwords are different!");
            }

            else if(fileUtil.writeFile(path,name) && fileUtil.writeFile(path,name+" "+psw1) && fileUtil.writeFile(path,name+" "+phoneNumber+" "+address)){
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

   public void Account(){
        System.out.println("***Account***");
    }

}
