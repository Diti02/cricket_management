import myPackage.*;
import java.util.ArrayList;
// import java.util.Random;


class App {
    public static void main(String[] args) {      
        
        // Create Team objects
        Team teamA = new Team("India", "TeamA.txt");
        Team teamB = new Team("Australia", "TeamB.txt");
        
        System.out.println("Team A:");        
        System.out.println(teamA);

        System.out.println("\nTeam B:");
        System.out.println(teamB);

        // Start the match
        Match match = new Match(teamA, teamB, 10); 
        match.simulateMatch();
    }
}