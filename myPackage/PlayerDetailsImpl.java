package myPackage;

public class PlayerDetailsImpl extends Player implements PlayerDetails {
    private int totalRuns;
    private int totalWickets;
    private int maximumRuns;
    private int maximumWickets;
    private int centuries;
    private boolean isOnStrike;

    public PlayerDetailsImpl(int playerId, String name, boolean isBatsman, boolean isBowler,  int teamId, String teamName,
                             int totalRuns, int totalWickets, int maximumRuns, int maximumWickets, int centuries, boolean isOnStrike) {
        super(playerId, name, isBatsman, isBowler, teamId, teamName);
        this.totalRuns = totalRuns;
        this.totalWickets = totalWickets;
        this.maximumRuns = maximumRuns;
        this.maximumWickets = maximumWickets;
        this.centuries = centuries;
        this.isOnStrike = isOnStrike;
    }

    @Override
    public int getTotalRuns() {
        return totalRuns;
    }

    @Override
    public int getTotalWickets() {
        return totalWickets;
    }

    @Override
    public int getMaximumRuns() {
        return maximumRuns;
    }

    @Override
    public int getMaximumWickets() {
        return maximumWickets;
    }

    @Override
    public int getCenturies() {
        return centuries;
    }

    @Override
    public void setTotalRuns(int runs) {
        this.totalRuns+= runs;        
    }

    @Override
    public void setTotalWickets(int wickets) {
        this.totalWickets+= wickets;
    }

    @Override
    public void setMaximumRuns() {
        this.maximumRuns+=totalRuns;
    }

    @Override
    public void setMaximumWickets() {
        this.maximumWickets+=totalWickets;
    }

    @Override
    public void setCenturies() {
        this.centuries+=1;
    }

    @Override
    public boolean isOnStrike() {
        return isOnStrike;
    }
    public void setisOnStrike() {
        this.isOnStrike=!this.isOnStrike;
    }



    @Override
    public String toString() {
        return super.toString() +
                "\nTotal Runs: " + totalRuns +
                "\nTotal Wickets: " + totalWickets +
                "\nMaximum Runs: " + maximumRuns +
                "\nMaximum Wickets: " + maximumWickets +
                "\nCenturies: " + centuries +
                "\nIs On Strike: " + isOnStrike;
    }
}