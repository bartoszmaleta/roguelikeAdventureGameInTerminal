package app.items;

public class Armor extends Item {
    private int defense;

    public Armor(String name, int defense, int value, String appearence) {
        super(name, value, appearence);
        this.defense = defense;
    }
    
}
