package app;

import app.engine.Game;
import app.menuStart.MenuStart;
import app.services.TerminalManager;

import javax.swing.*;

// TODO:
//      - check if board (level 2) will work

public class Main {

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        MenuStart.startGame();

        // TerminalManager.displayWelcomeScreen();

        JTextField textField = new JTextField();

        
        Game game = new Game();
        game.init();
        game.firstTimeBoard();
        
        textField.addKeyListener(game);
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }
}