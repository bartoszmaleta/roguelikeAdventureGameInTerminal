package app;

import app.engine.Game;
import app.menuStart.MenuStart;
import app.services.DataHandler;
import app.services.TerminalManager;

import java.io.FileNotFoundException;

import javax.swing.*;

// TODO:
//      - check if board (level 2) will work
//      - experience and level for creature
//      - animation !!!!!!!!!!!!!!!
//      - level2 more universal
//      - classes of players
//      - legenda
//      - id for all sprites

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        welcomeScreen();
        runGame();
    }

    private static void welcomeScreen() throws FileNotFoundException {
        String filepath = "src/app/graphics/welcome.txt";
        DataHandler.printFromFile(filepath);
    }

    public static void runGame() {
        MenuStart.startGame();

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