package appwork.almayce.pencilpuzzle.model.main;

/**
 * Created by almayce on 27.06.17.
 */

public class MainItem {

    private String name;
    private float xPos;
    private float yPos;

    public MainItem(String name, float xPos, float yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String getName() {
        return name;
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }
}
