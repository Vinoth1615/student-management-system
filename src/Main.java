import java.util.*;

class Student1 {
    private final int id;
    private String name;
    private int age;
    private String grade;

    public Student1(int id, String name, int age, String grade){
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public int getAge(){ return age; }
    public String getGrade(){ return grade; }

    public void setName(String name){ this.name = name; }
    public void setAge(int age){ this.age = age; }
    public void setGrade(String grade){ this.grade = grade; }

    @Override
    public String toString(){
        return "ID: "+id + " | Name: " +name+ " | Age: "+age+ " | Grade: "+grade;
    }
}

public class Main {
    private static final ArrayList<Student1> students = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("\n======= Student Management System =======");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Bye Bye.. Thanks for your Concern....");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice! Choose again...");
            }
        }
    }

    private static void addStudent(){
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // prevent duplicate ID
        for(Student1 s : students){
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

        students.add(new Student1(id, name, age, grade));
        System.out.println(" Student Added Successfully");
    }

    private static void viewStudents(){
        if(students.isEmpty()){
            System.out.println(" No Data Found");
        } else {
            System.out.println("\n--- Students List ---");
            for(Student1 s : students){
                System.out.println(s);
            }
        }
    }

    private static void updateStudent(){
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for(Student1 s : students){
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

    private static void deleteStudent(){
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for (Iterator<Student1> iterator = students.iterator(); iterator.hasNext();) {
            Student1 s = iterator.next();
            if (s.getId() == id) {
                iterator.remove();
                System.out.println(" Student Data Deleted Successfully!");
                return;
            }
        }
        System.out.println(" Student Data Not Found...");
    }
}
