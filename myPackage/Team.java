package myPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Team implements TeamDetails{
    private String name;
    private ArrayList<Player> players;
    private int totalRuns;
    private int wicketsFell;
    private int currentBatsmanIndex;
    private int currentBowlerIndex;
    private int IsNotOnStrike;
    private int nextToBeNotOnStrike;
    
    public Team(String name,String fileName) throws InvalidTeamException{
        this.players=new ArrayList<>();
        this.name = name;
        readPlayersFromFile(fileName,players);
        this.totalRuns = 0;
        this.wicketsFell = 0;
        this.currentBatsmanIndex=0;
        this.currentBowlerIndex=0; 
        this.IsNotOnStrike=1;//next index of currentBatsman index   
        this.nextToBeNotOnStrike=2;
        
        
    }

    private void readPlayersFromFile(String fileName, ArrayList<Player> players) throws InvalidTeamException{
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            int playerCount = 0; // Counter to keep track of the number of players read
            
            // Read player data line by line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(","); // Split the line by comma
                
                // Check if the line contains player data
                if (parts.length == 2 ) {
                    String playerName = parts[0]; // Extract player name
                    String playerType = parts[1]; // Extract player type
                    

                    // Create player based on type
                    switch (playerType) {
                        case "Batsman":
                            players.add(new Player(playerName, true, false,this.name));
                            break;
                        case "Bowler":
                            players.add(new Player(playerName, false, true,this.name));
                            break;
                    }

                    playerCount++; // Increment player count
                }

                else if (parts.length == 3 ) {
                    String playerName = parts[0]; // Extract player name
                    String playerType = parts[1]; // Extract player type
                    String playerType2 = parts[2];// Extract player type 2

                    // Create player based on type
                    if((playerType.equals("Batsman") && playerType2.equals("Bowler")) || (playerType.equals("Bowler") && playerType2.equals("Batsman"))){
                        players.add(new Player(playerName, true, true,this.name));
                    }
                    playerCount++; // Increment player count
                }
            }
            scanner.close(); // Close the scanner
            
            // Check if the total number of players is exactly 11
            Validation.validateTeamSize(players);
            // if (playerCount != 11) {
            //     throw new IllegalArgumentException("A team must have exactly 11 players.");
            // }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Team(String name, ArrayList<Player> players) throws InvalidTeamException {
        Validation.validateTeamSize(players);
        // if (players.size() != 11) {
        //     throw new IllegalArgumentException("A team must have exactly 11 players.");
        // }
        this.name = name;
        this.players = players;
        this.totalRuns = 0;
        this.wicketsFell = 0;
        this.currentBatsmanIndex=0;
        this.currentBowlerIndex=0; 
        this.IsNotOnStrike=1;//next index of currentBatsman index   
        this.nextToBeNotOnStrike=2;    
    }
    public ArrayList<Player> getPlayers(){
        return players;
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