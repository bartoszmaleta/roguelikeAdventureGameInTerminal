package app;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // to change
    public void goDown() {
        if (this.y + 1 > 30) {
            this. y = y;
        } else {
            this.y += 1;
        }
    }

    public void goUp() {
        if (this.y - 1 < 0) {
            this.y = y;
        } else {
            this.y += -1;

        }
    }

    public void goRight() {
        if (this.x + 1 > 114) {
            this.x = x;
        } else {
            this.x += 1;
        }
    }

    public void goLeft() {
        if (this.x - 1 < 0) {
            this.x = x;
        } else {
            this.x += -1;

        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
