package app.board;

import app.Coordinates;

import app.Inventory;
import app.creatures.Creature;
import app.creatures.Monster;
import app.creatures.Player;
import app.services.TerminalManager;
import app.structures.*;

import java.util.ArrayList;
import java.util.List;

// TODO: 
//      - id for all sprites
//      - adding chest inv to playerINV
//      - displayInv for player "i"
//      - removeSprite()
//      - prettyTable for Inv
//      - legenda

public class Board {

    private List<Sprite> boardList;
    private String level;
    private int height;
    private int width;
    private Sprite[][] arrayTypeBoard;
    private Sprite chest1;
    private Monster goblin;


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

        addElementToBoard(new Monster("G", createCoordList(1, 1, 1, 1), "Goblin", 30, new Inventory(), 5, 15));

        putChestOnBoard();
    }

    private void putChestOnBoard() {
        List<Coordinates> chestCoords = new ArrayList<>();
        chestCoords.add(new Coordinates(20, 10));
        chest1 = new Chest(chestCoords);
        boardList.add(chest1);
    }

    public List<Sprite> getBoardList() {
        return boardList;
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
        updateBoard(); // update board

        // System.out.println(TerminalManager.repeatString('X', width));

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(arrayTypeBoard[y][x].getApparel());
            }
            System.out.println();
        }
        
        

        // System.out.println(TerminalManager.repeatString('X', width));
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

    public Chest getChest() {
        Chest chest = (Chest) chest1;
        return chest;
    }

    public void removeAllChestsFromBoardList() {
        // TODO:
        for (Sprite sprite: boardList) {
            if (sprite instanceof Chest) {
                boardList.remove(sprite);  // should be sprite.getID
            }
        }
    }

    public void removeChestFromBoardListByCoords(int x, int y) {
        for (Sprite sprite: boardList) {
            if (sprite instanceof Chest) {
                int spriteFromCordsX = sprite.getCoordinatesList().get(0).getX();
                int spriteFromCordsY = sprite.getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    boardList.remove(sprite);  // should be sprite.getID
                }
            } else if (sprite instanceof Monster) {
                int spriteFromCordsX = sprite.getCoordinatesList().get(0).getX();
                int spriteFromCordsY = sprite.getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    boardList.remove(sprite);  // should be sprite.getID
                }
            }
        }
    }

    public void displayLegend(Player player) {
        // TODO: 
    }

    public void printBoard2(Player player) {
        updateBoard(); // update board

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(arrayTypeBoard[y][x].getApparel());
            }
            System.out.println();
        }

        // LEGENDS
        String infoAboutPlayer = player.infoToString();
        System.out.println(infoAboutPlayer);
    }

    public Creature getGoblin() {
        return goblin;
    }

    public void removeSprite(int x, int y) {
        // TODO:
        for (Sprite sprite: boardList) {
            if (sprite instanceof Chest) {
                int spriteFromCordsX = sprite.getCoordinatesList().get(0).getX();
                int spriteFromCordsY = sprite.getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    boardList.remove(sprite);  // should be sprite.getID
                }
            } else if (sprite instanceof Monster) {
                int spriteFromCordsX = sprite.getCoordinatesList().get(0).getX();
                int spriteFromCordsY = sprite.getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    boardList.remove(sprite);  // should be sprite.getID
                }
            }
        }
    }

}
