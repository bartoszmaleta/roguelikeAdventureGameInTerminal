package app.engine;

import app.Coordinates;
import app.inventory.Inventory;
import app.board.Board;
import app.board.BoardLevelTwo;
import app.creatures.Creature;
import app.creatures.Player;
import app.inventory.MenuInventory;
import app.creatures.Monster;
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

    private Creature player;
    private Inventory playerInv;
    private Board board;
    private List<Coordinates> playerCoordinates;
    private BoardLevelTwo boardLevelTwo;

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();
        String charString = String.valueOf(ch).toLowerCase();

        // TODO: find how convert char to Character!!!!
        // Character charObj = new Character(ch);
        // System.out.println((int) ch);
        // Character ch = ch.toLowerCase(ch);

        // FOR UNIVERSAL MOVE METHODS!
        Coordinates coord = new Coordinates(0,0);

        switch (charString) {
        case "w":
            coord.setY(-1); // FOR UNIVERSAL MOVE METHODS!
            if (!checkUpperCollision()) {
                player.getCoordinatesList().get(0).goUp();
                // TODO: change to be more universal!!!
                // player.getCoordinatesList().get(0).go(new Coordinates(0,0));

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
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                // e.getMessage();      // HANDLING EXCEPETIONS
            }
            return;
        case "i":
            try {
                displayCreatureInv(player);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return;
        case "e":
            player.addHealth(player.getInventory().findElixir().getHealthToRestore());
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

        // // FOR UNIVERSAL MOVE METHODS!
        // int x = player.getCoordinatesList().get(0).getX();
        // int y = player.getCoordinatesList().get(0).getY();
        // checkCollision(new Coordinates(0, -1), x, y);
        if (checkIfChest()) {
            chestAction();

        } else if (checkIfMonster()) {
            try {
                fightMonster(player);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else if (checkIfDoor()) {
            System.out.println("I am in door!");
            doorAction();
        }

        if (player.getExperience() < 400) {
        // board.printBoard();
            board.printBoard2(player);  // REFACTOR THIS METHOD TO "printBoard()"
        } else if (player.getExperience() >= 400) {
            createLevelTwoBoard(player);
            boardLevelTwo.printBoard2(player);
        }

    }

    public void createLevelTwoBoard(Creature player) {
        boardLevelTwo = new BoardLevelTwo("Level 2", 33, 117);

        boardLevelTwo.addElementToBoard(player);
    }

    public void init() {
        // CREATE BOARD:
        board = new Board("Level 1", 33, 117);

        // CREATE PLAYER COORDINATES
        playerCoordinates = new ArrayList<>();
        playerCoordinates.add(new Coordinates(2, 1));

        // CREATE INV FOR PLAYER:
        playerInv = new Inventory();

        // FILL INV WITH ITEMS
        Item sword = new Sword("Sword one-handed", 15, 50);
        playerInv.addToInventory(sword);

        // CREATE PLAYER
        player = new Player(playerCoordinates, "Stefan", playerInv);

        // PUT PLAYER ON BOARD
        board.addElementToBoard(player);

    }

    public void firstTimeBoard() {
        // OLD
        // board.printBoard();
        board.printBoard2(player);
    }

    // TODO: universal checkCollision
    // FOR UNIVERSAL MOVE METHODS!
    public boolean checkCollision(Coordinates coord, int x, int y) {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        if (arrayTypeBoard[y + coord.getY()][x+coord.getX()] instanceof Collision) {
            return true;
        }
        return false;
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

    // todo isCollision, hasCollision
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

    public boolean checkIfMonster() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y][x] instanceof Monster) {
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

    private void doorAction() {
        DataHandler.displayImageOfDoorClosed();

        if (player.hasKeyToDoor()) {
            player.addExperience(5000);

            System.out.println("Player has key!");

            // DISPLAY IMAGE OF DOOR OPENED
            try {
                DataHandler.printDoorOpened();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // REMOVING DOOR FROM BOARD
            int x = player.getCoordinatesList().get(0).getX();
            int y = player.getCoordinatesList().get(0).getY();
            board.removeSprite(x, y);
            player.addExperience(500);

        } else {
            System.out.println("\n\n\n\n\nYou do not have key to this door!! Find key first!\n\n\n");
        }

        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.clearScreen();

    }

    private void fightMonster(Creature playerFighter) throws FileNotFoundException, InterruptedException {
        int x = playerFighter.getCoordinatesList().get(0).getX();
        int y = playerFighter.getCoordinatesList().get(0).getY();

        Creature monsterFound = board.findMonster(x, y);
        
        // DONT KNOW WHERE TO SET DAMAGE????
        playerFighter.setDamage(8);

        System.out.println("\n\nStats at the beginning");
        System.out.println("Monster health = " + monsterFound.getHealth());
        System.out.println("Monster damage = " + monsterFound.getDamage());

        System.out.println("\nPlayer health = " + playerFighter.getHealth());
        System.out.println("Player damage = " + playerFighter.getDamage());

        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.clearScreen();

        int counter = 1;
        while ((playerFighter.getHealth() > 0) && (monsterFound.getHealth() > 0)) {
            System.out.println("\n\n             Round " + counter);
            playerFighter.attack(monsterFound);
            TestGif.displayPlayerAttack();

            TerminalManager.pressAnyKeyToContinue();

            monsterFound.attack(playerFighter);
            TestGif.displayMonsterAttack();

            System.out.println("\n\n             Round " + counter);
            displayBattleStats(playerFighter, monsterFound);

            TerminalManager.pressAnyKeyToContinue();
            TerminalManager.clearScreen();

            counter++;
        }
        if (playerFighter.getHealth() > 0) {
            System.out.println("\n\n\n\n\nPlayer won! Good job! ");
            addCreatureInvToPlayerInv(x, y);

            board.removeSprite(x, y);
        } else {
            System.out.println("Monster Won! Do better next time!\n\n");
            // TODO: WHAT IF PLAYER LOSES????
        }

        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.clearScreen();

    }

    public void chestAction() {

        // DISPLAY IMAGE OF CHEST CLOSED
        DataHandler.displayImageOfChestClosed();
        // DISPLAY IMAGE OF CHEST OPENED
        DataHandler.displayImageOfChestOpened();

        // GET PLAYER COORDS AND FIND CHEST AND ITS INV BY COORDS
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        Inventory inventoryOfFoundChest = board.findChest(x, y).getChestInventory();

        // PRINTS CONTENT OF THE CHEST
        inventoryOfFoundChest.printContent(); // TODO: prettyTable print!!!

        // ADD CHEST ITEMS TO PLAYER INVENTORY
        addChestInvToPlayerInv(x, y); // add and print

        // REMOVING CHEST FROM BOARD
        board.removeSprite(x, y);
        player.addExperience(50);

        TerminalManager.pressAnyKeyToContinue();
        TerminalManager.clearScreen();

    }

    public void addChestInvToPlayerInv(int x, int y) {
        List<Item> inventoryOfChest = board.findChest(x, y).getChestInventory().getInventoryList();
        Inventory inv = player.getInventory();
        for (Item item : inventoryOfChest) {
            inv.addToInventory(item);
        }
    }

    public void addCreatureInvToPlayerInv(int x, int y) {
        List<Item> inventoryOfCreature = board.findMonster(x, y).getInventory().getInventoryList();
        Inventory playerInvent = player.getInventory();
        for (Item item : inventoryOfCreature) {
            playerInvent.addToInventory(item);
        }
    }

    public void displayCreatureInv(Creature creature) throws FileNotFoundException {
        // Inventory playerInventory = ((Creature) player).getInventory();
        MenuInventory.displayInventoryMenuLogo();
        Inventory creatureInventory = creature.getInventory();
        creatureInventory.printTable();

        // playerInventory.printContent(); // Old print without table
        // creatureInventory.printTableOld(); // Old print witht table 2
    }

    public void displayBattleStats(Creature player, Creature monster) {

        System.out.println("\n\nMonster health = " + monster.getHealth());
        System.out.println("Monster damage = " + monster.getDamage());

        System.out.println("\nPlayer health = " + player.getHealth());
        System.out.println("Player damage = " + player.getDamage());
    }

}