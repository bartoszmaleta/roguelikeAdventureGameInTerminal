package app.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import app.services.TerminalManager;

public class TestGif {
    public static void main(String[] args) throws IOException {
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

    public static void displayPlayerAttack() throws FileNotFoundException {
        String filennameOfFighting = "src/app/engine/playerAttack.txt";
        String filennameOfFighting2 = "src/app/engine/playerAttack2.txt";
        String filennameOfFighting3 = "src/app/engine/playerAttack3.txt";

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

    public static void threadStop() {
        for (int i = 0; i < 15000000; i++) {
            System.out.print("");
        }
    }

    // public static String[][] arraysInArray(FILE_PATH) throws IOException {
    // URL source = new File(FILE_PATH).toPath().toUri().toURL(); //local file
    // Scanner in = new Scanner(source.openStream());
    // if (!in.hasNextLine()) { //oops, the file is empty
    // System.err.println("Missing headline!");
    // System.exit(1);
    // }
    // String headLine = in.nextLine();
    // String[] fieldNames = headLine.split(","); //the headline is like a regular
    // line, it holds the names of the fields
    // List<String[]> data = new ArrayList<>(); //backing list (=growable array) for
    // the elements
    // while (in.hasNextLine()) {
    // String line = in.nextLine();
    // String[] frags = line.split(","); //split line by comma, because it's CSV
    // data.add(frags);
    // }
    // in.close(); //close the stream

    // String[][] dataArray = data.toArray(new String[data.size()][]); // copy data
    // from the list to an array

    // return dataArray;
    // }

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