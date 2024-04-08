package myPackage;


public class Player {
    private int playerId;
    private String name;
    private boolean isBatsman;
    private boolean isBowler;
    private boolean isWicketKeeper;
    private int teamId;
    private String teamName;

    public Player(int playerId, String name, boolean isBatsman, boolean isBowler, boolean isWicketKeeper, int teamId, String teamName) {
        this.playerId = playerId;
        this.name = name;
        this.isBatsman = isBatsman;
        this.isBowler = isBowler;
        this.isWicketKeeper = isWicketKeeper;
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

    public boolean isWicketKeeper() {
        return isWicketKeeper;
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
                "\nName: " + name +
                "\nIs Batsman: " + isBatsman +
                "\nIs Bowler: " + isBowler +
                "\nIs Wicket Keeper: " + isWicketKeeper +
                "\nTeam ID: " + teamId +
                "\nTeam Name: " + teamName;
    }
}



