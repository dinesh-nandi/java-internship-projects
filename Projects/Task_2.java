package Projects;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("****WELCOME TO THE BANK****");
            System.out.println("Enter 1 to create Account");
            System.out.println("Enter 2 to Deposit Money");
            System.out.println("Enter 3 to Withdraw Money");
            System.out.println("Enter 4 to Check Balance");
            System.out.println("Enter 5 to Exit");

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
