package appwork.almayce.pencilpuzzle.model.item;

/**
 * Created by almayce on 22.06.17.
 */

public class Part {
    private float xPos;
    private float yPos;

    private float xPosEnd;
    private float yPosEnd;

    public Part(float xPos, float yPos, float xPosEnd, float yPosEnd) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xPosEnd = xPosEnd;
        this.yPosEnd = yPosEnd;
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public float getxPosEnd() {
        return xPosEnd;
    }

    public float getyPosEnd() {
        return yPosEnd;
    }
}
