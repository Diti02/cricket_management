
import java.sql.*;

public class JDBC_connect {
    public static Connection getConnection() {
        try{
            //Step1: load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Step2: create a connection
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket", "root", "Diti@321");

        }catch(Exception e){
            e.printStackTrace();
                return null;
        }
    }

    public static void main(String[] args) {//dummy
    }

    
}
