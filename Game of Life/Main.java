import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        GameOfLife gl = new GameOfLife(rows, cols);
        int ticks = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < rows; i++) {
            String row = sc.nextLine();
            for(int j = 0; j < cols; j++) {
                char cell = row.charAt(j);
                if(cell == '#') {
                    gl.addCell(i+1, j+1, true);
                }
            }
        }
        gl.evolve(ticks);
        System.out.println();
        boolean[][] board = gl.getState();
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                if(board[i][j]) System.out.print("#");
                else System.out.print(".");
            }
            System.out.println();
        }
        sc.close();
    }
}