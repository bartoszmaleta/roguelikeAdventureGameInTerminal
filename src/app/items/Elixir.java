package app.items;

public class Elixir extends Item {
    private int healthToRestore;

    public Elixir(String name, int value, int healthToRestore) {
        super(name, value, "\uD83D\uDC88");
        this.healthToRestore = healthToRestore;
    }

    public int getHealthToRestore() {
        return healthToRestore;
    }

    public void setHealthToRestore(int healthToRestore) {
        this.healthToRestore = healthToRestore;
    }

    




} 