package app.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.services.TerminalManager;

public class Menu {
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String FILE_PATH = "src/app/menu/menu_logo.txt";

        Scanner input = new Scanner(new File(FILE_PATH));

        while (input.hasNextLine()) {
            System.out.print(Color.BLUE + input.nextLine());
            System.out.println(input.nextLine());
        }
        System.out.println(Color.RESET);
    }

    public static void displayMenu() throws FileNotFoundException {
        TerminalManager.clearScreen();
        String FILE_PATH = "src/app/menu/menu_logo.txt";

        Scanner input = new Scanner(new File(FILE_PATH));

        while (input.hasNextLine()) {
            System.out.print(Color.BLUE);
            System.out.println(input.nextLine());
        }
        System.out.println(Color.RESET);

        System.out.println("\n\n\nGAME IS PAUSED\n\n\n(p) - Back to the game\n\n(x) - Exit the program\n\n\n");
    }

    public static void menuInGameAsk() {
        boolean isMenuRunning = true;
        while (isMenuRunning) {
            switch (inputScanner.nextLine()) {
            case "1":
                isMenuRunning = false;
                break;
            case "0":
                System.exit(0);
                break;

            default:
                System.out.println("Wrong input");
            }
        }
    }

    public void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue");
        inputScanner.nextLine();
    }
}