
import java.sql.*;

public class JDBC_connect {
    public static Connection getConnection() {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket", "root", "Diti@321");
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {//dummy
    }

    
}
