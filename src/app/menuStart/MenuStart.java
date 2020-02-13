package app.menuStart;

import java.util.Scanner;

import app.services.TerminalManager;

public class MenuStart {
    static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\033[0;37;49mMenu");
        System.out.println("Choose option");

        System.out.println("1. Play Game");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. Exit program");
        
        TerminalManager.emptyLinesThree();
    }

    public static void startGame() {
        boolean isRunning = true;

        TerminalManager.displayWelcomeScreen();

        while (isRunning) {

            showMenu();

            int choosedOption = scanner.nextInt();

            switch (choosedOption) {
            case 1:
                isRunning = false;
                break;
            case 2:
                isRunning = false;
                break;
            case 7:
                System.exit(0);
                break;
            }
        }
    }
}