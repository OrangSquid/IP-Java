/**
 * Deals with the logic behind the contests and comunicates with
 * the Main class.
 * 
 * Has access to the terrain and all the teams.
 */
public class ContestSystem {
    // Instance Variables
    private Terrain terrain;
    private Team[] teams;
    private int nTeams = 0;
    // Constants
    private static final int TEAMS_DEFAULT_SIZE = 10;
    // Constants for dig method
    private static final int TEAM_OUT = 1;
    private static final int TEAM_INVALID = 2;
    private static final int ALL_OK = 0;

    /**
     * Constructor
     * 
     * @param terrain array with the burried treasure data
     */
    public ContestSystem(int[][] terrain) {
        this.terrain = new Terrain(terrain);
        this.teams = new Team[TEAMS_DEFAULT_SIZE];
    }

    /**
     * Adds a team to the contest with the following parameters
     * 
     * @param teamName
     * @param teamMembers
     * @pre {@code teamName != null && teamMembers != null}
     */
    public void addTeam(String teamName, String[] teamMembers) {
        teams[nTeams++] = new Team(teamName, teamMembers);
    }

    /**
     * @return the burried wealth
     */
    public int getWealth() {
        return terrain.getWealth();
    }

    /**
     * Returns the status of all the teams
     * 
     * @return true if all the teams have been disqualified, otherwise return false
     */
    public boolean allTeamsDisqualified() {
        boolean allDisqualified = true;
        int i = 0;
        while (allDisqualified && i < nTeams) {
            if (!teams[i].allMembersDisqualified()) {
                allDisqualified = false;
            }
            i++;
        }
        return allDisqualified;
    }

    /**
     * @return an iterator in the order of each team's merit
     */
    public ClassificationIterator getClassificationIterator() {
        return new ClassificationIterator(teams, nTeams);
    }

    /**
     * @return a matrix with booleans denoting wheter or not that cell has treasure
     */
    public boolean[][] getTerrainStatus() {
        return terrain.getTerrainStatus();
    }

    /**
     * Returns the name of the star member of the provided team.
     * 
     * If the team doesn't exist it returns an empty string.
     * 
     * @param teamName team name
     * @return name of the star member of the team or an empty string if the
     *         team is not found
     * @pre {@code teamName != null}
     */
    public String getStarMember(String teamName) {
        Team tmpTeam = getTeam(teamName);
        if (getTeam(teamName) != null) {
            return tmpTeam.getStarMember();
        } else {
            return "";
        }
    }

    /**
     * @param teamName team name
     * @return the Team object associated with this teamName
     * @pre {@code teamName != null}
     */
    private Team getTeam(String teamName) {
        Team tmpTeam = null;
        int i = 0;
        while (tmpTeam == null && i < nTeams) {
            if (teams[i].getTeamName().equals(teamName) && !teams[i].allMembersDisqualified()) {
                tmpTeam = teams[i];
            }
            i++;
        }
        return tmpTeam;
    }

    /**
     * Jumps and digs in the new position. Returns an int denoting the new
     * status for the team.
     * 
     * @param jumpX how many lines to jump
     * @param jumpY how many columns to jump
     * @param teamName team name
     * @pre {@code jumpX != 0 && jumpY != 0 && teamName != null}
     * @return int with the status
     */
    public int dig(int jumpX, int jumpY, String teamName) {
        Team playingTeam = getTeam(teamName);
        if (playingTeam == null || playingTeam.allMembersDisqualified()) {
            return TEAM_INVALID;
        }
        Archaeologist playingArchaeologist = playingTeam.getArchaeologistToDig();
        int newPosX = playingArchaeologist.getPositionX() + jumpX;
        int newPosY = playingArchaeologist.getPositionY() + jumpY;
        if (newPosX >= 0 && newPosX < terrain.getNLines() &&
                newPosY >= 0 && newPosY < terrain.getNColumns()) {
                    playingArchaeologist.addMerit(terrain.dig(newPosX, newPosY));
                    playingArchaeologist.setPosition(newPosX, newPosY);
        }
        else {
            playingArchaeologist.disqualify();
            if(playingTeam.allMembersDisqualified()) {
                return TEAM_OUT;
            }
        }
        return ALL_OK;
    }
}