package Projects;
import java.util.Scanner;
public class Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("**********************************");
        System.out.println("<-- WELCOME TO STUDENT SECTION -->");
        System.out.println("***********************************");

        while(true){
            System.out.println("Enter 1 to Add the Student");
            System.out.println("Enter 2 to Update the Student");
            System.out.println("Enter 3 to Remove the Student");
            System.out.println("Enter 4 to View the Student Details");
            System.out.println("Enter 5 to Exit");

            System.out.println("Enter your choice ......");
            int choice;
            if(sc.hasNextInt()){
                choice = sc.nextInt();
                break;
            }else{
                System.out.println("Invalid input!!");
                System.out.println("Please re-enter from the above option");
                sc.nextLine(); //clear's the buffer memory
            }

        }

    }
}
