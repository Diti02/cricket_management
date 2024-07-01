package myPackage;


import java.util.ArrayList;
public class Validation {
    public static void validateTeamSize(ArrayList<Player> players) throws InvalidTeamException {
        if (players.size() != 11) {
            throw new InvalidTeamException("A team must have exactly 11 players.");
        }
    }
}


