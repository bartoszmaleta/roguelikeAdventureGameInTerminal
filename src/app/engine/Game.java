package app.engine;

import app.Coordinates;
import app.Inventory;
import app.board.Board;
import app.creatures.Player;
import app.items.Armor;
import app.items.Item;
import app.items.Sword;
import app.items.Weapon;
import app.services.DataHandler;
import app.services.TerminalManager;
import app.menu.Menu;
import app.structures.Chest;
import app.structures.Grass;
import app.structures.Sprite;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game extends KeyAdapter {

    private Sprite player;
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
            // TODO: inventory display
            System.out.println("I am in inventory");
            break;
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
        }

        board.printBoard();

    }

    public void init() {
        // CREATE BOARD:
        board = new Board("Level 1", 33, 117);

        // CREATE PLAYER COORDINATES
        playerCoordinates = new ArrayList<>();
        playerCoordinates.add(new Coordinates(31, 20));

        // CREATE INV FOR PLAYER:
        playerInv = new Inventory();

        // FILL INV WITH ITEMS
        Item sword = new Sword("sword one-handed", 15, 50);
        playerInv.addToInventory(sword);

        // CREATE PLAYER
        player = new Player(playerCoordinates, "Stefan", 10, playerInv);

        // PUT PLAYER ON BOARD
        board.addElementToBoard(player);

        // List<Coordinates> chestCoords = new ArrayList<>();
        // chestCoords.add(new Coordinates(20, 10));
        // Sprite chest1 = new Chest(chestCoords);
        // board.getBoardList().add(chest1);

    }

    public void firstTimeBoard() {
        board.printBoard();
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






        // TODO:
        // REMOVING CHEST FROM BOARD
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();

        TerminalManager.pressAnyKeyToContinue();

        List<Coordinates> tempChestCoords = new ArrayList<>();
        tempChestCoords.add(new Coordinates(x, y));
        Sprite tempChest = new Chest(tempChestCoords);

        List<Sprite> boardSpriteList = board.getBoardList();

        // for (Sprite sprite : boardSpriteList) {
        // if (sprite.getCoordinatesList().get(0).getX() ==
        // tempChest.getCoordinatesList().get(0).getX()) {
        // boardSpriteList.remove(sprite);
        // // TerminalManager.pressAnyKeyToContinue();
        // }
        // }

        // player.getCoordinatesList().get(0).setX(x + 1);
        // player.getCoordinatesList().get(0).setY(y + 1);

        // for (Iterator<Sprite> it = boardSpriteList.iterator(); it.hasNext();) {
        // Sprite next = it.next();
        // if (next.getCoordinatesList().get(0).getX() ==
        // tempChest.getCoordinatesList().get(0).getX()) {
        // it.remove();
        // }
        // }

        TerminalManager.clearScreen();

    }

}