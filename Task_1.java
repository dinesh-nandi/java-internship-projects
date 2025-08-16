import java.util.Scanner;
public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** THE CALCULATOR ***");
        while(true){
            System.out.println("<---- MENU ---->");
            System.out.println("Enter 1 to enter OPERANDS");
            System.out.println("Enter 2 to ADD      ( + )");
            System.out.println("Enter 3 to SUBTRACT ( - )");
            System.out.println("Enter 4 to MULTIPLY ( * )");
            System.out.println("Enter 5 to DIVIDE   ( / )");
            System.out.println("Enter 6 to EXIT");
            System.out.println("Choose an option (1-6)");

            int choice;
            if(sc.hasNextInt()){  //check's it is an integer or not
                choice =  sc.nextInt();
            }else{
                System.out.println("Invalid input !!!");
                System.out.println("Please enter a number between 1-6");
                sc.next();   //clear's the buffer memory
            }
        }
    }
}
