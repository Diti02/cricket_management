package myPackage;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;
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