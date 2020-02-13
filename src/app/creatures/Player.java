package app.creatures;

import app.Coordinates;
import app.inventory.Inventory;
import app.services.TerminalManager;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class Player extends Creature {

    private int level;
    private int experience;
    private Inventory inv;

    public Player(List<Coordinates> coordinatesPlayer, String name, Inventory inventory) {
        super("@", coordinatesPlayer, name, 100, inventory, 0, 0);
        setLevel();
        this.experience = 0;
    }

    public void setPlayerCoordinates(int x, int y) {
        List<Coordinates> coordinates = getCoordinatesList();
        coordinates.get(0).setX(x);
        coordinates.get(0).setY(y);
    }

    public void setLevel() {
        int exp = getExperience();
        if (exp < 100) {
            this.level = 1;
        }
        if (exp >= 100 && exp < 200) {
            this.level = 2;
        }
        if (exp >= 200 && exp < 400) {
            this.level = 3;
        }
        if (exp >= 400) {
            this.level = 4;
        }
    }

    public Inventory getInv() {
        return inv;
    }

    public String infoToString() {


        String tableInfo = "";
        tableInfo += "\n";
        
        // ------------------------------------- FIRST OPTION
        int tableLen = 40;
        String boarderOfTable = "-";

        int playerHealth = this.getHealth();
        int playerExperience = this.experience;
        int playerLevel = this.level;

        String playerHealthTitle = "Health";
        String playerLevelTitle = "Level";
        String playerExperienceTitle = "Experience";

        for (int j = 0; j < tableLen; j++) {
            tableInfo += boarderOfTable;
        }
        tableInfo += "\n";

        Formatter formatterHeadline = new Formatter();
        tableInfo += formatterHeadline.format("| %10s | %10s | %10s |", playerHealthTitle, playerLevelTitle,
                playerExperienceTitle);

        tableInfo += "\n";
        for (int j = 0; j < tableLen; j++) {
            tableInfo += boarderOfTable;
        }
        tableInfo += "\n";

        Formatter formatterStats = new Formatter();
        tableInfo += formatterStats.format("| %10d | %10d | %10d |", playerHealth, playerLevel, playerExperience);

        tableInfo += "\n";
        for (int j = 0; j < tableLen; j++) {
            tableInfo += boarderOfTable;
        }

        // ------------------------------------- SECOND OPTION 

        // tableInfo += "\n\n\n";
        // String boarderLegend = "=";

        // tableInfo += TerminalManager.repeatString(boarderLegend, 20);
        // tableInfo += "\n" + boarderLegend + " HEALTH = " + this.getHealth() + "       " + boarderLegend;
        // tableInfo += "\n" + boarderLegend + " EXPERIENCE = " + this.experience + "     " + boarderLegend;
        // tableInfo += "\n" + boarderLegend + " LEVEL = " + this.level + "          " + boarderLegend;
        // tableInfo += "\n" + TerminalManager.repeatString(boarderLegend, 20);


        // -------------------------------------  
        // tableInfo += "\n\n";

        // tableInfo += "\n-------------------------------\n";
        // tableInfo += "| Press (i) to show INVENTORY |";
        // tableInfo += "\n-------------------------------\n";

        // tableInfo += "\n--------------------------\n";
        // tableInfo += "| Press (m) to show MENU |";
        // tableInfo += "\n--------------------------\n";

        return tableInfo;
    }

	public boolean hasKeyToDoor() {
        Inventory playerInventory = this.player.getInv();
        
        for (Item item : inv) {
            
        }
        
		return false;
	}

}
