import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students;
    private Scanner sc = new Scanner(System.in);

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter grade: ");
        char grade = sc.nextLine().charAt(0);
        students.add(new Student(name, grade));
        System.out.println("Student added successfully!");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student st : students) {
            System.out.println(st);
        }
    }

    public void updateGrade() {
        System.out.print("Enter student name to update: ");
        String name = sc.nextLine();
        boolean updated = false;
        for (Student st : students) {
            if (st.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new grade: ");
                char grade = sc.nextLine().charAt(0);
                st.setGrade(grade);
                updated = true;
                System.out.println(name + "'s grade updated to " + grade);
                break;
            }
        }
        if (!updated) {
            System.out.println(name + " not found.");
        }
    }

    public void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = sc.nextLine();
        boolean removed = students.removeIf(st -> st.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println(name + " removed successfully.");
        } else {
            System.out.println(name + " not found.");
        }
    }

    public void searchStudent() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        for (Student st : students) {
            if (st.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + st);
                return;
            }
        }
        System.out.println(name + " not found.");
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Grade");
            System.out.println("4. Remove Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: manager.addStudent(); break;
                case 2: manager.displayStudents(); break;
                case 3: manager.updateGrade(); break;
                case 4: manager.removeStudent(); break;
                case 5: manager.searchStudent(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
