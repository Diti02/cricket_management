import myPackage.*;
import java.util.ArrayList;
// import java.util.Random;
import java.util.List;


class App {
    public static void main(String[] args) {
        
        // Create players for Team A
        Player player1 = new Player("Rohit Sharma", true, false,"India");
        Player player2 = new Player("Virat Kohli", true, false,"India");
        Player player3 = new Player("Ashwin", false, true,"India");
        Player player4 = new Player("Shami", false, true,"India");
        Player player5 = new Player("Gill", true, false,"India");
        Player player6 = new Player("Rishav Pant", true, true,"India");
        Player player7 = new Player("Rinku", true, false,"India");
        Player player8 = new Player("Verma", true, false,"India");
        Player player9 = new Player("Bumbrah", false, true,"India");
        Player player10 = new Player("Ravindra Jadeja", true, true,"India");
        Player player11 = new Player("KL Rahul", true, false,"India");
        
        ArrayList<Player> teamAPlayers = new ArrayList<>();
        // Add players to teamAPlayers 
        teamAPlayers.add(player1);
        teamAPlayers.add(player2);
        teamAPlayers.add(player3);
        teamAPlayers.add(player4);
        teamAPlayers.add(player5);
        teamAPlayers.add(player6);
        teamAPlayers.add(player7);
        teamAPlayers.add(player8);
        teamAPlayers.add(player9);
        teamAPlayers.add(player10);
        teamAPlayers.add(player11);

        // Create players for Team B
        Player player1b = new Player("David Warner", true, false, "Australia");
        Player player2b = new Player("Aaron Finch", true, false, "Australia");
        Player player3b = new Player("Josh", false, true, "Australia");
        Player player4b = new Player("Adam", false, true, "Australia");
        Player player5b = new Player("Steve Smith", true, false, "Australia");
        Player player6b = new Player("Mitchell", true, true, "Australia");
        Player player7b = new Player("Glenn Maxwell", true, false, "Australia");
        Player player8b = new Player("Marcus Stoinis", true, false, "Australia");
        Player player9b = new Player("Alex", false, true, "Australia");
        Player player10b = new Player("Pat", true, true, "Australia");
        Player player11b = new Player("Labuschagne", true, false, "Australia");
        ArrayList<Player> teamBPlayers = new ArrayList<>();
        
        // Add players to teamBPlayers 
        teamBPlayers.add(player1b);
        teamBPlayers.add(player2b);
        teamBPlayers.add(player3b);
        teamBPlayers.add(player4b);
        teamBPlayers.add(player5b);
        teamBPlayers.add(player6b);
        teamBPlayers.add(player7b);
        teamBPlayers.add(player8b);
        teamBPlayers.add(player9b);
        teamBPlayers.add(player10b);
        teamBPlayers.add(player11b); 
        // Create TeamA objects
        Team teamA = new Team("India", teamAPlayers);
         // Create TeamB objects
        Team teamB = new Team("Australia", teamBPlayers);
        
        System.out.println("Team A:");        
        System.out.println(teamA);

        System.out.println("\nTeam B:");
        System.out.println(teamB);

        // Insert teams into the database
        TeamDAO.insertTeam(teamA);
        TeamDAO.insertTeam(teamB);


        // Insert players into the database
        for (Player player : teamAPlayers) {
            PlayerDAO.insertPlayer(player);
        }

        // Insert players into the database
        for (Player player : teamBPlayers) {
            PlayerDAO.insertPlayer(player);
        }
        // Start the match
        Match match = new Match(teamA, teamB, 10, ""); 
        match.simulateMatch();
        if(match.flag==true){
            match.result=match.result + " won by " + (match.teamARuns-match.teamBRuns) + " runs ";
        }
        else{
            match.result=match.result + " won by " + (match.teamBRuns-match.teamARuns)+ " runs ";
        }
        MatchDAO.insertMatch(match);
        

        List<Match> matches = MatchDAO.getAllMatches();

        // Display the retrieved matches
        for (Match retrievedMatch : matches) {
            System.out.println(retrievedMatch);
        }

        
    }
}