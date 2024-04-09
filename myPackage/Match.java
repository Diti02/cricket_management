package myPackage;

import java.util.*;
public class Match {
    private static int matchIDCounter = 1; // Start matchID from 1
    private int matchID;
    private Team teamA;
    private Team teamB;
    private int oversTotal;
    private int TeamARuns;
    private int TeamBRuns;
    private int TeamAWickets;
    private int TeamBWickets;
    private int winner;

    public Match(Team teamA, Team teamB, int oversTotal) {
        this.matchID=matchIDCounter++;
        this.teamA = teamA;
        this.teamB = teamB;
        this.oversTotal = oversTotal;
        this.TeamARuns=0;
        this.TeamBRuns=0;
        this.TeamAWickets=0;
        this.TeamBWickets=0;
        this.winner=-1;
    }

    public int toss(){
        Random random = new Random();
        return random.nextInt(2);
    }

    public void simulateMatch() {
        System.out.println("\nMatch between " + teamA.getName() + " and " + teamB.getName() + " started!\n");

        //Tossing to choose who will bat first
        int tossResult=toss();
        Team battingTeam;
        Team bowlingTeam;

        if(tossResult == 0){
            battingTeam = teamA;
            bowlingTeam = teamB;
        }
        else{
            battingTeam = teamB;
            bowlingTeam = teamA;
        }

        System.out.println("Toss result: " + (tossResult == 0 ? teamA.getName() : teamB.getName()) + " won the toss and chose to bat.");
        
        System.out.println("Batting Team:" + teamA.getName() + "\n" + "Bowling Team:" + teamB.getName());
        for (int i = 0; i < oversTotal; i++) {
            System.out.println("Over " + (i + 1) + ":");
            simulateOver(teamA, teamB);
            if (teamA.wickets==10) {
                break;
            }
           
        }
        System.out.println("Runs scored by Team A: "+teamA.totalRuns+ ", Wickets: "+ teamA.wickets);
        
        System.out.println("\n \nBatting Team:" + teamB.getName() + "\n" + "Bowling Team:" + teamA.getName());
         int f=1;
         for (int i = 0; i < oversTotal; i++) {
           System.out.println("Team B requires: "+(teamA.totalRuns-teamB.totalRuns)+ "runs to win");
            System.out.println("Over " + (i + 1) + ":");
            simulateOver(teamB, teamA);
            if (teamB.wickets>teamA.wickets) {
                System.out.println("Match finished!");
                System.out.println(teamA.getName() + " total runs: " + teamA.getTotalRuns());
                System.out.println(teamB.getName() + " total runs: " + teamB.getTotalRuns());
                System.out.println("\nTeam A  wins the match ! \n");
                 f=0;
                 break;
            }
            if(teamB.totalRuns>teamA.totalRuns){
                System.out.println("Match finished!");
                System.out.println(teamA.getName() + " total runs: " + teamA.getTotalRuns());
                System.out.println(teamB.getName() + " total runs: " + teamB.getTotalRuns());
                System.out.println("\nTeam B wins the match ! \n");
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
        
        for (int ball = 0; ball < 6; ball++) {
            int runs = random.nextInt(8); //0-6 for runs, 7 for wicket

            if (runs == 0) {
                System.out.println("Ball " + (ball + 1) + ": " + battingTeam.getName() + " scores no run.");
                
            } 
            else if (runs == 7) {//random number 7 for wicket
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

        System.out.println("End of Over: " + battingTeam.getName());
        System.out.println("Run scored: "+sum+"\n");
        System.out.println("Wickets "+ battingTeam.wickets +"\n");
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