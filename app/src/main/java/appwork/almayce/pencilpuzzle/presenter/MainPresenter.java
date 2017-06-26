package appwork.almayce.pencilpuzzle.presenter;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.model.item.ItemChar;
import appwork.almayce.pencilpuzzle.model.item.ItemCharsCollection;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;
import appwork.almayce.pencilpuzzle.view.MainView;

/**
 * Created by almayce on 08.06.17.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private ItemCharsCollection itemCharsCollection;

    public MainPresenter() {
        itemCharsCollection = new ItemCharsCollection();
    }

    public void setItems() {
        AsyncTask<Void, ItemChar, Void> asyncTask = new AsyncTask<Void, ItemChar, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                for (int o = 0; o< itemCharsCollection.getItemCharList().size(); o++)
                    publishProgress(itemCharsCollection.getItemCharList().get(o));
                return null;
            }

            @Override
            protected void onProgressUpdate(ItemChar... values) {
                getViewState().setItem(values[0]);
            }

        };
        asyncTask.execute();
    }

    public void onItemClick(String name, Sounds sound) {
        AsyncTask<Void, Sounds, Void> asyncTask = new AsyncTask<Void, Sounds, Void>() {

            @Override
            protected void onPreExecute() {
                getViewState().startItemActivity(name);
            }

            @Override
            protected Void doInBackground(Void... params) {
                if (!App.isCancelled)
                    publishProgress(Sounds.voice_pencil);
                if (!App.isCancelled)
                    waitMillis(3800);
                if (!App.isCancelled)
                    publishProgress(sound);
                return null;
            }

            @Override
            protected void onProgressUpdate(Sounds... values) {
                App.getSoundManagerInstance().playSound(values[0]);
            }
        };
        asyncTask.execute();
    }

    private void waitMillis(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
