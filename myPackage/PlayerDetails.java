package myPackage;

interface PlayerDetails {
    int getPlayerId();
    int getTotalRuns();
    int getTotalWickets();
    int getMaximumRuns();
    int getMaximumWickets();
    int getCenturies();
    boolean isOnStrike();
}
abstract class AbstractPlayerDetails implements PlayerDetails {
    protected int playerId;
    protected int totalRuns;
    protected int totalWickets;
    protected int maximumRuns;
    protected int maximumWickets;
    protected int centuries;
    protected boolean isOnStrike;

    public int getPlayerId() {
        return playerId;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public int getMaximumRuns() {
        return maximumRuns;
    }

    public int getMaximumWickets() {
        return maximumWickets;
    }

    public int getCenturies() {
        return centuries;
    }

    public boolean isOnStrike() {
        return isOnStrike;
    }
}

class DetailedPlayer extends AbstractPlayerDetails {
    public DetailedPlayer(int playerId, int totalRuns, int totalWickets, int maximumRuns, int maximumWickets, int centuries, boolean isOnStrike) {
        this.playerId = playerId;
        this.totalRuns = totalRuns;
        this.totalWickets = totalWickets;
        this.maximumRuns = maximumRuns;
        this.maximumWickets = maximumWickets;
        this.centuries = centuries;
        this.isOnStrike = isOnStrike;
    }
}