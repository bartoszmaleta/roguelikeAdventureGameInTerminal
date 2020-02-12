package app;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import app.items.Armor;
import app.items.Item;
import app.items.Weapon;

public class Inventory {
    private List<Item> inventoryList;

    public Inventory() {
        this.inventoryList = new ArrayList<>();
    }

    public List<Item> getInventoryList() {
        return inventoryList;
    }

    public void setInventory(List<Item> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public void addToInventory(Item item) {
        this.inventoryList.add(item);
    }

    public String printTable() {
        String tableInfo = "";
        int tableLen = 140;
        tableInfo += "\n";

        for (int i = 0; i < inventoryList.size(); i++) {
            Item item = this.getItemAt(i);

            String itemName = item.getName();
            String itemaAppearance = item.getAppearance();
            int itemValue = item.getValue();

            for (int j = 0; j < tableInfo.length(); j++) {
                tableInfo += "-";
            }
            tableInfo += "\n";

            Formatter formatter = new Formatter();
            tableInfo += formatter.format("| %2d | %20s | %20s | %5d |\n", i, itemName, itemaAppearance, itemValue);
        }

        for (int j = 0; j < tableLen; j++) {
            tableInfo += "-";
        }

        tableInfo += "\n";
        System.out.println(tableInfo);
        return tableInfo;

    }

    public Item getItemAt(int index) {
        return this.inventoryList.get(index);
    }

    public void printContent() {
        for (Item item : inventoryList) {
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                int itemDamage = weapon.getDamage();
                System.out.println(" Name = " + item.getName() + "\n" + "Appearance = " + item.getAppearance() + "\n"
                        + "Value = " + item.getValue() + "\n" + "Damage = " + itemDamage);
            } else if (item instanceof Armor) {
                Armor armor = (Armor) item;
                int itemDefense = armor.getDefense();
                System.out.println(" Name = " + item.getName() + "\n" + "Appearance = " + item.getAppearance() + "\n"
                        + "Value = " + item.getValue() + "\n" + "Defense = " + itemDefense);
            } else {
                System.out.println(" Name = " + item.getName() + "\n" + "Appearance = " + item.getAppearance() + "\n"
                        + "Value = " + item.getValue() + "\n");
            }
            System.out.println("-------------");

        }
    }

}
