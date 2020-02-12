package app.board;

import app.Coordinates;
import app.helpers.Helpers;
import app.structures.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    Helpers helpers = new Helpers();

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
        arrayTypeBoard = new Sprite[height][width];
        Border border = new Border(new ArrayList<>());
        addElementToBoard(border);
        putGrassOnBoard();
        putBigBridgeOnBoard();
        putLakeOnBoard();
    }

    public void addElementToBoard(Sprite sprite) {
        boardList.add(sprite);
    }

    public void putGrassOnBoard() {
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                List<Coordinates> coords = new ArrayList<>();
                coords.add(new Coordinates(x, y));
                Grass grass = new Grass(coords);
                addElementToBoard(grass);
            }
        }
    }

    public void putPlayerOnBoard(Sprite player) {
        addElementToBoard(player);
    }

    public void putBigBridgeOnBoard() {
        List<Coordinates> bigBridgeCoordinates = new ArrayList<>();
        for (int y = 12; y <= 14; y++) {
            for (int x = 67; x <= 76; x++) {
                bigBridgeCoordinates.add(new Coordinates(x, y));
            }
        }
        Bridge bigBridge = new Bridge(bigBridgeCoordinates);
        addElementToBoard(bigBridge);
    }

    public void putLakeOnBoard() {
        List<Coordinates> lakeCoordinates = new ArrayList<>();
        for (int y = 5; y <= 7; y++) {
            for (int x = 5; x <= 10; x++) {
                lakeCoordinates.add(new Coordinates(x, y));
            }
        }
        Water lake = new Water(lakeCoordinates);
        addElementToBoard(lake);
    }

    public void makePrintableBoard() {
        for (Sprite sprite : boardList) {
            List<Coordinates> spriteCoordinatesList = sprite.getCoordinatesList();
            for (Coordinates spriteCoordinates : spriteCoordinatesList) {
                int x = spriteCoordinates.getX();
                int y = spriteCoordinates.getY();
                arrayTypeBoard[y][x] = sprite;
            }
        }
    }

    public void printBoard() {
        makePrintableBoard(); // update board

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
