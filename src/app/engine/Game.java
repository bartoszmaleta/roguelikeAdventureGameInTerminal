package app.engine;

import app.Coordinates;
import app.Inventory;
import app.board.Board;
import app.creatures.Player;
import app.helpers.Helpers;
import app.structures.Sprite;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game extends KeyAdapter {

    private Sprite player;
    private Inventory inv;
    private Board board;
    private List<Coordinates> playerCoordinates;
    Helpers helpers = new Helpers(); // where to clearScreen(); ????
    
    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();
        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                player.getCoordinatesList()
                    .get(0)
                    .goUp();
                
                break;

            case 's':
                player.getCoordinatesList()
                    .get(0)
                    .goDown();
                break;

            case 'a':
                player.getCoordinatesList()
                    .get(0)
                    .goLeft();
                break;

            case 'd':
                player.getCoordinatesList()
                    .get(0)
                    .goRight();
                break;   

            case 'e':
                player.getCoordinatesList()
                    .get(0)
                    .goRight();
                break;   
                
        }
        
        helpers.clearScreen();
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
}