public class Student {
    private int rollNo;
    private String name;
    private String department;
    private double marks;

    public Student(int rollNo, String name, String department, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getMarks() { return marks; }
}
