package app;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        JTextField textField = new JTextField();

        textField.addKeyListener(new Game());
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }
}