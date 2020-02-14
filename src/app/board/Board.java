package app.board;

import app.Coordinates;

import app.inventory.*;
import app.creatures.Creature;
import app.creatures.Dragon;
import app.creatures.Monster;
import app.creatures.Player;
import app.services.TerminalManager;
import app.inventory.Inventory;
import app.menu.Color;
import app.creatures.Creature;
import app.creatures.Monster;
import app.structures.*;

import java.util.ArrayList;
import java.util.List;



public class Board {

    private List<Sprite> boardList;
    private String level;
    private int height;
    private int width;
    private Sprite[][] arrayTypeBoard;
    private Sprite chest1;
    private Monster goblin;
    private Door door;


    public Board(String level, int height, int width) {
        boardList = new ArrayList<>();
        this.level = level;
        this.height = height;
        this.width = width;
        arrayTypeBoard = new Sprite[height][width];

        addElementToBoard(new Water(createCoordList(1, width - 1, 1, height - 1)));


        addElementToBoard(new Grass(createShape(3, 10, 5)));
        addElementToBoard(new Grass(createShape(1, 1, 5)));
        addElementToBoard(new Grass(createShape(3, 20, 5)));
        addElementToBoard(new Grass(createShape(3, 40, 10)));
        addElementToBoard(new Grass(createShape(5, 25, 8))); 
        addElementToBoard(new Grass(createShape(3, 17, 5)));
        addElementToBoard(new Grass(createShape(24, 26, 5)));
        addElementToBoard(new Grass(createShape(30, 24, 8)));
        addElementToBoard(new Grass(createShape(82, 13, 8)));

        addElementToBoard(new Grass(createShape(61, 13, 5)));
        addElementToBoard(new Grass(createShape(50, 13, 5)));
        addElementToBoard(new Grass(createShape(40, 8, 8))); 
        addElementToBoard(new Grass(createShape(30, 13, 5)));

        addElementToBoard(new Grass(createShape(16, 5, 10)));
        addElementToBoard(new Grass(createShape(61, 25, 5)));
        addElementToBoard(new Grass(createShape(48, 23, 5)));
        addElementToBoard(new Grass(createShape(52, 25, 3)));
        addElementToBoard(new Grass(createShape(81, 30, 5)));
        addElementToBoard(new Grass(createShape(68, 27, 8)));
        addElementToBoard(new Grass(createShape(54, 28, 5)));
        addElementToBoard(new Grass(createShape(88, 23, 6)));
        addElementToBoard(new Grass(createShape(115, 16, 8)));
        addElementToBoard(new Grass(createShape(91, 5, 5)));
        addElementToBoard(new Grass(createShape(100, 2, 5)));
        addElementToBoard(new Grass(createShape(110, 5, 6)));

      
        addElementToBoard(new Bridge(createCoordList(13, 20, 24, 24)));
        addElementToBoard(new Bridge(createCoordList(7, 8, 8, 8)));
        addElementToBoard(new Bridge(createCoordList(33, 33, 10, 10)));
        addElementToBoard(new Bridge(createCoordList(43, 44, 14, 14)));
        addElementToBoard(new Bridge(createCoordList(44, 45, 15, 15)));
        addElementToBoard(new Bridge(createCoordList(45, 47, 16, 16)));
        addElementToBoard(new Bridge(createCoordList(74, 75, 30, 30)));
        addElementToBoard(new Bridge(createCoordList(65, 75, 12, 14)));
        addElementToBoard(new Bridge(createCoordList(84, 85, 27, 27)));
        addElementToBoard(new Bridge(createCoordList(87, 87, 17, 17)));
        addElementToBoard(new Bridge(createCoordList(85, 87, 7, 7)));
        addElementToBoard(new Bridge(createCoordList(93, 95, 1, 1)));
        addElementToBoard(new Bridge(createCoordList(103, 103, 5, 5)));
        addElementToBoard(new Bridge(createCoordList(114, 114, 8, 8)));
        
        addElementToBoard(new Monster("\uD83D\uDC7A", createCoordList(84, 84, 7, 7), "Goblin", 30, new Inventory(), 5, 15));
        addElementToBoard(new Border(new ArrayList<>(), height, width));


        // addElementToBoard(new Door(createCoordList(2, 2, 7, 7), "asd123"));
        addElementToBoard(new Chest(createCoordList(30, 30, 13, 13), "differentChest"));

        putChestOnBoard();
        putMagicalDoorOnBoard();
        Creature dragon = new Dragon(createCoordList(30, 30, 17, 17), new Inventory());
        addElementToBoard(dragon);
        
    }

    public void putMagicalDoorOnBoard() {
        List<Coordinates> magicalDoorCoords = new ArrayList<>();
        magicalDoorCoords.add(new Coordinates(112, 16));
        door = new Door(magicalDoorCoords, "asd123");
        boardList.add(door);
    }

    private void putChestOnBoard() {
        List<Coordinates> chestCoords = new ArrayList<>();
        chestCoords.add(new Coordinates(16, 2));
        chest1 = new Chest(chestCoords);
        boardList.add(chest1);
    }

    public Chest findChest(int x, int y) {
        // Chest chestTemp = new Chest(null);
        for (Sprite sprite: boardList) {
            if (sprite instanceof Chest) {
                int spriteFromCordsX = sprite.getCoordinatesList().get(0).getX();
                int spriteFromCordsY = sprite.getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    Chest chest = (Chest) sprite;
                    return chest;
                }
            } 
        }
        // return chestTemp;
        return null;
    }


	public Creature findMonster(int x, int y) {
        // Creature creatureTemp = new Creature("%", null, "name", 40, new Inventory(), 10, 10);
        for (Sprite sprite : boardList) {
            if (sprite instanceof Monster) {
                int spriteFromCordsX = sprite.getCoordinatesList().get(0).getX();
                int spriteFromCordsY = sprite.getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    Creature creature = (Creature) sprite;
                    return creature;
                }
            }
        }
        
		return null;
	}

    // private void putChestOnBoard() {
        // List<Coordinates> chestCoords = new ArrayList<>();
        // chestCoords.add(new Coordinates(3, 2));
        // chest1 = new Chest(chestCoords);
        // boardList.add(chest1);
    // }

    public List<Sprite> getBoardList() {
        return boardList;
    }

    public void addElementToBoard(Sprite sprite) {
        boardList.add(sprite);
    }


    public void putPlayerOnBoard(Sprite player) {
        addElementToBoard(player);
    }

    // public void putBigBridgeOnBoard() {
    //     List<Coordinates> bigBridgeCoordinates = new ArrayList<>();
    //     for (int y = 12; y <= 14; y++) {
    //         for (int x = 67; x <= 76; x++) {
    //             bigBridgeCoordinates.add(new Coordinates(x, y));
    //         }
    //     }
    //     Bridge bigBridge = new Bridge(bigBridgeCoordinates);
    //     addElementToBoard(bigBridge);
    // }

    // public void putLakeOnBoard() {
    //     List<Coordinates> lakeCoordinates = new ArrayList<>();
    //     for (int y = 5; y <= 7; y++) {
    //         for (int x = 5; x <= 10; x++) {
    //             lakeCoordinates.add(new Coordinates(x, y));
    //         }
    //     }
    //     Water lake = new Water(lakeCoordinates);
    //     addElementToBoard(lake);
    // }

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

        // System.out.println(TerminalManager.repeatString('X', width));

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(arrayTypeBoard[y][x].getApparel() + " ");
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


//        Map<Sprite, List<Coordinates>> sorter = new HashMap<>();
//        List<Sprite> thinnedBoardList = new ArrayList<>();
//        for (int i = boardList.size() - 1; i >= 0; i--) {
//            Sprite sprite = boardList.get(i);
//            List<Coordinates> coordList = sprite.getCoordinatesList();
//            int sizeOfCoordList = sprite.getCoordinatesList().size();
//            for (int coordIndex = 0; coordIndex < sizeOfCoordList; coordIndex++) {
//                Coordinates coords = coordList.get(coordIndex);
//                int x = coords.getX();
//                int y = coords.getY();
//                if (!sorter.containsKey(sprite)) {
//                    sorter.put(sprite, coordList);
//                } else {
//                    sorter.get(sprite)
//                }
//            }
//        }
//        List<Sprite> thinnedBoardList = new ArrayList<>();
//        for (Sprite sprite : sorter.keySet()) {
//            thinnedBoardList.add(sprite);
//        }
//        return thinnedBoardList;

    public Chest getChest() {
        Chest chest = (Chest) chest1;
        return chest;
    }

//    public Sprite getSprite(int x, int y) {
//        Sprite foundSprite = new Sprite("", createCoordList(0, 0, 0, 0));
//        for (Sprite sprite : boardList) {
//            if (sprite instanceof Monster) {
//                int spriteFromCoordsX = sprite.getCoordinatesList().get(0).getX();
//                int spriteFromCoordsY = sprite.getCoordinatesList().get(0).getY();
//                if (spriteFromCoordsX == x && spriteFromCoordsY == y) {
//                    foundSprite = sprite;
//                }
//            }
//        }
//        return foundSprite;
//    }

    public Creature getGoblin() {
        return goblin;
    }

//
    // old = removeSprite(int x, int y)     <=== with iterator!!
    public void removeSprite2(int x, int y) {
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
            } else if (sprite instanceof Door) {
                int spriteFromCordsX = sprite.getCoordinatesList().get(0).getX();
                int spriteFromCordsY = sprite.getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    boardList.remove(sprite);  // should be sprite.getID
                }
            }
        }
    }

    public void removeSprite(int x, int y) {
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i) instanceof Chest) {
                int spriteFromCordsX = boardList.get(i).getCoordinatesList().get(0).getX();
                int spriteFromCordsY = boardList.get(i).getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    boardList.remove(boardList.get(i));  // should be sprite.getID
                }
            } else if (boardList.get(i) instanceof Monster) {
                int spriteFromCordsX = boardList.get(i).getCoordinatesList().get(0).getX();
                int spriteFromCordsY = boardList.get(i).getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    boardList.remove(boardList.get(i));  // should be sprite.getID
                }
            } else if (boardList.get(i) instanceof Door) {
                int spriteFromCordsX = boardList.get(i).getCoordinatesList().get(0).getX();
                int spriteFromCordsY = boardList.get(i).getCoordinatesList().get(0).getY();
                if (spriteFromCordsX == x && spriteFromCordsY == y) {
                    boardList.remove(boardList.get(i));  // should be sprite.getID
                }
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

    public void displayLegend(Creature player) {
        // TODO: 
        Player player2 = (Player) player;
        String infoAboutPlayer = player2.infoToString();

        StringBuilder legend = new StringBuilder();

        legend.append(infoAboutPlayer);
        // legend.append("\n\n");
        legend.append("\n" + Color.GREEN_BOLD + "-------------------------------" + Color.RESET+ "\n");
        legend.append("| Press (i) to show INVENTORY |");
        // legend.append("\n-------------------------------");
        legend.append("\n" + Color.GREEN_BOLD + "-------------------------------" + Color.RESET+ "\n");


        legend.append("\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\n");
        // legend.append("\n--------------------------\n");
        legend.append("| Press (m) to show MENU |");
        legend.append("\n\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F\u2328\uFE0F");
        
        System.out.println(legend);
    }

    public void printBoard2(Creature player) {
        updateBoard(); // update board

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(arrayTypeBoard[y][x].getApparel());
            }
            System.out.println();
        }

        displayLegend(player);
    }



}

