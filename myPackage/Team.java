package myPackage;

import java.util.ArrayList;


public class Team implements TeamDetails{
    private String name;
    private ArrayList<Player> players;
    private int totalRuns;
    private int wicketsFell;
    private int currentBatsmanIndex;
    private int currentBowlerIndex;
    private int IsNotOnStrike;
    private int nextToBeNotOnStrike;
    

    public Team(String name, ArrayList<Player> players) {
        if (players.size() != 11) {
            throw new IllegalArgumentException("A team must have exactly 11 players.");
        }
        this.name = name;
        this.players = players;
        this.totalRuns = 0;
        this.wicketsFell = 0;
        this.currentBatsmanIndex=0;
        this.currentBowlerIndex=0; 
        this.IsNotOnStrike=1;//next index of currentBatsman index   
        this.nextToBeNotOnStrike=2;    
    }

    public String getName() {
        return name;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getWicketsFell() {
        return wicketsFell;
    }
    public int getcurrentBatsmanIndex() {
        return this.currentBatsmanIndex;
    }
    public int getcurrentBowlerIndex() {
        return currentBowlerIndex;
    }
    public void updateScore(int runs) {
        totalRuns += runs;
    }
    public void updateWicketsFell(int wickets) {
        wicketsFell += wickets;
    } 

    public void setCurrentBatsmanIndex() {
        this.currentBatsmanIndex = (this.currentBatsmanIndex + 1) % 11;
    } 
    public void setCurrentBatsmanIndex(int current) {
        this.currentBatsmanIndex = current;
    }   

    public void setCurrentBowlerIndex() {
        this.currentBowlerIndex = (this.currentBowlerIndex + 1) % 11;
    }
    
    public Player getCurrentBatsman() {
        return players.get(this.getcurrentBatsmanIndex());
    }
    public Player getCurrentBowler() {
        return players.get(this.getcurrentBowlerIndex());
    }
    public void setNextBatsman() {
        this.currentBatsmanIndex = (this.currentBatsmanIndex + 1) % 11; // Move to the next player as the batsman
    }

    public void setNextBatsman(int nextToBe) {
        this.currentBatsmanIndex = nextToBe; // Move to the next player as the batsman
    }
    
    public void setNextBowler() {        
        setCurrentBowlerIndex() ; // Move to the next player as the bowler
    }
    public int getIsNotOnStrikeIndex(){
        return IsNotOnStrike;
    }
    public Player getIsNotOnStrike(){
        return players.get(IsNotOnStrike);
    }
    public int getnextToBeNotOnStrike(){
        return nextToBeNotOnStrike;
    }

    public void setnextToBeNotOnStrike(){
        this.nextToBeNotOnStrike=(Math.max(currentBatsmanIndex,IsNotOnStrike)+1)%11; //choose the max value of both because it might be the case where strike is rotated
    }
    public void setIsNotOnStrikeIndex(int isNotOnStrike){
        this.IsNotOnStrike=isNotOnStrike;
    }

    
    @Override
    public String toString() {
        return 
                "\n" + players ;
    }
}