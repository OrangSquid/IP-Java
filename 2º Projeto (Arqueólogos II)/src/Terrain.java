/** 
* Deals with the terrain
* Stores a matrix (terrain)
*/
public class Terrain {
    // Instance variables
    private int[][] terrain;
    private static final int PENALTY = -10;

    /**
     * Constructor
     * 
     * @param terrain matrix of all the burried trasure data
     */
    public Terrain(int[][] terrain) {
        this.terrain = terrain;
    }

    /**
     * @return the number of lines
     */
    public int getNLines() {
        return terrain.length;
    }

    /**
     * @return the number of columns
     */
    public int getNColumns() {
        return terrain[0].length;
    }

    /**
     * Returns a boolean saying if there's any burrried treasure
     * 
     * @param posX
     * @param posY
     * @return true if there's burried treasure, false otherwise
     * @pre {@code 0 <= posX < terrain.lenght && 0 <= posY < terrain[0].length}
     */
    public boolean hasTreasure(int posX, int posY) {
        return terrain[posX][posY] > 0;
    }

    /**
     * @return the sum of all the burried wealth
     */
    public int getWealth() {
        int sumWealth = 0;
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                if (terrain[i][j] > 0) {
                    sumWealth += terrain[i][j];
                }
            }
        }
        return sumWealth;
    }

    /**
     * @return a matrix with booleans denoting wheter or not that cell has treasure
     */
    public boolean[][] getTerrainStatus() {
        boolean[][] toReturn = new boolean[terrain.length][terrain[0].length];
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                toReturn[i][j] = hasTreasure(i, j);
            }
        }
        return toReturn;
    }

    /**
     * Return the value found at {@code terrain[posX][posY]} and set that value
     * to {@code Terrain.PENALTY} or increment by {@code Terrain.PENALTY}
     * 
     * @param posX
     * @param posY
     * @return value of the found treasure
     */
    public int dig(int posX, int posY) {
        int treasureFound = terrain[posX][posY];
        if (treasureFound <= 0) {
            terrain[posX][posY] += PENALTY;
        } else {
            terrain[posX][posY] = PENALTY;
        }
        return treasureFound;
    }
}
