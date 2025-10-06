/* Jonah Aney 10/04/25 CSD-420 Module 10: Fans 

Follow the directions below:

    Write a program that views and updates fan information stored in database titled "databasedb", user ID titled “student1” with a password “pass”.
    The table name is to be “fans” with the fields of ID (integer, PRIMARY KEY), firstname (varchar (25)), lastname (varchar(25)), and favoriteteam (varchar(25)).
    Your interface is to have 2 buttons to display and update records.
        The display button will display the record with the provided ID in the display (ID user provides).
        The update button will update the record in the database with the changes made in the display.
    Your application is not to create or delete the table.
    To work on this using your home database, you can make the table and populate it.
    When the application is tested, the table will already be created and populated.
    Write test code that ensures all methods and the interface functions correctly.

 */

// This class, "DatabaseHelper" handles database connetions and queries. It uses prepared statements and try-with-resources.

import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/databasedb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    public DatabaseHelper() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ensures driver is loaded and safe to include.
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found. Add the connector JAR to project libraries.", e);
        }
    }

// Test connection helper
    public boolean testConnection() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

// SELECT by ID
    public Fan getFanById(int id) {
        String sql = "SELECT ID, firstname, lastname, favoriteteam FROM fans WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Fan(
                        rs.getInt("ID"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("favoriteteam")
                    );
                } else {
                    return null; // not found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

// UPDATE record
    public boolean updateFan(Fan fan) {
        String sql = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fan.getFirstName());
            ps.setString(2, fan.getLastName());
            ps.setString(3, fan.getFavoriteTeam());
            ps.setInt(4, fan.getId());

            int rows = ps.executeUpdate();
            return rows == 1; // true if one row updated
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
