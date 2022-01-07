import java.lang.reflect.Array;

public class GameOfLife {
    private boolean[][] state; // L+2 linhas, C+2 colunas
    private int rows; // rows guarda L
    private int cols; // cols guarda C

    // Pre: rows > 0 && cols > 0
    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.state = new boolean[rows+2][cols+2];
    }

    // Pre: row >= 0 && row < rows && col >= 0 && col < cols
    public void addCell(int row, int col, boolean isAlive) {
        state[row][col] = isAlive;
    }

    public boolean[][] getState() {
        return state;
    }

    private int countNeighbours(int row, int col) {
        int count = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if((i != 0 || j != 0) && state[row+i][col+j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Pre: ticks >= 0
    public void evolve(int ticks) {
        boolean[][] tmpState = new boolean[rows+2][cols+2];
        for(int i = 0; i < rows; i++) {
            System.arraycopy(state[i], 0, tmpState[i], 0, cols+2);
        }
        for(int i = 0; i < ticks; i++) {
            for(int j = 1; j <= rows; j++) {
                for(int k = 1; k <= cols; k++) {
                    int neighbours = countNeighbours(j, k);
                    if(state[j][k] && (neighbours == 2 || neighbours == 3)) {
                        tmpState[j][k] = true;
                    } else if(!state[j][k] && (neighbours == 3)) {
                        tmpState[j][k] = true;
                    } else {
                        tmpState[j][k] = false;
                    }
                }
            }
            state = tmpState;
            System.out.println();
            for(int j = 1; j <= rows; j++) {
                for(int k = 1; k <= cols; k++) {
                    if(state[j][k]) System.out.print("#");
                    else System.out.print(".");
                }
                System.out.println();
            }
        }
    }
}	