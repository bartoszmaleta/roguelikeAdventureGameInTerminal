package app.engine;

import app.Coordinates;
import app.Inventory;
import app.board.Board;
import app.creatures.Player;
import app.services.TerminalManager;
import app.menu.Menu;
import app.structures.Sprite;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game extends KeyAdapter {

    private Sprite player;
    private Inventory inv;
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
            player.getCoordinatesList().get(0).goUp();

            break;

        case "s":
            player.getCoordinatesList().get(0).goDown();
            break;

        case "a":
            player.getCoordinatesList().get(0).goLeft();
            break;

        case "d":
            player.getCoordinatesList().get(0).goRight();
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
        }
        
        TerminalManager.clearScreen();
        board.printBoard();
    }

    public void init() {
        // List<Coordinates> playerCoordinates = new ArrayList<>();
        // playerCoordinates.add(new Coordinates(3, 4));
        // Inventory inv = new Inventory();

        // Sprite player = new Player(playerCoordinates, "Stefan", 10, inv, 1, 0);
        // Board board = new Board("Level 1", 31, 115);

        // board.putPlayerOnBoard(player);
        

        // SECOND VERSION:
        board = new Board("Level 1", 31, 115);
        inv = new Inventory();
        
        playerCoordinates = new ArrayList<>();
        playerCoordinates.add(new Coordinates(1, 1));

        player = new Player(playerCoordinates, "Stefan", 10, inv, 1, 0);
        board.putPlayerOnBoard(player);
    }

    public void displayMenu() {
        
    }

    public void firstTimeBoard() {
        board.printBoard();
    }
}