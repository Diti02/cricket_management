package myPackage;


import java.util.*;
public class Match {
    private Team teamA;
    private Team teamB;
    private int overs; 

    public Match(Team teamA, Team teamB, int overs) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.overs = overs;
    }

    public void simulateMatch() {
        System.out.println("\nMatch between " + teamA.getName() + " and " + teamB.getName() + " started!");
        
        System.out.println("Batting Team:" + teamA.getName() + "\n" + "Bowling Team:" + teamB.getName());
        for (int i = 0; i < overs; i++) {
            System.out.println("Over " + (i + 1) + ":");
            simulateOver(teamA, teamB);
            if (teamA.wickets==10) {
                break;
            }
           
        }
        System.out.println("Runs scored by Team A: "+teamA.totalRuns+ ", Wickets: "+ teamA.wickets);
        
        System.out.println("\n \nBatting Team:" + teamB.getName() + "\n" + "Bowling Team:" + teamA.getName());
         int f=1;
         for (int i = 0; i < overs; i++) {
           System.out.println("Team B requires: "+(teamA.totalRuns-teamB.totalRuns)+ "runs to win");
            System.out.println("Over " + (i + 1) + ":");
            simulateOver(teamB, teamA);
            if (teamB.wickets>teamA.wickets) {
                 System.out.println("Team A  wins the match ! ");
                 f=0;
                 break;
            }
            if(teamB.totalRuns>teamA.totalRuns){
                System.out.println("Team B wins the match ! ");
                 f=0;
                 break;
            }
        }
        
        if(f==1){
        printMatchResult();
        }
    }

   private void simulateOver(Team battingTeam, Team bowlingTeam) {
        Random random = new Random();
        int sum=0;
        // Get the current batsman
        Player currentBatsman = battingTeam.getCurrentBatsman();
        
        // Get the current bowler
        Player currentBowler = bowlingTeam.getCurrentBowler();
        
        System.out.println("Current batsman: " + currentBatsman.getName());
        System.out.println("Current bowler: " + currentBowler.getName());
        
        for (int ball = 0; ball < 6; ball++) {
            int runs = random.nextInt(8); 

            if (runs == 0) {
                System.out.println("Ball " + (ball + 1) + ": " + battingTeam.getName() + " scores no run.");
                
            } 
            else if (runs == 7) {
                battingTeam.wickets++;
                System.out.println("Ball " + (ball + 1) + ": " + battingTeam.getName() + " 1 wicket fell");
            } 
            else {
                System.out.println("Ball " + (ball + 1) + ": " + battingTeam.getName() + " scores " + runs + " runs.");
                sum+=runs;
                battingTeam.updateScore(runs);
            }
            
            

            if (battingTeam.wickets==10) {
                break;
            }
        }
        bowlingTeam.setNextBowler();

        System.out.println("End of Over: " + battingTeam.getName());
        System.out.println("Run scored: "+sum);
    }

    private void printMatchResult() {
        System.out.println("Match finished!");
        System.out.println(teamA.getName() + " total runs: " + teamA.getTotalRuns());
        System.out.println(teamB.getName() + " total runs: " + teamB.getTotalRuns());

        if (teamA.getTotalRuns() > teamB.getTotalRuns()) {
            System.out.println(teamA.getName() + " wins the match by "+ (teamA.totalRuns-teamB.totalRuns) +"runs!");
        } else if (teamA.getTotalRuns() < teamB.getTotalRuns()) {
            System.out.println(teamB.getName() + " wins the match by "+ (teamB.totalRuns-teamA.totalRuns)+"runs!");
        } else {
            System.out.println("The match ended in a tie!");
        }
    }
}