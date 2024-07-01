import java.sql.*;
import myPackage.Player;

public abstract class PlayerDAO {
    public static void insertPlayer(Player player) {
        try (Connection connection = JDBC_connect.getConnection()) {
            // Check if the player with the same name and team does not exist then insert
            if (!playerExists(connection, player.getName(), player.getTeamName())) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO player (playername, isbatsman, isbowler, teamName) VALUES (?, ?, ?, ?)")) {
                    statement.setString(1, player.getName());
                    statement.setBoolean(2, player.isBatsman());
                    statement.setBoolean(3, player.isBowler());
                    statement.setString(4, player.getTeamName());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to check if a player with the same name and team exists in the database
    private static boolean playerExists(Connection connection, String playerName, String teamName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT COUNT(*) FROM player WHERE playername = ? AND teamName = ?")) {
            statement.setString(1, playerName);
            statement.setString(2, teamName);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        }
    }
}