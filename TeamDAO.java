import myPackage.*;
import java.sql.*;


public abstract class TeamDAO {
    public static void insertTeam(Team team) {
        try {
            Connection con = JDBC_connect.getConnection();
            if (con != null) {
                
                // Check if the team name does not already exist then insert
                if (!teamExists(con, team.getName())) {                   
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO team (teamName) VALUES (?)");
                    pstmt.setString(1, team.getName());
                    pstmt.executeUpdate();
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to check if a team name exists in the database
    private static boolean teamExists(Connection con, String teamName) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) FROM team WHERE teamName = ?");
        pstmt.setString(1, teamName);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        return count > 0;
    }
}
