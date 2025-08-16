import java.util.Scanner;
public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1 = 0 , num2 = 0;
        boolean operandsEntered = false;
        double result;
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
                continue;    //skips the loop
            }
            switch(choice){
                case 1:
                    System.out.println("Enter the first number");
                    num1 = sc.nextDouble();
                    System.out.println("Enter the second number");
                    num2 = sc.nextDouble();

                    operandsEntered = true;
                    break;

                case 2:
                    if(!operandsEntered){
                        System.out.println("please enter operands first");
                        break;
                    }
                    result = num1 + num2;
                    System.out.println("The result is : " + result);
                    break;

                case 3:
                    if(!operandsEntered){
                        System.out.println("Please enter the operands first");
                        break;
                    }
                    result = num1 - num2;
                    System.out.println("The result is :" + result);
                    break;

                case 4:
                    if(!operandsEntered){
                        System.out.println("Please enter the operands first");
                        break;
                    }
                    result = num1 * num2;
                    System.out.println("The result is :" + result);
                    break;

                case 5:
                    if(!operandsEntered){
                        System.out.println("Please enter the operands first");
                        break;
                    }
                    result = num1 / num2 ;
                    System.out.println("The result is :" + result);
                    break;

                case 6:
                    System.out.println("Exiting Calculator ....");
                    System.out.println("Thank You for using it !!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Please enter a valid option ( 1 -6 )");
            }
        }
    }
}
