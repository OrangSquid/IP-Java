/**
 * Deals with each archaeologist
 * Stores the archaeologists' name, merit, penalties, license and position on the matrix 
 */
public class Archaeologist {
    // Instance variables
    private String name;
    private int merit;
    private int penalties;
    private int posX, posY;
    private boolean license;

    /**
     * Constructor
     * 
     * @param name archaeologist's name
     */
    public Archaeologist(String name) {
        this.name = name;
        posX = -1;
        posY = -1;
        merit = 0;
        penalties = 0;
        license = true;
    }

    /**
     * @return archaeologist's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return archaeologist's merit
     */
    public int getMerit() {
        return merit;
    }

    /**
     * @return archaeologist's X position
     */
    public int getPositionX() {
        return posX;
    }

    /**
     * @return archaeologist's Y position
     */
    public int getPositionY() {
        return posY;
    }

    /**
     * @return archaeologist has license
     */
    public boolean hasLicense() {
        return license;
    }

    /**
     * @return number of penalties
     */
    public int getPenalties() {
        return penalties;
    }

    /**
     * Adds the found treasure to the archaeologist's merit
     * 
     * @param treasureValue value of the treasure
     *                      the archaeologist has found
     */
    public void addMerit(int treasureValue) {
        if(treasureValue < 0) {
            penalties++;
        }
        merit += treasureValue;
    }

    /**
     * Sets the new position for the archaeologist
     * 
     * @param posX
     * @param posY
     */
    public void setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * Disqualifies the archaeologist
     */
    public void disqualify() {
        this.license = false;
    }
}