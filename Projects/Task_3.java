package Projects;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_3 {
    static class Student{

        private String Name;
        private int Roll_No;
        private String DOB;
        private String Department;

        public Student(String Name , int Roll_No , String DOB , String Department){
            this.Name = Name;
            this.Roll_No = Roll_No;
            this.DOB = DOB;
            this.Department = Department;
        }

        //getter and setter
        public String getName() {
            return Name;
        }
        public void setName(String Name) {
            this.Name = Name;
        }

        public int getRoll_No() {
            return Roll_No;
        }
        public void setRoll_No(int Roll_No) {
            this.Roll_No = Roll_No;
        }

        public String getDOB(){
            return DOB;
        }
        public void setDOB(String DOB){
            this.DOB = DOB;
        }

        public String getDepartment(){
            return Department;
        }
        public void setDepartment(String Department){
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
                continue;
            }

            switch (choice){
                case 1:
                    String Name;
                    while(true) {
                        System.out.println("Enter Name :");
                         Name = sc.nextLine().trim();

                         if(Name.matches("[a-zA-Z ]+")){
                             break;
                        }else{
                             System.out.println("Invalid name , Please re-enter !!!");
                         }
                    }

                    int Roll_No;
                    while(true){
                        System.out.println("Enter your Roll Number :");
                        Roll_No = sc.nextInt();
                        sc.nextLine();

                        if(Roll_No >= 1 && Roll_No <=100){
                            break;
                        }else{
                            System.out.println("Enter the Valid Roll Number");
                        }
                    }

                    String DOB;
                    while(true){
                        System.out.println("Enter DOB (dd-MM-yyyy)");
                        DOB = sc.nextLine().trim();
                        try{
                            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            java.time.LocalDate birthDate = java.time.LocalDate.parse( DOB , formatter);
                            java.time.LocalDate today = java.time.LocalDate.now();
                            int age = Period.between( birthDate , today).getYears();

                            if(age >= 5 && age <= 18){
                                break;
                            }else{
                                System.out.println("Age must be between 5 to 18 years.");
                            }

                        } catch (Exception e) {
                            System.out.println("Invalid DOB format!! Please use dd-MM-yyyy");
                        }
                    }

                    String Department;
                    while(true){
                        System.out.println("Enter your Department (Science / Commerce / Arts) : ");
                        Department = sc.nextLine().trim();

                        if(Department.equalsIgnoreCase("Science") ||
                           Department.equalsIgnoreCase("Commerce") ||
                                Department.equalsIgnoreCase(("Arts"))){
                            break;
                        }else{
                            System.out.println("Invalid Department. Please choose from the above option");
                        }
                    }

                    Student newStudent = new Student(Name , Roll_No , DOB , Department);
                    Students.add(newStudent);
                    System.out.println("Student added successfully");
                    break;

                case 2:
                    System.out.println("Enter Roll Number of Student to update");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();

                    boolean Updated = false;

                    for(Student s : Students){
                        if(s.getRoll_No() == updateRoll){
                            Updated = true;

                            System.out.println("Enter new Name (leave blank to keep it same) :");
                            String newName = sc.nextLine().trim();
                            if(!newName.isEmpty() && newName.matches("[a-zA-Z ]+")){
                                s.setName(newName);
                            }

                            System.out.println("Enter new DOB (dd-MM-yyyy) (leave blank to keep it same");
                            String newDOB = sc.nextLine().trim();
                            if (!newDOB.isEmpty()){
                                try{
                                    java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                    java.time.LocalDate.parse(newDOB , formatter);
                                    s.setDOB(newDOB);
                                } catch (Exception e) {
                                    System.out.println("Invalid DOB !! Keeping the old DOB");
                                }
                            }

                            System.out.println("Enter new Department (Science/Commerce/Arts) (leave blank to keep it same)");
                            String newDept = sc.nextLine().trim();
                            if(!newDept.isEmpty() &&
                                    (newDept.equalsIgnoreCase("Science") ||
                                    newDept.equalsIgnoreCase("Commerce") ||
                                    newDept.equalsIgnoreCase("Arts"))){
                                s.setDepartment(newDept);
                            }

                            System.out.println("Student details are updated. ");
                            break;
                        }
                    }

                    if(!Updated){
                        System.out.println("Student with Roll No " + updateRoll + "not found!") ;
                    }
                    break;

                case 3:
                    System.out.println("Enter your Roll Number to remove :");
                    int removeRoll = sc.nextInt();
                    boolean remove = false;

                    for(int i = 0; i < Students.size(); i++){
                        if(Students.get(i).getRoll_No() == removeRoll){
                            Students.remove(i);
                            System.out.println("Student removed successfully");
                            remove = true;
                            break;
                        }
                    }

                    if(!remove){
                        System.out.println("Student with Roll Number " + removeRoll + "not found");
                    }
                    break;

                case 4:
                    if(Students.isEmpty()){
                        System.out.println("Student not Found!!!");
                    }else{
                        System.out.println("Student Detail");
                        for(Student s : Students) {
                            System.out.println("Name of the Student is : " + s.getName());
                            System.out.println("Roll Number of the Student is : " + s.getRoll_No());
                            System.out.println("D.O.B of the Student is : " + s.getDOB());
                            System.out.println("Department of the Student is : " + s.getDepartment());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thanh You for visiting.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input!!");
                    System.out.println("Please re-enter the Option");
            }

        }

    }
}
