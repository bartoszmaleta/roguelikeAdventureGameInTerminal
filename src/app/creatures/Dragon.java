package app.creatures;

import java.util.List;

import app.Coordinates;
import app.inventory.Inventory;
import app.items.Armor;
import app.items.Helmet;
import app.items.Item;

public class Dragon extends Monster {
    private Inventory dragonInventory;

    public Dragon(List<Coordinates> coordinatesList, Inventory inventory) {
        super("*", coordinatesList, "Dragon", 30, inventory, 10, 150);
        
        // super.getInventory().addToInventory(new Helmet("Helm", 13, 65));;
        // this.dragonInventory = new Inventory();
        // fillDragonInventory();

        Item helmet = new Helmet("Helm", 13, 65);
        super.getInventory().addToInventory(helmet);
    }


    private void fillDragonInventory() {
        Item helmet = new Helmet("Helm", 13, 65);

    }

    // private void setDragonInventory() {
        // this.dragonInventory.addToInventory(helmet);
    // }

    public Inventory getDragonInventory() {
        Inventory dragInventory2 = new Inventory();
        Item helmet = new Helmet("Helm", 13, 65);
        dragInventory2.addToInventory(helmet);
        
        return dragInventory2;
    }

    public void setDragonInventory(Inventory dragonInventory) {
        this.dragonInventory = dragonInventory;
    }

    

}