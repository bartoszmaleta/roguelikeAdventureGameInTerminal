package app.board;

import app.structures.Grass;
import app.structures.Structure;

public class Board {

    private Object[][] board;
    private String level;

    public Board(String level, int height, int width) {
        board = new Object[height][width];
        this.level = level;
        fillBoard();
    }

    public void fillBoard() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                board[y][x] = new Object();
            }
        }
    }

    public void growGrass() {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                board[y][x] = new Grass(x, y);
            }
        }
    }

    public void printBoard() {
        String output = "";
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x] instanceof Grass) {
                    output += ((Grass)board[y][x]).getApparel();
                }
            }
            System.out.println(output);
        }
    }

}
