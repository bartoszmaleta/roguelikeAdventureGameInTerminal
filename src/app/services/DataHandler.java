package app.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import app.menu.Color;

public class DataHandler {

    public static void printFromFile(String filepath) throws FileNotFoundException {
        TerminalManager.clearScreen();
        String FILE_PATH = "/src/app/chestOpened.txt";

        Scanner input = new Scanner(new File(filepath));

        while (input.hasNextLine()) {
            System.out.print(Color.CYAN);
            System.out.println(input.nextLine());
        }
        System.out.println(Color.RESET);
    }

    public static void printChestOpened() throws FileNotFoundException {
        String filepath = "src/app/chestOpened.txt";
        DataHandler.printFromFile(filepath);
    }

    public static void printChestClosed() throws FileNotFoundException {
        String filepath = "src/app/chestClosed.txt";
        DataHandler.printFromFile(filepath);
    }

    public static void printDoorClosed() throws FileNotFoundException {
        String filepath = "src/app/graphics/doorClosed.txt";
        DataHandler.printFromFile(filepath);
    }

    public static void printDoorOpened() throws FileNotFoundException {
        String filepath = "src/app/graphics/doorOpened.txt";
        DataHandler.printFromFile(filepath);
	}
}