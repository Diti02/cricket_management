import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import myPackage.Team;

public class TeamDAO {
    public static void insertTeam(Team team) {
        try (Connection connection = JDBC_connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO teams (name) VALUES (?)")) {
            statement.setString(1, team.getName());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
