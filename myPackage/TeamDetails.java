package myPackage;

interface TeamDetails{
    public String getName();
    public int getTotalRuns();
    public int getWicketsFell();
    public int getcurrentBatsmanIndex();
    public int getcurrentBowlerIndex();
    public void updateScore(int runs);
    public void updateWicketsFell(int wickets);
    public void setCurrentBatsmanIndex(int currentBatsmanIndex);
    public void setCurrentBowlerIndex();
    public Player getCurrentBatsman();
    public Player getCurrentBowler();
    public void setNextBatsman();
    public void setNextBatsman(int IsNotOnStrike);
    public void setNextBowler();
    public Player getIsNotOnStrike();
    public int getIsNotOnStrikeIndex();
    public int getnextToBeNotOnStrike();
    public void setIsNotOnStrikeIndex(int IsNotOnStrike);
    public void setnextToBeNotOnStrike();
}