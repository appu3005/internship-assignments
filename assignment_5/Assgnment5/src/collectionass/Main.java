package collectionass;

import java.util.*;

public class Main {

    static Set<Department> departments = new HashSet<>();
    static List<Student> students = new LinkedList<>();
    static Map<Integer, Student> studentMap = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT & DEPARTMENT SYSTEM =====");
            System.out.println("1. Add Department");
            System.out.println("2. Display Departments");
            System.out.println("3. Add Student");
            System.out.println("4. Display Students");
            System.out.println("5. Search Student by Roll No");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Display Students Department-wise");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addDepartment();
                case 2 -> displayDepartments();
                case 3 -> addStudent();
                case 4 -> displayStudents();
                case 5 -> searchStudent();
                case 6 -> updateStudent();
                case 7 -> deleteStudent();
                case 8 -> deptWise();
            }

        } while (choice != 0);
    }


    static void addDepartment() {
        System.out.print("Enter Dept ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Dept Name: ");
        String name = sc.nextLine();

        Department d = new Department(id, name);

        if (departments.add(d))
            System.out.println("Department Added");
        else
            System.out.println("Duplicate Department ID not allowed");
    }


    static void displayDepartments() {
        for (Department d : departments) {
            System.out.println(d);
        }
    }

  
    static void addStudent() {

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        if (studentMap.containsKey(roll)) {
            System.out.println("Student already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        System.out.print("Enter Dept ID: ");
        int deptId = sc.nextInt();

        Department dept = null;

        for (Department d : departments) {
            if (d.getDeptId() == deptId) {
                dept = d;
                break;
            }
        }

        if (dept == null) {
            System.out.println("Department not found!");
            return;
        }

        Student s = new Student(roll, name, marks, dept);

        students.add(s);
        studentMap.put(roll, s);

        System.out.println("Student Added!");
    }

  
    static void displayStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }


    static void searchStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        Student s = studentMap.get(roll);

        if (s != null)
            System.out.println(s);
        else
            System.out.println("Student Not Found!");
    }


    static void updateStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student s = studentMap.get(roll);

        if (s == null) {
            System.out.println("Student Not Found!");
            return;
        }

        System.out.print("Enter New Name: ");
        s.setName(sc.nextLine());

        System.out.print("Enter New Marks: ");
        s.setMarks(sc.nextDouble());

        System.out.println("Updated Successfully!");
    }


    static void deleteStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        Student s = studentMap.remove(roll);

        if (s != null) {
            students.remove(s);
            System.out.println("Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }


    static void deptWise() {

        for (Department d : departments) {
            System.out.println("\nDepartment: " + d.getDeptName());

            for (Student s : students) {
                if (s.getDepartment().getDeptId() == d.getDeptId()) {
                    System.out.println(s);
                }
            }
        }
    }
}