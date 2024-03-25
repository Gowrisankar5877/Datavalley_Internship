import java.sql.*;

public class DepartmentDatabase {
    
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USERNAME = "gowri";
    private static final String PASSWORD = "123456";


    static class Department {
        private int id;
        private String name;

        public Department(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        try {
            
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);


            insertDepartment(connection, new Department(1, "IT"));

           
            connection.close();
            System.out.println("Department inserted successfully.");
        } 
		catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertDepartment(Connection connection, Department department) throws SQLException {
        String query = "INSERT INTO department (id, name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, department.getId());
        statement.setString(2, department.getName());
        statement.executeUpdate();
        statement.close();
    }
}
