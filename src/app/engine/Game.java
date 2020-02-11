package app.engine;

import app.board.Board;
import app.structures.Sprite;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Game extends KeyAdapter {
    
    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int)ch);

        switch(ch) {
            case 'w':
                System.out.println(ch);
                Board board = new Board("Level 1", 31, 115);
                board.growGrass();
                Sprite[][] as = board.getArrayTypeBoard();
                System.out.println(as[1][1].getApparel());

//                System.out.println(as[0][0].getApparel());

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