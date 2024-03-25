import java.sql.*;

public class MedicalRecords {
    public static void main(String[] args) {
        try {
            String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "gowri";
            String password = "root"; 

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT patient_id, name, problem, bill FROM patients")) {

                while (resultSet.next()) {
                    int patientId = resultSet.getInt("patient_id");
                    String name = resultSet.getString("name");
                    String problem = resultSet.getString("problem");
                    double bill = resultSet.getDouble("bill");

                    System.out.println("Patient ID: " + patientId);
                    System.out.println("Name: " + name);
                    System.out.println("Problem: " + problem);
                    System.out.println("Bill: " + bill);
                    
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error: JDBC driver not found");
        }
    }
}