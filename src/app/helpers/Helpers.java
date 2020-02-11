package app.helpers;

import java.util.Scanner;

public class Helpers {
    Scanner scanner = new Scanner(System.in);

    public String repeatString(char c, int times){
        StringBuffer b = new StringBuffer();
    
        for(int i = 0; i <= times + 1; i++){
            b.append(c);
        }
    
        return b.toString();
    }

    public void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue");
        scanner.nextLine();
    }

    public void displayWelcomeScreen() {
        emptyLinesThree();
        System.out.println("Welcome to BATTLESHIP" +
         "GAME");
        System.out.println("Produced by: ");
        System.out.println("Bartosz Maleta");
        System.out.println("Szymon Niemiec");
        System.out.println("Przemysław Buszek");
        emptyLinesThree();
        pressAnyKeyToContinue();
        clearScreen();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void emptyLinesThree() {
        System.out.println();
        System.out.println();
        System.out.println();
    }
}