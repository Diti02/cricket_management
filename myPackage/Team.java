package myPackage;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;
    public int currentBatsmanIndex;
    public int currentBowlerIndex;
    public int totalRuns;
    public int wickets;

    public Team(String name, ArrayList<Player> players) {
        this.name = name;
        this.players = players;
        this.totalRuns = 0;
        this.wickets = 0;
        
    }
    public String getName() {
        return name;
    }

    public void rotateStrike() {
        // Rotate the strike between the current batsman and non-striker
        players.get(currentBatsmanIndex).setOnStrike(false);
        currentBatsmanIndex = (currentBatsmanIndex + 1) % players.size();
        players.get(currentBatsmanIndex).setOnStrike(true);
    }
    
    
    public Player getCurrentBatsman() {
        return players.get(currentBatsmanIndex);
    }
    public Player getCurrentBowler() {
        return players.get(currentBowlerIndex);
    }
    public void setNextBatsman() {
        currentBatsmanIndex++; // Move to the next player as the batsman
        if (currentBatsmanIndex >= players.size()) {
            currentBatsmanIndex = 0; // Wrap around to the beginning if reached the end
        }
    }
    public void setNextBowler() {
        
        currentBowlerIndex++; // Move to the next player as the bowler
        if (currentBowlerIndex >= players.size()) {
            currentBowlerIndex = 0; // Wrap around to the beginning if reached the end
        }
    }
    public int getTotalRuns() {
        return totalRuns;
    }

    public void updateScore(int runs) {
        totalRuns += runs;
    }

    
    

    
    @Override
    public String toString() {
        return 
                "\n" + players ;
    }
}