import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        Scanner fileReader = new Scanner(new FileReader(filename));

        int nBoards = fileReader.nextInt();
        fileReader.nextLine();

        for(int i = 0; i < nBoards; i++) {
            int nLines = fileReader.nextInt();
            int nColums = fileReader.nextInt();
            int winCondition = fileReader.nextInt();
            fileReader.nextLine();
            char[][] board = new char[nLines][nColums];
            for(int j = 0; j < nLines; j++) {
                String line = fileReader.nextLine();
                for(int k = 0; k < nColums; k++) {
                    board[j][k] = line.charAt(k);
                }
            }
            int whoWon = checkWin(board, winCondition);
            if(whoWon == 1) {
                System.out.printf("Jogo %d: ganhou o jogador 1\n", i+1);
            } else if(whoWon == 2) {
                System.out.printf("Jogo %d: ganhou o jogador 2\n", i+1);
            } else {
                System.out.printf("Jogo %d: empate\n", i+1);
            }
        }

        fileReader.close();
        sc.close();
    }

    private static int checkWin(char[][] board, int winCondition) {
        int winningPlayer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int verticalPositions = 0, horizontalPositions = 0, diagonalTopBotPositions = 0, diagonalBotTopPositions = 0;
                for(int k = -winCondition + 1; k < winCondition; k++) {
                    if(i + k >= 0 && i + k < board.length) {
                        if(board[i+k][j] == board[i][j]) {
                            verticalPositions++;
                        } else {
                            verticalPositions = 0;
                        }
                    } 
                    if(j + k >= 0 && j + k < board[0].length) {
                        if(board[i][j+k] == board[i][j]) {
                            horizontalPositions++;
                        } else {
                            horizontalPositions = 0;
                        }
                    } 
                    if(i + k >= 0 && i + k < board.length && j + k >= 0 && j + k < board[0].length) {
                        if(board[i+k][j+k] == board[i][j]) {
                            diagonalTopBotPositions++;
                        } else {
                            diagonalTopBotPositions = 0;
                        }
                    }
                    if(i - k >= 0 && i - k < board.length && j + k >= 0 && j + k < board[0].length) {
                        if(board[i-k][j+k] == board[i][j]){
                            diagonalBotTopPositions++;
                        } else {
                            diagonalBotTopPositions = 0;
                        }
                    }
                    
                }
                if(verticalPositions >= winCondition || horizontalPositions >= winCondition || diagonalTopBotPositions >= winCondition || diagonalBotTopPositions >= winCondition) {
                    if(board[i][j] == 'x' && winningPlayer == 1) {
                        winningPlayer = -1;
                    } else if(board[i][j] == 'o' && winningPlayer == 2) {
                        winningPlayer = -1;
                    } else if(board[i][j] == 'x' && winningPlayer == 0) {
                        winningPlayer = 2;
                    } else if(board[i][j] == 'o' && winningPlayer == 0) {
                        winningPlayer = 1;
                    }
                }
            }
        }
        return winningPlayer;
    }
}