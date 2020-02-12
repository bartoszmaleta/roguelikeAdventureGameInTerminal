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
        addElementToBoard(new Water(createCoordList(1, width - 1, 1, height - 1)));
        addElementToBoard(new Grass(createShape(10, 8, 15)));
        addElementToBoard(new Grass(createShape(3, 18, 5)));
        addElementToBoard(new Grass(createShape(80, 13, 8)));
        addElementToBoard(new Grass(createShape(61, 13, 5)));
        addElementToBoard(new Grass(createShape(50, 13, 5)));
        addElementToBoard(new Grass(createShape(40, 13, 5)));
        addElementToBoard(new Grass(createShape(30, 13, 5)));
        addElementToBoard(new Grass(createShape(20, 13, 5)));
        addElementToBoard(new Bridge(createCoordList(18, 19, 24, 24)));
        addElementToBoard(new Bridge(createCoordList(16, 17, 8, 8)));
        addElementToBoard(new Bridge(createCoordList(103, 107, 13, 13)));
        addElementToBoard(new Bridge(createCoordList(66, 75, 12, 14)));
        addElementToBoard(new Border(new ArrayList<>(), height, width));
    }

    public void addElementToBoard(Sprite sprite) {
        boardList.add(sprite);
    }


    public void putPlayerOnBoard(Sprite player) {
        addElementToBoard(player);
    }

    public void updateBoard() {
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
        updateBoard();

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

    private List<Coordinates> createCoordList(int xFrom, int xTo, int yFrom, int yTo) {
        List<Coordinates> list = new ArrayList<>();

        for (int i = xFrom; i <= xTo; i++) {
            for (int j = yFrom; j <= yTo; j++) {

                list.add(new Coordinates(i, j));
            }
        }

        return list;
    }

    private List<Coordinates> createShape(int xCenter, int yCenter, int r) {
        List<Coordinates> list = new ArrayList<>();

        int adder = 0;

        for (int y = yCenter - r; y <= yCenter; y++) {
            for (int x = xCenter - adder; x <= xCenter + adder; x++) {
                if (x >= 1 && y >= 1 && x < width && y < height) {
                    list.add(new Coordinates(x, y));
                }
            }
            adder++;
        }

        adder = 0;

        for (int y = yCenter + r; y > yCenter; y--) {
            for (int x = xCenter - adder; x <= xCenter + adder; x++) {
                if (x >= 1 && y >= 1 && x < width && y < height) {
                    list.add(new Coordinates(x, y));
                }
            }
            adder++;
        }

        return list;
    }
}

