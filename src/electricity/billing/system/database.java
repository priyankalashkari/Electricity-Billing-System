package electricity.billing.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    Connection connection;
    Statement statement;

    // Constructor to initialize database connection and statement
    public database() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            String url = "jdbc:mysql://localhost:3306/BillSystem";
            String username = "root";
            String password = "2306";
            connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            statement = connection.createStatement();
            System.out.println("Connected successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    // Main method for testing connection
    public static void main(String[] args) {
        database db = new database();
        if (db.connection != null) {
            System.out.println("Connection object: " + db.connection);
        } else {
            System.err.println("Failed to establish connection.");
        }
    }
}
