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
        System.out.println((int) ch);
        // helpers.clearScreen();
        board.printBoard();

        switch (ch) {
            case 'w':
                if (!checkUpperCollision()) {
                    player.getCoordinatesList()
                            .get(0)
                            .goUp();
                }
                break;
            case 's':
                if (!checkLowerCollision()) {
                    player.getCoordinatesList()
                            .get(0)
                            .goDown();
                }
                break;
            case 'a':
                if (!checkLeftCollision()) {
                    player.getCoordinatesList()
                            .get(0)
                            .goLeft();
                }
                break;
            case 'd':
                if (!checkRightCollision()) {
                    player.getCoordinatesList()
                            .get(0)
                            .goRight();
                }
                break;

//                case 'e':
//                System.out.println(ch);
//                player.getCoordinatesList()
//                    .get(0)
//                    .goRight();
//
//                break;
        }
    }

    public void init() {
        // List<Coordinates> playerCoordinates = new ArrayList<>();
        // playerCoordinates.add(new Coordinates(3, 4));
        // Inventory inv = new Inventory();

        // Sprite player = new Player(playerCoordinates, "Stefan", 10, inv, 1, 0);
        // Board board = new Board("Level 1", 31, 115);

        // board.putPlayerOnBoard(player);


        // SECOND VERSION:
        board = new Board("Level 1", 33, 117);
        inv = new Inventory();

        playerCoordinates = new ArrayList<>();
        playerCoordinates.add(new Coordinates(1, 1));

        player = new Player(playerCoordinates, "Stefan", 10, inv, 1, 0);
        board.putPlayerOnBoard(player);
    }

    public boolean checkUpperCollision() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y + 1][x] instanceof Collision) {
            return true;
        }
        return false;
    }

    public boolean checkLowerCollision() {
        Sprite[][] arrayTypeBoard = board.getArrayTypeBoard();
        int x = player.getCoordinatesList().get(0).getX();
        int y = player.getCoordinatesList().get(0).getY();
        if (arrayTypeBoard[y - 1][x] instanceof Collision) {
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

}