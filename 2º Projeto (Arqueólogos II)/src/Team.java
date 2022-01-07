/**
 * Deals with each team
 * Stores the archaeologists/team members
 */
public class Team {
    // Instance variables
    private String teamName;
    private Archaeologist[] teamMembers;
    private int index;

    /**
     * Constructor
     * 
     * @param teamName    the name of the team
     * @param teamMembers array with all the team members' names
     * @pre {@code teamName != null && teamMembers != null}
     */
    public Team(String teamName, String[] teamMembers) {
        this.teamName = teamName;
        this.teamMembers = new Archaeologist[teamMembers.length];
        for (int i = 0; i < teamMembers.length; i++) {
            this.teamMembers[i] = new Archaeologist(teamMembers[i]);
        }
        this.index = 0;
    }

    /**
     * @return the team's name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @return the sum of all the licensed teams' archaeologists' merit
     */
    public int getTeamMerit() {
        int teamMerit = 0;
        for (int i = 0; i < teamMembers.length; i++) {
            if (teamMembers[i].hasLicense()) {
                teamMerit += teamMembers[i].getMerit();
            }
        }
        return teamMerit;
    }

    /**
     * Returns the status of the team
     * 
     * @return true if all the team members have been disqualified,
     *         otherwise return false
     */
    public boolean allMembersDisqualified() {
        return this.getNMemDisqualified() == teamMembers.length;
    }

    /**
     * @return number of qualified members
     */
    public int getNMemQualified() {
        return teamMembers.length - this.getNMemDisqualified();
    }

    /**
     * @return number of disqualified members
     */
    public int getNMemDisqualified() {
        int nMembers = 0;
        for (int i = 0; i < teamMembers.length; i++) {
            if (!teamMembers[i].hasLicense()) {
                nMembers++;
            }
        }
        return nMembers;
    }

    /**
     * Return the name of the Star Member.
     * 
     * The Star Member is the member with the most merit.
     * 
     * If two members have the same merit, then it choses which one
     * has the lowest number of penalties.
     * 
     * If they both still have the same number of penalties, then it choses
     * the more alphabetical higher name
     * 
     * @pre {@code !allMembersDisqualified()}
     * @return the name of the Star Member
     */
    public String getStarMember() {
        Archaeologist starMember = null;
        for (int i = 0; i < teamMembers.length; i++) {
            if (starMember == null && teamMembers[i].hasLicense()) {
                starMember = teamMembers[i];
            } else if (starMember != null && teamMembers[i].hasLicense()) {
                if (starMember.getMerit() < teamMembers[i].getMerit()) {
                    starMember = teamMembers[i];
                } else if (starMember.getMerit() == teamMembers[i].getMerit()) {
                    if (starMember.getPenalties() > teamMembers[i].getPenalties()) {
                        starMember = teamMembers[i];
                    } else if (starMember.getPenalties() == teamMembers[i].getPenalties() &&
                            starMember.getName().compareTo(teamMembers[i].getName()) > 0) {
                        starMember = teamMembers[i];
                    }
                }
            }
        }
        return starMember.getName();
    }

    /**
     * Return an Archaeologist object and push index to the next
     * member avaiable to dig
     * 
     * @return Archaeologist object of the next member qualified to dig
     */
    public Archaeologist getArchaeologistToDig() {
        Archaeologist toReturn = teamMembers[index];
        do {
            index++;
            if (index >= teamMembers.length) {
                index = 0;
            }
        } while (!teamMembers[index].hasLicense());
        return toReturn;
    }
}