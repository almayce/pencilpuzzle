package appwork.almayce.pencilpuzzle.model.item;

/**
 * Created by almayce on 22.06.17.
 */

public class Part {
    private int xPos;
    private int yPos;

    public Part(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
