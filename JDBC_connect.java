import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBC_connect {
    public static Connection getConnection() {
        try{
            FileInputStream fis=new FileInputStream("db.properties");
            Properties p= new Properties();
            p.load(fis);

            String url=p.getProperty("url");
            String user=p.getProperty("username");
            String password=p.getProperty("password");
            // return DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket", "root", "Diti@321");
            return DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {//dummy
    }

    
}
