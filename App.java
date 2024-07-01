import myPackage.*;
import java.util.ArrayList;


class App {
    public static void main(String[] args) throws InvalidTeamException {      
        
        // Create Team objects
        Team teamA = new Team("India", "TeamA.txt");
        TeamDAO.insertTeam(teamA);        
        Team teamB = new Team("Australia", "TeamB.txt");
        TeamDAO.insertTeam(teamB);
        
        System.out.println("Team A:");        
        System.out.println(teamA);

        System.out.println("\nTeam B:");
        System.out.println(teamB);

        // Insert players into the database
        ArrayList<Player> teamAPlayers=teamA.getPlayers();
        for (Player player : teamAPlayers) {
            PlayerDAO.insertPlayer(player);
        }
        ArrayList<Player> teamBPlayers=teamB.getPlayers();
        for (Player player : teamBPlayers) {
            PlayerDAO.insertPlayer(player);
        }
        // Start the match
        Match match = new Match(teamA, teamB, 10); 
        match.simulateMatch();
        MatchDAO.insertMatch(match);
    }
}