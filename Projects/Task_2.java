package Projects;
import java.util.Scanner;

public class Task_2 {

    //creating arrays
    static int[] account_num = new int[100];
    static String[] names = new String[100];
    static int[] ages = new int[100];
    static String[] accountType = new String[100];
    static String[] password = new String[100];
    static int accnt_count = 0;

    //creating an account
    public static void account(Scanner sc){

        String name;
        while(true){
            System.out.println("Enter your Name");
            name = sc.nextLine().trim();

            if(name.matches("[a-zA-Z ]+")){
                break;
            }else{
                System.out.println("Invalid Name!! Please re-enter your name");
            }
        }

        int age;
        while(true){
            try{
                System.out.println("Enter your Age");
                age = sc.nextInt();
                if(age >= 0 && age <= 120){
                    break;
                }else{
                    System.out.println("Invalid!!!!");
                }
            } catch (Exception e) {
                System.out.println("Enter a valid age");
                sc.nextLine();
            }
        }

        String account_type;
        while(true){
            try{
                System.out.println("What's your account type (Savings/Current)??");
                account_type = sc.next().trim();
                if(account_type.equalsIgnoreCase("Savings") || account_type.equalsIgnoreCase("Current")){
                    break;
                }else{
                    throw new IllegalArgumentException("Invalid type of account");
                }
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch(Exception e){
                System.out.println("Error!! " + e.getMessage());
            }
        }

        String pass;
        while(true){
            System.out.println("Set your Password");
            pass = sc.next();
            if(pass.length()>=8){
                break;
            }else{
                System.out.println("Your password must have 8 character");
            }
        }

        double initialDeposit;
        while(true){
            try{
                System.out.println("Add initial money");
                initialDeposit = sc.nextDouble();
                if(initialDeposit >= 1500){
                    break;
                }else{
                    System.out.println("The minimum deposit is 1500");
                }
            } catch (Exception e) {
                System.out.println("Unexpected Error!! : " + e.getMessage());
                sc.nextLine();
            }
        }

        System.out.println("Your account has been created");
        int accountNumber = (int)(Math.random()*10000)+1000;
        System.out.println("Your account number is : " + accountNumber);

        //storing data in array
        account_num[accnt_count] = accountNumber;
        names[accnt_count] = name;
        ages[accnt_count] = age;
        accountType[accnt_count] = account_type;
        password[accnt_count] = pass;

        accnt_count++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            //Menu of the Bank
            System.out.println("****WELCOME TO THE BANK****");
            System.out.println("Enter 1 to create Account");
            System.out.println("Enter 2 to Deposit Money");
            System.out.println("Enter 3 to Withdraw Money");
            System.out.println("Enter 4 to Check Balance");
            System.out.println("Enter 5 to Exit");

            //Selecting an option from the menu
            System.out.println("Enter your option ----> ");
            int choice;

            if(sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine();  //clear's the buffer memory
            }else{
                System.out.println("Invalid input !!!");
                System.out.println("Please re-enter the valid option");
                sc.nextLine();  //clear's the buffer memory
                continue;
            }

            switch (choice){

            }
        }
    }
}
