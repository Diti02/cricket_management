import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import myPackage.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MatchDAO {
    // Method to insert a match into the database
    public static void insertMatch(Match match) {
        try (Connection connection = JDBC_connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO matchresult (teamA, teamB, oversTotal,teamAruns, teamBruns, winner,teamAwickets, teamBwickets) VALUES (?, ?, ?, ?, ?, ? , ?, ?)")) {
            statement.setString(1, match.getTeamA().getName());
            statement.setString(2, match.getTeamB().getName());
            statement.setInt(3, match.getOvers());
            statement.setInt(4, match.getTeamA().getTotalRuns());
            statement.setInt(5, match.getTeamB().getTotalRuns());
            if(match.getTeamA().getTotalRuns()>match.getTeamB().getTotalRuns()){
                statement.setString(6, match.getTeamA().getName());
            }else if(match.getTeamA().getTotalRuns()<match.getTeamB().getTotalRuns()){
                statement.setString(6, match.getTeamB().getName());
            }else if(match.getWinner()==-1){
                statement.setString(6, "Match Draw");
            }
            statement.setInt(7, match.getTeamA().getWicketsFell());
            statement.setInt(8, match.getTeamA().getWicketsFell());
            
            
            

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}