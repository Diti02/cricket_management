import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import myPackage.Player;

public class PlayerDAO {
    public static void insertPlayer(Player player) {
        try (Connection connection = JDBC_connect.getConnection();
              PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO players (name, isBatsman, isBowler, teamName) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, player.getName());
            statement.setBoolean(2, player.isBatsman());
            statement.setBoolean(3, player.isBowler());
            statement.setString(4, player.teamName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
