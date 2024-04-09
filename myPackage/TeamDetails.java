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
    public void setCurrentBowlerIndex(int currentBowlerIndex);
    
}