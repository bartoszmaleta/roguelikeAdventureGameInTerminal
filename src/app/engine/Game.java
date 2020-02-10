package app.engine;

import app.board.Board;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends KeyAdapter {
    
    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                System.out.println(ch);
                Board board = new Board("Level 1", 21, 21);
                board.fillBoard();
                board.growGrass();
                board.printBoard();
                // code block
                // Hero.moveUp()
                break;
            case 's':
                System.out.println(ch);
                // code block
                // Hero.moveDown()
                break;
            case 'a':
                System.out.println(ch);
                // code block
                // Hero.moveLeft()
                break;
            case 'd':
                System.out.println(ch);
                // code block
                // Hero.moveRight()
                break;   
        }
    }
}