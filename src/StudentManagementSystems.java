import java.util.Scanner;

public class StudentManagementSystems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while(true){
            System.out.println("\n======= Student Management System =======");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Search Student by Name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> service.addStudent();
                case 2 -> service.viewStudents();
                case 3 -> service.updateStudent();
                case 4 -> service.deleteStudent();
                case 5 -> service.searchById();
                case 6 -> service.searchByName();
                case 7 -> {
                    System.out.println("Bye Bye.. Thanks for your Concern....");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice! Choose again...");
            }
        }
    }
}
