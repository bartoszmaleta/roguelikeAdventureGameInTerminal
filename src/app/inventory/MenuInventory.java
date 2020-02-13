package app.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import app.menu.Color;
import app.services.TerminalManager;

public class MenuInventory {
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // // TESTING COLOURS
        // String FILE_PATH = "src/app/menu/menu_logo.txt";

        // Scanner input = new Scanner(new File(FILE_PATH));

        // while (input.hasNextLine()) {
        //     System.out.print(Color.BLUE + input.nextLine());
        //     System.out.println(input.nextLine());
        // }
        // System.out.println(Color.RESET);
    }

    public static void displayInventoryMenuLogo() throws FileNotFoundException {
        TerminalManager.clearScreen();
        String FILE_PATH = "/home/acer/Java Repositories/rougelikeGameJava/src/app/inventory/inventoryLogo.txt";

        Scanner input = new Scanner(new File(FILE_PATH));

        while (input.hasNextLine()) {
            System.out.print(Color.BLUE);
            System.out.println(input.nextLine());
        }
        System.out.println(Color.RESET);

        System.out.println("\n                                 GAME IS PAUSED");
        System.out.println("\n\n\n(p) - Back to the game\n(x) - Exit the program\n\n\n");
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

}