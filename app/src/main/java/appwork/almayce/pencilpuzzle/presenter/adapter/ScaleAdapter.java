package appwork.almayce.pencilpuzzle.presenter.adapter;

/**
 * Created by almayce on 26.06.17.
 */

public class ScaleAdapter {

    public float adapt(int displayMetrics, int currentPosition, Coordinates coordinates) {

        int resolution = 0;
        float devider = 100;

        switch (coordinates) {
            case X:
                resolution = 1980;
                devider = 100;
                break;
            case Y:
                resolution = 1234;
                devider = 100;
                break;
        }

        float scale = displayMetrics / (resolution / 100);
        scale = scale / devider;
        return currentPosition * scale;
    }

    public float getxScale(int displayMetrics) {
        float a = displayMetrics / (1980 / 100);
        return a / 100 * 2;
    }
    public float getyScale(int displayMetrics) {
        float a = displayMetrics / (1234 / 100);
        return a / 100 * 2;
    }
}
