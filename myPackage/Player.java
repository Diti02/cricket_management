package myPackage;

public class Player {
    private String name;
    private boolean isBatsman;
    private boolean isBowler;

    public Player(String name, boolean isBatsman, boolean isBowler) {
        this.name = name;
        this.isBatsman = isBatsman;
        this.isBowler = isBowler;
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

    @Override
    public String toString() {
        return "\nPlayer Name: " + name + 
                ", Is Batsman: " + isBatsman + 
                ", Is Bowler: " + isBowler ;
    }
}