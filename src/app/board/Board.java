package app.board;

import app.Coordinates;
import app.Inventory;
import app.creatures.Player;
import app.services.TerminalManager;
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
        arrayTypeBoard = new Sprite[height][width];
        putGrassOnBoard();
        putBigBridgeOnBoard();
    }

    public void addElementToBoard(Sprite sprite) {
        boardList.add(sprite);
    }

    public void putGrassOnBoard() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
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

        System.out.println(TerminalManager.repeatString('X', width));

        for (int y = 0; y < height; y++) {
            System.out.print("X");
            for (int x = 0; x < width; x++) {
                System.out.print(arrayTypeBoard[y][x].getApparel());
            }
            System.out.print("X");
            System.out.println();
        }

        System.out.println(TerminalManager.repeatString('X', width));

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
