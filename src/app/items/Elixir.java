package app.items;

public class Elixir extends Item {
    private int healthToRestore;

    public Elixir(String name, int value, int healthToRestore) {
        super(name, value, "\uD83D\uDC88");
        // super(name, value, "\uD83E\uDDDC\uD83C\uDFFC\u200D\u2642\uFE0F"); // poseidon
        // super(name, value, "\uD83E\uDD96"); // t-rex


        // TODO Auto-generated constructor stub
        this.healthToRestore = healthToRestore;
    }

    public int getHealthToRestore() {
        return healthToRestore;
    }

    public void setHealthToRestore(int healthToRestore) {
        this.healthToRestore = healthToRestore;
    }

    




} 