package myPackage;

import java.util.ArrayList;


public class Team implements TeamDetails{
    private String name;
    private ArrayList<Player> players;
    private int totalRuns;
    private int wicketsFell;
    private int currentBatsmanIndex;
    private int currentBowlerIndex;
    

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
        return currentBatsmanIndex;
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

    public void setCurrentBatsmanIndex(int currentBatsmanIndex) {
        this.currentBatsmanIndex = (currentBatsmanIndex + 1) % 11;
    }

    public void setCurrentBowlerIndex(int currentBowlerIndex) {
        this.currentBowlerIndex = (currentBowlerIndex + 1) % 11;
    }
 
    

    
    @Override
    public String toString() {
        return 
                "\n" + players ;
    }
}