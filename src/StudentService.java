import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    private final ArrayList<Student> students = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    //  Constructor with predefined data
    public StudentService() {
        students.add(new Student(101, "Arjun", 20, "A"));
        students.add(new Student(102, "Priya", 19, "B"));
        students.add(new Student(103, "Rahul", 21, "A"));
        students.add(new Student(104, "Sneha", 20, "C"));
        students.add(new Student(105, "Kiran", 22, "B"));
    }

    public void addStudent(){
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for(Student s : students){
            if(s.getId() == id){
                System.out.println(" Student with this ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        students.add(new Student(id, name, age, grade));
        System.out.println(" Student Added Successfully");
    }

    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println(" No Data Found");
        } else {
            System.out.println("\n--- Students List ---");
            for(Student s : students){
                System.out.println(s);
            }
        }
    }

    public void updateStudent(){
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for(Student s : students){
            if(s.getId() == id){
                System.out.print("Enter new Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new Age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter new Grade: ");
                s.setGrade(sc.nextLine());
                System.out.println(" Student Updated Successfully!");
                return;
            }
        }
        System.out.println(" Student Not Found...");
    }

    public void deleteStudent(){
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                students.remove(i);
                System.out.println(" Student Data Deleted Successfully!");
                return;
            }
        }
        System.out.println(" Student Data Not Found...");
    }

    //  Search by ID
    public void searchById(){
        System.out.print("Enter Student ID to Search: ");
        int id = sc.nextInt();
        sc.nextLine();

        for(Student s : students){
            if(s.getId() == id){
                System.out.println(" Student Found: " + s);
                return;
            }
        }
        System.out.println(" Student Not Found with ID: " + id);
    }

    //  Search by Name
    public void searchByName(){
        System.out.print("Enter Student Name to Search: ");
        String name = sc.nextLine();

        boolean found = false;
        for(Student s : students){
            if(s.getName().equalsIgnoreCase(name)){
                System.out.println(" Student Found: " + s);
                found = true;
            }
        }
        if(!found){
            System.out.println(" No Student Found with Name: " + name);
        }
    }
}
