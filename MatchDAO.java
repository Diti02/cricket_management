// Connection connection = JDBC_connect.getConnection();


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import myPackage.*;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO {
    // Method to insert a match into the database
    public static void insertMatch(Match match) {
        try (Connection connection = JDBC_connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO matches (teamA_name, teamB_name, overs, result) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, match.getTeamA().getName());
            statement.setString(2, match.getTeamB().getName());
            statement.setInt(3, match.getOvers());
            statement.setString(4, match.getResult());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all matches from the database
    public static List<Match> getAllMatches() {
        List<Match> matches = new ArrayList<>();
        try (Connection connection = JDBC_connect.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM matches");
             ResultSet resultSet = statement.executeQuery()) {
    
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matches;
    }
    
}

