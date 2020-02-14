package app.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import app.services.TerminalManager;

public class TestGif {
    public static void main(String[] args) throws IOException, InterruptedException {
        displayMonsterAttack();

        displayPlayerAttack();

    }

    public static void displayMonsterAttack() throws FileNotFoundException {
        String filennameOfFighting = "src/app/engine/fighting.txt";
        String filennameOfFighting2 = "src/app/engine/fighting2.txt";
        String filennameOfFighting3 = "src/app/engine/fighting3.txt";

        int counter = 0;
        while (counter < 1) {

            System.out.println(arrayFromFile(filennameOfFighting));
            threadStop();
            System.out.println(arrayFromFile(filennameOfFighting2));
            threadStop();
            System.out.println(arrayFromFile(filennameOfFighting3));
            threadStop();
            counter ++;
        }
    }

    public static void displayPlayerAttack() throws FileNotFoundException, InterruptedException {
        String filennameOfFighting = "src/app/engine/playerAttack.txt";
        String filennameOfFighting2 = "src/app/engine/playerAttack2.txt";
        String filennameOfFighting3 = "src/app/engine/playerAttack3.txt";

        int counter = 0;
        while (counter < 1) {

            System.out.println(arrayFromFile(filennameOfFighting));
            threadStop();
            // Thread.sleep(20000); // better sleep!!!
            System.out.println(arrayFromFile(filennameOfFighting2));
            threadStop();
            System.out.println(arrayFromFile(filennameOfFighting3));
            threadStop();

            counter ++;
        }
    }

    public static void threadStop() {
        for (int i = 0; i < 15000000; i++) {
            System.out.print("");
        }
    }

    public static void displayArraysInArray(String[][] arrays) {
        Arrays.toString(arrays);
    }

    public static String arrayFromFile(String filepath) throws FileNotFoundException {
        TerminalManager.clearScreen();

        Scanner input = new Scanner(new File(filepath));

        String dataInString = "";

        while (input.hasNextLine()) {
            // System.out.print(Color.CYAN);
            dataInString += input.nextLine() + "\n";
        }
        // System.out.println(Color.RESET);

        return dataInString;
    }

}