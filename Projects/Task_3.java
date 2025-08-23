package Projects;
import java.util.ArrayList;
import java.util.Scanner;
public class Task_3 {
    class Student{

        private String Name;
        private int Roll_No;
        private int Age;
        private String Department;

        public Student(String name , int Roll_No , int age , String Department){
            this.Name = Name;
            this.Roll_No = Roll_No;
            this.Age = Age;
            this.Department = Department;
        }

        //getter and setter
        public String getName() {
            return Name;
        }
        public void setName(String name) {
            this.Name = Name;
        }

        public int getRoll_No() {
            return Roll_No;
        }
        public void setRoll_No(int roll_No) {
            this.Roll_No = Roll_No;
        }

        public int getAge(){
            return Age;
        }
        public void setAge(int age){
            this.Age = Age;
        }

        public String getDepartment(){
            return Department;
        }
        public void setDepartment(String department){
           this.Department = Department;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> Students = new ArrayList<>();

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
                sc.nextLine(); // consume the line
            }else{
                System.out.println("Invalid input!!");
                System.out.println("Please re-enter from the above option");
                sc.nextLine(); //clear's the buffer memory
            }

        }

    }
}
