package myPackage;

public class Player {
    private String name;
    private boolean isBatsman;
    private boolean isBowler;
    private boolean isOnStrike;

    public Player(String name, boolean isBatsman, boolean isBowler) {
        this.name = name;
        this.isBatsman = isBatsman;
        this.isBowler = isBowler;
        this.isOnStrike = false;
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

    public boolean isOnStrike() {
        return isOnStrike;
    }

    public void setOnStrike(boolean onStrike) {
        isOnStrike = onStrike;
    }

    @Override
    public String toString() {
        return "\nPlayer Name: " + name + 
                ", Is Batsman: " + isBatsman + 
                ", Is Bowler: " + isBowler;
                // ", Is On Strike: " + isOnStrike;
    }
}