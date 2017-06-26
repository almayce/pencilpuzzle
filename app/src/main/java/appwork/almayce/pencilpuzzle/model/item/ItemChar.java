package appwork.almayce.pencilpuzzle.model.item;

import appwork.almayce.pencilpuzzle.model.sound.Sounds;

/**
 * Created by almayce on 08.06.17.
 */

public class ItemChar {
    private String name;
    private Sounds sound;

    private int layoutId;
    private int viewId;

    public ItemChar(String name, Sounds sound, int layoutId, int viewId) {
        this.name = name;
        this.sound = sound;
        this.layoutId = layoutId;
        this.viewId = viewId;
    }

    public String getName() {
        return name;
    }

    public Sounds getSound() {
        return sound;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public int getViewId() {
        return viewId;
    }
}
