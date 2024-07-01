package myPackage;

import java.util.*;
public class Match {
    private static int matchIDCounter = 1; // Start matchID from 1
    private int matchID;
    private Team teamA;
    private Team teamB;
    private int oversTotal;
    private int winner;// -1 for tie, 0 for teamA, 1 for teamB

    public Match(Team teamA, Team teamB, int oversTotal) {
        this.matchID=matchIDCounter++;
        this.teamA = teamA;
        this.teamB = teamB;
        this.oversTotal = oversTotal;
        this.winner=-1;
    }

    public int getWinner(){
        return winner;
    }

    public int toss(){
        Random random = new Random();
        return random.nextInt(2);
    }
    public Team getTeamA(){
        return this.teamA;
    }
    public Team getTeamB(){
        return this.teamB;
    }
    public int getOvers(){
        return this.oversTotal;
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
        
        System.out.println("Batting Team:" + battingTeam.getName() + "\n" + "Bowling Team:" + bowlingTeam.getName());
        //All overs for 1st batting team
        for (int i = 1; i <= oversTotal; i++) {
            System.out.println("Over " + i + ":");
            simulateOver(battingTeam, bowlingTeam);
            if (battingTeam.getWicketsFell() == 10) {
                break;
            }           
        }
        System.out.println("Runs scored by : "+battingTeam.getName()+":"+ battingTeam.getTotalRuns()+ ", Wickets: "+ battingTeam.getWicketsFell());
        
        System.out.println("\nBatting Team:" + bowlingTeam.getName() + "\n" + "Bowling Team:" + battingTeam.getName());
        int matchEnd=0;
        //All overs for 2nd batting team
         for (int i = 1; i <= oversTotal; i++) {
           System.out.println(bowlingTeam.getName()+" requires: "+(battingTeam.getTotalRuns()-bowlingTeam.getTotalRuns())+ "runs to win");
            System.out.println("Over " + i + ":");
            simulateOver(bowlingTeam, battingTeam);

            //Won by wickets or Won by runs
            if ( bowlingTeam.getWicketsFell() == 10 || bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()) {
                System.out.println("Match finished!");
                matchEnd=1;
                
                
                if(bowlingTeam.getWicketsFell() == 10 ){
                    winner=0;
                    System.out.println(battingTeam.getName() + " total runs: " + teamA.getTotalRuns());
                    System.out.println(bowlingTeam.getName() + " total runs: " + bowlingTeam.getTotalRuns());
                    System.out.println(battingTeam.getName()+" wins the match ! \n");
                }
                else if(bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()){
                    winner=1;
                    System.out.println(bowlingTeam.getName() + " total runs: " + bowlingTeam.getTotalRuns());
                    System.out.println(bowlingTeam.getName()+" wins the match by "+(battingTeam.getWicketsFell()-bowlingTeam.getWicketsFell())+" wickets!");
                }
                break;
            }                      
        }  
        if(matchEnd==0){  //matchEnd is used to check whether previously match has been ended and result has been displayed or not  
        printMatchResult();
        }
        
    }

    private void rotateStrike(Player currentBatsman, Team battingTeam){
        int currentBatsmanIndex = battingTeam.getcurrentBatsmanIndex();
        int NotOnStrikeIndex = battingTeam.getIsNotOnStrikeIndex();
        
        // Swap the indices of current batsman and batsman on strike
        battingTeam.setCurrentBatsmanIndex(NotOnStrikeIndex);
        battingTeam.setIsNotOnStrikeIndex(currentBatsmanIndex);
        
        // Update the current batsman
        currentBatsman = battingTeam.getCurrentBatsman();
        
        System.out.println("Current batsman: " + currentBatsman.getName() + " & " + "Non-Striker: " + battingTeam.getIsNotOnStrike().getName());
    }
    

   private void simulateOver(Team battingTeam, Team bowlingTeam) {
        Random random = new Random();
        int Totalrun=0;     
         // Get the current batsman
         Player currentBatsman = battingTeam.getCurrentBatsman();
        
         // Get the current bowler
         Player currentBowler = bowlingTeam.getCurrentBowler();
     
         System.out.println("\nCurrent batsman: " + currentBatsman.getName() + " & " + "Non-Striker: "+ battingTeam.getIsNotOnStrike().getName());
        // System.out.println("\nCurrent batsman: " + currentBatsman.getName());
         System.out.println("Current bowler: " + currentBowler.getName());   
        for (int ball = 1; ball <= 6; ball++) {
            int runs = random.nextInt(8); //0-6 for runs, 7 for wicket
            
            if (runs == 0) {
                System.out.println("Ball " + ball + ": " + battingTeam.getName() + " scores no run.");
                
            } 
            else if (runs == 7) {//random number 7 for wicket
                battingTeam.updateWicketsFell(1);
                System.out.println("Ball " + ball + ": " + battingTeam.getName() + " 1 wicket fell");
                currentBatsman = battingTeam.getCurrentBatsman();
                System.out.println(currentBatsman.getName() + " is out! ");               
                
                if(battingTeam.getWicketsFell()!=10){
                    
                    battingTeam.setNextBatsman(battingTeam.getnextToBeNotOnStrike());
                    battingTeam.setnextToBeNotOnStrike();
                    currentBatsman = battingTeam.getCurrentBatsman(); // Update the current batsman
                    System.out.println(currentBatsman.getName()+" comes to bat");
                    System.out.println("Current batsman: " + currentBatsman.getName() + " & " + "Non-Striker: "+ battingTeam.getIsNotOnStrike().getName() );
                    
                    
                    
                   
                }
            } 
            
            else {
                System.out.println("Ball " + ball + ": " + battingTeam.getName() + " scores " + runs + " runs.");
                if(runs==1 || runs==3 || runs==5){
                    System.out.println("Strike Changed extra 1 run taken");
                    rotateStrike(currentBatsman, battingTeam);                    
                    Totalrun+=1;
                }
                Totalrun+=runs;
                battingTeam.updateScore(runs);
            }          
            if (battingTeam.getWicketsFell()==10) {
                break;
            }
            bowlingTeam.setNextBowler();
        }

        System.out.println("End of Over: " + battingTeam.getName());
        System.out.println("Runs scored: "+Totalrun);
        System.out.println("Wickets Fell "+battingTeam.getName()+" :"+ battingTeam.getWicketsFell() +"\n");
    }

    private void printMatchResult() {
        System.out.println("Match finished!");
        System.out.println(teamA.getName() + " total runs: " + teamA.getTotalRuns());
        System.out.println(teamB.getName() + " total runs: " + teamB.getTotalRuns());

        if (teamA.getTotalRuns() > teamB.getTotalRuns()) {
            winner=0;
            System.out.println(teamA.getName() + " wins the match by "+ (teamA.getTotalRuns()-teamB.getTotalRuns()) +" runs!");
        } else if (teamA.getTotalRuns() < teamB.getTotalRuns()) {
            winner=1;
            System.out.println(teamB.getName() + " wins the match by "+ (teamB.getTotalRuns()-teamA.getTotalRuns())+" runs!");
        } else {
            winner=-1;
            System.out.println("The match ended in a tie!");
        }
    }
}