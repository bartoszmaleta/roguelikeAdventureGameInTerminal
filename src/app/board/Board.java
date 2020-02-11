package app.board;

import app.Coordinates;
import app.structures.Bridge;
import app.structures.Grass;
import app.structures.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Sprite> boardList;
    private String level;
    private int height;
    private int width;
    private Sprite[][] arrayTypeBoard;

    public Board(String level, int height, int width) {
        boardList = new ArrayList<>();
        this.level = level;
        this.height = height;
        this.width = width;
        arrayTypeBoard = makePrintableBoard();
    }

    public void growGrass() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                List<Coordinates> coords = new ArrayList<>();
                Grass grass = new Grass(coords);
                addElementToBoard(grass);
            }
        }
    }

    public void addElementToBoard(Sprite sprite) {
        boardList.add(sprite);
    }

    public Bridge createBigBridge() {
        List<Coordinates> bigBridgeCoordinates = new ArrayList<>();
        for (int y = 12; y <= 14; y++) {
            for (int x = 67; x <= 76; x++) {
                bigBridgeCoordinates.add(new Coordinates(x, y));
            }
        }
        Bridge bigBridge = new Bridge(bigBridgeCoordinates);
        return bigBridge;
    }

    public Sprite[][] makePrintableBoard() {
        for (Sprite sprite : boardList) {
            List<Coordinates> spriteCoordinatesList = sprite.getCoordinatesList();
            for (Coordinates spriteCoordinates : spriteCoordinatesList) {
                int x = spriteCoordinates.getX();
                int y = spriteCoordinates.getY();
                arrayTypeBoard[y][x] = sprite;
            }
        }
        return arrayTypeBoard;
    }

    public void printBoard() {
        Sprite[][] arrayTypeBoard = makePrintableBoard();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(arrayTypeBoard[y][x].getApparel());
            }
            System.out.println();
        }
    }

    public Sprite[][] getArrayTypeBoard() {
        return arrayTypeBoard;
    }

//    public Sprite[][] makePrintableBoard() {
//        Sprite[][] arrayTypeBoard = new Sprite[height][width];
//        int line = 1;
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                arrayTypeBoard[y][x] = board.get(x * line);
//            }
//            line++;
//        }
//        return arrayTypeBoard;

//    }

}
