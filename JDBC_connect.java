import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class JDBC_connect{
    
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String databaseName = "cricket_db";
            String userName = "root";
            String password = "Diti@321";
    
            return DriverManager.getConnection(url + databaseName, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        // Dummy main method
        System.out.println("This class is not meant to be executed directly.");
    }
    
}
