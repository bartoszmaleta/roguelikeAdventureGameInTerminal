package app.board;

import app.Formation;
import app.structures.Grass;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Formation> board;
    private String level;
    private int height;
    private int width;

    public Board(String level, int height, int width) {
        board = new ArrayList<>();
        this.level = level;
        this.height = height;
        this.width = width;
        fillBoard();
    }

    public void fillBoard() {
        for (int i = 0; i < width * height; i++) {
            board.add(new Grass (1, 1));
        }
    }


//    public void growGrass() {
//        for (int i = 0; i < width * height; i++) {
//        }
//    }

    public Formation[][] makePrintableBoard() {
        Formation[][] arrayTypeBoard = new Formation[height][width];
        int line = 1;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                arrayTypeBoard[y][x] = board.get(x * line);
            }
            line++;
        }
        return arrayTypeBoard;
    }

    public void printBoard() {
        Formation[][] arrayTypeBoard = makePrintableBoard();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(arrayTypeBoard[y][x].getApparel());
            }
            System.out.println();
        }

//        for (int line = 1; line < height; line++) {
//            for (int i = 0; i < width; i++) {
//                System.out.print(board.get(i).getApparel());
//            }
//            System.out.println();
//        }
    }
}
