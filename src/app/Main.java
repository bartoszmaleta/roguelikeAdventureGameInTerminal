package app;

import app.engine.Game;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        JTextField textField = new JTextField();
        Game game = new Game();
        game.init();

        textField.addKeyListener(game);
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }
}