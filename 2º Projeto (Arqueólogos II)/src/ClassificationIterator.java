/** 
* Iterates trough an array of type Team (teams)
* Sorts each team according to what is commented in the method sort()
*/
public class ClassificationIterator {
    // Instance variables
    private Team[] teams;
    private int size;
    private int counter;

    /**
     * Constructor
     * 
     * @param teams array of teams
     */
    public ClassificationIterator(Team[] teams, int size) {
        this.size = size;
        this.counter = 0;
        copyArray(teams);
        sort();
    }

    /**
     * Checks if there is a next element
     * 
     * @return true if there's a next element
     */
    public boolean hasNext() {
        return counter < size;
    }

    /**
     * @return the next Team
     */
    public Team next() {
        return teams[counter++];
    }

    /**
     * @param teams copy of the original array (teams)
     * @pre {@code newTeams != null}
     */
    private void copyArray(Team[] teams) {
        this.teams = new Team[size];
        for (int i = 0; i < size; i++) {
            this.teams[i] = teams[i];
        }
    }

    /**
     * @param i position on the array (teams)
     * @param j position on the array (teams) + 1
     */
    private void variableChange(int i, int j) {
        Team tmp = teams[i];
        teams[i] = teams[j];
        teams[j] = tmp;
    }

    /**
     * Sorts the teams by descending order of their merit.
     * 
     * If they have the same merit, sorts the teams by ascending order of
     * disqualified members.
     * 
     * If they have the same number of disqualified members, sorts the teams by
     * ascending order of qualified members.
     * 
     * If they have the same number of qualified members, sorts the teams by
     * alphabetical order.
     */
    private void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (teams[i].getTeamMerit() < teams[j].getTeamMerit()) {
                    variableChange(i, j);
                } else if (teams[i].getTeamMerit() == teams[j].getTeamMerit()) {
                    if (teams[i].getNMemDisqualified() > teams[j].getNMemDisqualified()) {
                        variableChange(i, j);
                    } else if (teams[i].getNMemDisqualified() == teams[j].getNMemDisqualified()) {
                        if (teams[i].getNMemQualified() > teams[j].getNMemQualified()) {
                            variableChange(i, j);
                        } else if (teams[i].getNMemQualified() == teams[j].getNMemQualified()) {
                            if (teams[i].getTeamName().compareTo(teams[j].getTeamName()) > 0) {
                                variableChange(i, j);
                            }
                        }
                    }
                }
            }
        }
    }
}