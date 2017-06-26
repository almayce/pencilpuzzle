package appwork.almayce.pencilpuzzle;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by almayce on 11.06.17.
 */

public class ProgressManager {

    private StringBuilder progress;
    private SharedPreferences sharedPreferences;

    public ProgressManager(Context context) {
        progress = new StringBuilder();
        sharedPreferences = context.getSharedPreferences("Progress", MODE_PRIVATE);
    }

    public void saveMillis() {
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putLong("unBlockAdMillis", AdManager.getInstance().getUnblockAdMillis());
        ed.apply();
    }

    public long loadMillis() {
        try {
             sharedPreferences.getLong("unBlockAdMillis", 0);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return System.currentTimeMillis();
    }

    public void saveProgress(String done) {
        SharedPreferences.Editor ed = sharedPreferences.edit();
        if (!progress.toString().contains(done)) {
            progress.append(done).append(" ");
            ed.putString("progress", progress.toString());
            ed.apply();
        }
    }

    public void loadProgress() {
        try {
            progress.setLength(0);
            progress.append(sharedPreferences.getString("progress", ""));
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    public String getProgress() {
        return progress.toString();
    }
}
