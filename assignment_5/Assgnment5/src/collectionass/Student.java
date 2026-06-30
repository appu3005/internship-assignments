package collectionass;

public class Student {

    private int rollNo;
    private String name;
    private double marks;
    private Department department;

    public Student(int rollNo, String name, double marks, Department department) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.department = department;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student [RollNo=" + rollNo +
                ", Name=" + name +
                ", Marks=" + marks +
                ", Department=" + department.getDeptName() + "]";
    }
}