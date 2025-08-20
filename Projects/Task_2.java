package Projects;
import java.util.Scanner;

public class Task_2 {

    //creating arrays
    static int[] account_num = new int[100];
    static String[] names = new String[100];
    static int[] ages = new int[100];
    static String[] accountType = new String[100];
    static String[] password = new String[100];
    static double[] balance = new double[100];
    static int accnt_count = 0;

    //checking the balance
    public static void check_balance(){
        int index = login();
        if(index==-1){
            return;
        }
        System.out.println("Your current balance is : " + balance[index]);
    }

    //withdraw money
    public static void withdraw(Scanner sc){
        int index = login();
        if(index == -1){
            return;
        }
        System.out.println("Enter the amount");
        double withdraw_amt = sc.nextDouble();

        if(withdraw_amt <= balance[index]){
            balance[index] -= withdraw_amt;
            System.out.println("Successful debited.");
            System.out.println("Your new Balance is " +balance[index]);
        }else{
            System.out.println("Your balance is low");
        }
    }

    //depositing money
    public static void deposit(Scanner sc){
        int index =  login();
        if(index == -1){
            return;
        }
        System.out.println("Enter the amount to deposit : ");
        double amt = sc.nextDouble();

        if(amt >= 1500){
            balance[index] +=amt;
            System.out.println("Your money has been credited to your account, the new balance is : " + balance[index]);
        }else{
            System.out.println("The minimum deposit is Rs.1500");
        }
    }

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
        balance[accnt_count] = initialDeposit;

        accnt_count++;
    }

    //login to the account
    public static int login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Account Number");
        int  accNum = sc.nextInt();
        System.out.println("Enter your password");
        String pass_key = sc.next();

        for(int i = 0; i<accnt_count; i++){
            if(account_num[i] == accNum && password[i].equals(pass_key)){
                return i;
            }
        }
        System.out.println("Invalid account number or password");
        return -1;
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
                case 1:
                    account(sc);
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    check_balance();
                    break;
                case 5:
                    System.out.println("Thank You for Visiting.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid input!!");
                    System.out.println("Enter a valid option");
            }
        }
    }
}
