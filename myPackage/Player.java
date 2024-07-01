package myPackage;


public class Player {
    private static int playerCount=1;
    private int playerId;
    private String name;
    public boolean isBatsman;
    public boolean isBowler;
    private int teamId;
    private String teamName;
    //Constructor written for testing
    public Player(String name, boolean isBatsman, boolean isBowler,String teamName) {
        this.playerId=playerCount++;
        this.name = name;
        this.isBatsman = isBatsman;
        this.isBowler = isBowler;
        this.teamName=teamName;
        
    }
    public Player(int playerId, String name, boolean isBatsman, boolean isBowler, int teamId, String teamName) {
        this.playerId = playerId;
        this.name = name;
        this.isBatsman = isBatsman;
        this.isBowler = isBowler;
        this.teamId = teamId;
        this.teamName = teamName;
        
    }
    

    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public boolean isBatsman() {
        return isBatsman;
    }

    public boolean isBowler() {
        return isBowler;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    

    @Override
    public String toString() {
        return "\nPlayer ID: " + playerId +
                " Name: " + name +
                " Is Batsman: " + isBatsman +
                " Is Bowler: " + isBowler;
                
                
    }
}



