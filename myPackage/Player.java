// package myPackage;

// public class Player {
//     private String name;
//     private boolean isBatsman;
//     private boolean isBowler;
//     private boolean isOnStrike;
//     public String teamName;

//     public Player(String name, boolean isBatsman, boolean isBowler,String teamName) {
//         this.name = name;
//         this.isBatsman = isBatsman;
//         this.isBowler = isBowler;
//         // this.isOnStrike = false;
//         this.teamName=teamName;
//     }

//     public String getName() {
//         return name;
//     }

//     public boolean isBatsman() {
//         return isBatsman;
//     }

//     public boolean isBowler() {
//         return isBowler;
//     }

//     public boolean isOnStrike() {
//         return isOnStrike;
//     }

//     public void setOnStrike(boolean onStrike) {
//         isOnStrike = onStrike;
//     }

//     @Override
//     public String toString() {
//         return "\nPlayer Name: " + name + 
//                 ", Is Batsman: " + isBatsman + 
//                 ", Is Bowler: " + isBowler;                
//                 // ", Is On Strike: " + isOnStrike;
//     }
// }




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



