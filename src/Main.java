import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice!");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Roll No: ");
                        int roll = Integer.parseInt(sc.nextLine());

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());
                        if (marks < 0) {
                            System.out.println("Marks cannot be negative.");
                            break;
                        }

                        Student s = new Student(roll, name, dept, marks);
                        dao.addStudent(s);
                    } catch (Exception e) {
                        System.out.println("Input error!");
                    }
                    break;

                case 2:
                    dao.viewAll();
                    break;

                case 3:
                    System.out.print("Roll No: ");
                    int rollUpdate = Integer.parseInt(sc.nextLine());
                    System.out.print("New Marks: ");
                    double m = Double.parseDouble(sc.nextLine());

                    dao.updateMarks(rollUpdate, m);
                    break;

                case 4:
                    System.out.print("Roll No: ");
                    int rollDelete = Integer.parseInt(sc.nextLine());
                    dao.deleteStudent(rollDelete);
                    break;

                case 5:
                    System.out.print("Roll No: ");
                    int rollSearch = Integer.parseInt(sc.nextLine());
                    dao.searchStudent(rollSearch);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
