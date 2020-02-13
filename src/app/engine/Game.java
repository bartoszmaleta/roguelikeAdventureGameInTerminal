package app.engine;

import app.Coordinates;
import app.inventory.Inventory;
import app.board.Board;
import app.creatures.Creature;
import app.creatures.Player;
import app.inventory.MenuInventory;
import app.items.Armor;
import app.creatures.Monster;
import app.creatures.Player;
import app.items.Item;
import app.items.Sword;
import app.services.DataHandler;
import app.services.TerminalManager;
import app.menu.Menu;
import app.structures.Chest;
import app.structures.Door;
import app.structures.Sprite;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game extends KeyAdapter {

    private Player player;
    private Inventory playerInv;
    private Board board;
    private List<Coordinates> playerCoordinates;

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();
        String charString = String.valueOf(ch).toLowerCase();

        // Character charObj = new Character(ch);
        // System.out.println((int) ch);
        // Character ch = ch.toLowerCase(ch);

        switch (charString) {
        case "w":
            if (!checkUpperCollision()) {
                player.getCoordinatesList().get(0).goUp();
            }

            break;

        case "s":
            if (!checkLowerCollision()) {
                player.getCoordinatesList().get(0).goDown();

            }
            break;

        case "a":
            if (!checkLeftCollision()) {
                player.getCoordinatesList().get(0).goLeft();
            }
            break;

        case "d":
            if (!checkRightCollision()) {
                player.getCoordinatesList().get(0).goRight();
            }
            break;

        // case 'b': work as second option to insert
        case "m":
            try {
                Menu.displayMenu();
                // Menu.menuInGameAsk();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return;
        case "i":
            System.out.println("I am in inventory");
            try {
                displayCreatureInv(player);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return;
        case "p": // back to the game
            break;
        case "x":
            System.exit(0);
            break;

        default:
            System.out.println("Wrong input");
            return;
        }
        TerminalManager.clearScreen();

        if (checkIfChest()) {
            chestAction();
        } else if (checkIfMonster()) {
            int x = player.getCoordinatesList().get(0).getX();
            int y = player.getCoordinatesList().get(0).getY();
            Creature monster = board.getGoblin();
            boolean playerWon = false;
            boolean opponentWon = false;
            while (!playerWon || !opponentWon) {
                if (player.turn(monster)) {
                    player.setExperience(player.getExperience() + monster.getExperience());
                    player.setLevel();
                    List<Item> monsterInventory = monster.getInventory().getInventoryList();
                    for (Item item : monsterInventory) {
                        player.getInventory().addToInventory(item);
                    }

                    playerWon = player.turn(monster);
                } else {
                    player.turn(monster);
                }
                if (monster.turn(player)) {
                    int monsterX = monster.getCoordinatesList().get(0).getX();
                    int monsterY = monster.getCoordinatesList().get(0).getY();
                    board.removeSprite(monsterX, monsterY);
                    opponentWon = monster.turn(player);
                } else {
                    monster.turn(player);
                }
            }
        } else if (checkIfDoor()) {
            doorAction();
        }

        // board.printBoard();
        board.printBoard2(player);

    }

    public void init() {
        // CREATE BOARD:
        board = new Board("Level 1", 33, 117);

        // CREATE PLAYER COORDINATES
        playerCoordinates = new ArrayList<>();
        playerCoordinates.add(new Coordinates(10, 6));

        // CREATE INV FOR PLAYER:
        playerInv = new Inventory();

        // FILL INV WITH ITEMS
        Item sword = new Sword("Sword one-handed", 15, 50);
        playerInv.addToInventory(sword);

        // CREATE PLAYER
        player = new Player(playerCoordinates, "Stefan", playerInv);

        // PUT PLAYER ON BOARD
        board.addElementToBoard(player);

        // List<Coordinates> chestCoords = new ArrayList<>();
        // chestCoords.add(new Coordinates(20, 10));
        // Sprite chest1 = new Chest(chestCoords);
        // board.getBoardList().add(chest1);

    }

    public void firstTimeBoard() {
        // TODO: !!!!!!! OLD
        // board.printBoard();
        board.printBoard2(player);
    }

    public boolean checkUpperCollision() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y - 1][x] instanceof Collision) {
            return true;
        }
        return false;
    }

    public boolean checkLowerCollision() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y + 1][x] instanceof Collision) {
            return true;
        }
        return false;
    }

    public boolean checkRightCollision() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y][x + 1] instanceof Collision) {
            return true;
        }
        return false;
    }

    public boolean checkLeftCollision() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y][x - 1] instanceof Collision) {
            return true;
        }
        return false;
    }

    public boolean checkIfChest() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y][x] instanceof Chest) {
            return true;
        }
        return false;
    }

    private boolean checkIfDoor() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y][x] instanceof Door) {
            return true;
        }
        return false;
    }

    public boolean checkIfMonster() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y][x] instanceof Monster) {
            return true;
        }
        return false;
    }

    private void doorAction() {
        // DISPLAY IMAGE OF DOOR CLOSED
        try {
            DataHandler.printDoorClosed();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.clearScreen();

        if (player.hasKeyToDoor()) {
            player.addExperience(5000);




            // DISPLAY IMAGE OF DOOR OPENED
            try {
                DataHandler.printDoorOpened();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.clearScreen();


    }

    public void chestAction() {

        // DISPLAY IMAGE OF CHEST CLOSED
        try {
            DataHandler.printChestClosed();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.clearScreen();

        // DISPLAY IMAGE OF CHEST OPENED
        try {
            DataHandler.printChestOpened();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // PRINTS CONTENT OF THE CHEST
        Inventory inventoryOfChest = board.getChest().getChestInventory();
        inventoryOfChest.printContent();
        // inventoryOfChest.printTable(); // TODO: prettyTable print!!!

        // REMOVING CHEST FROM BOARD
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();

        System.out.println("------------");
        System.out.println("player inv");
        addChestInvToPlayerInv(x, y); // add and print

        // board.removeChestFromBoardList();
        board.removeChestFromBoardListByCoords(x, y);

        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.clearScreen();

    }

    public void addChestInvToPlayerInv(int x, int y) {
        List<Item> inventoryOfChest = board.getChest().getChestInventory().getInventoryList();
        Inventory inv = player.getInventory();
        for (Item item : inventoryOfChest) {
            inv.addToInventory(item);
        }

        // inv.printContent();

    }

    public void displayCreatureInv(Creature creature) throws FileNotFoundException {
        // Inventory playerInventory = ((Creature) player).getInventory();
        MenuInventory.displayInventoryMenuLogo();
        Inventory creatureInventory = creature.getInventory();
        creatureInventory.printTable();

        // playerInventory.printContent(); // Old print without table
        // creatureInventory.printTableOld(); // Old print witht table 2
    }

}