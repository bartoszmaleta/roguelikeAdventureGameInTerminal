package app.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {

        File txt = new File("src/app/menu/menu_logo.txt");
        // Scanner scan = new Scanner(txt);
        // ArrayList<String> data = new ArrayList<String>();
        // while (scan.hasNextLine()) {
        // data.add(scan.nextLine());
        // }
        // System.out.println(data);
        // String[] simpleArray = data.toArray(new String[] {});

        BufferedReader abc = new BufferedReader(new FileReader(txt));
        List<String> lines = new ArrayList<String>();
        for (String line : lines) {
            while ((line = abc.readLine()) != null) {
                lines.add(line);
                System.out.println(line);
            }
        }
        abc.close();

        // If you want to convert to a String[]
        String[] data = lines.toArray(new String[] {});
        System.out.println(data);
        for (String line : data) {
            System.out.println(line);   
        }
    }
}