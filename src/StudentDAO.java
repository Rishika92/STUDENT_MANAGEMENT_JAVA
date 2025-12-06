import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
//add student method
    public boolean addStudent(Student s) {
        String query = "INSERT INTO students VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, s.getRollNo());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDepartment());
            ps.setDouble(4, s.getMarks());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
//view all students method
    public void viewAll() {
        String query = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " +
                                   rs.getString(2) + " | " +
                                   rs.getString(3) + " | " +
                                   rs.getDouble(4));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
//search student method
    public void searchStudent(int roll) {
        String query = "SELECT * FROM students WHERE rollNo = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, roll);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Found: " + rs.getString("name") +
                                   " | Dept: " + rs.getString("department") +
                                   " | Marks: " + rs.getDouble("marks"));
            } else {
                System.out.println("No student found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
//update marks method
    public boolean updateMarks(int roll, double marks) {
        String query = "UPDATE students SET marks = ? WHERE rollNo = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setDouble(1, marks);
            ps.setInt(2, roll);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
//delete student method
    public boolean deleteStudent(int roll) {
        String query = "DELETE FROM students WHERE rollNo = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, roll);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
