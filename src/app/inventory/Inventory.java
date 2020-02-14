package app.inventory;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import app.items.Armor;
import app.items.Elixir;
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
        int tableLen = 71;
        tableInfo += "\n";

        for (int j = 0; j < tableLen; j++) {
            tableInfo += "-";
        }

        tableInfo += "\n";

        String index = "Index";
        String title = "Title";
        String appeal = "Icon";
        String value = "Value";
        String damage = "Damage";
        String defense = "Defense";

        Formatter formatterHeadline = new Formatter();
        tableInfo += formatterHeadline.format("| %5s | %20s | %6s | %5s | %8s | %8s |\n", index, title, appeal, value,
                damage, defense);

        for (int i = 0; i < inventoryList.size(); i++) {
            Item item = this.getItemAt(i);

            String itemName = item.getName();
            String itemaAppearance = item.getAppearance();
            int itemValue = item.getValue();

            for (int j = 0; j < tableLen; j++) {
                tableInfo += "-";
            }
            tableInfo += "\n";

            Formatter formatterItems = new Formatter();

            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                int itemDamage = weapon.getDamage();
                String itemDefense = "";

                tableInfo += formatterItems.format("| %5d | %20s | %7s | %5d | %8s | %8s |\n", i + 1, itemName,
                        itemaAppearance, itemValue, itemDamage, itemDefense);
            } else if (item instanceof Armor) {
                Armor armor = (Armor) item;
                String itemDamage = "";
                int itemDefense = armor.getDefense();

                tableInfo += formatterItems.format("| %5d | %20s | %7s | %5d | %8s | %8s |\n", i + 1, itemName,
                        itemaAppearance, itemValue, itemDamage, itemDefense);

            } else {
                String itemDamage = "";
                String itemDefense = "";
                tableInfo += formatterItems.format("| %5d | %20s | %7s | %5d | %8s | %8s |\n", i + 1, itemName,
                        itemaAppearance, itemValue, itemDamage, itemDefense);
            }
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

    // NOT USED
    public String printTableOld() {
        String tableInfo = "";
        int tableLen = 49;
        tableInfo += "\n";

        for (int j = 0; j < tableLen; j++) {
            tableInfo += "-";
        }

        tableInfo += "\n";

        String index = "Index";
        String title = "Title";
        String appeal = "Icon";
        String value = "Value";

        Formatter formatterHeadline = new Formatter();
        tableInfo += formatterHeadline.format("| %5s | %20s | %6s | %5s |\n", index, title, appeal, value);

        for (int i = 0; i < inventoryList.size(); i++) {
            Item item = this.getItemAt(i);

            String itemName = item.getName();
            String itemaAppearance = item.getAppearance();
            int itemValue = item.getValue();

            for (int j = 0; j < tableLen; j++) {
                tableInfo += "-";
            }
            tableInfo += "\n";

            Formatter formatter = new Formatter();
            tableInfo += formatter.format("| %5d | %20s | %7s | %5d |\n", i + 1, itemName, itemaAppearance, itemValue);
        }

        for (int j = 0; j < tableLen; j++) {
            tableInfo += "-";
        }

        tableInfo += "\n";
        System.out.println(tableInfo);
        return tableInfo;

    }

    public void printContent() {
        System.out.println("----------------------------");

        for (Item item : inventoryList) {
            if (item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                int itemDamage = weapon.getDamage();
                System.out.println("Name = " + item.getName() + "\n" + "Appearance = " + item.getAppearance() + "\n"
                        + "Value = " + item.getValue() + "\n" + "Damage = " + itemDamage + "");
            } else if (item instanceof Armor) {
                Armor armor = (Armor) item;
                int itemDefense = armor.getDefense();
                System.out.println("Name = " + item.getName() + "\n" + "Appearance = " + item.getAppearance() + "\n"
                        + "Value = " + item.getValue() + "\n" + "Defense = " + itemDefense + "");
            } else {
                System.out.println("Name = " + item.getName() + "\n" + "Appearance = " + item.getAppearance() + "\n"
                        + "Value = " + item.getValue() + "");
            }
            System.out.println("----------------------------");
        }
    }

    public Elixir findElixir() {
        for (Item item : getInventoryList()) {
            if (item instanceof Elixir) {
                Elixir elixir = (Elixir) item;
                return elixir;
            }
        }
        return null;
    }

}
