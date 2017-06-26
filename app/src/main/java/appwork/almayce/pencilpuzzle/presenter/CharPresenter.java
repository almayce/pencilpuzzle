package appwork.almayce.pencilpuzzle.presenter;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;
import appwork.almayce.pencilpuzzle.view.CharView;

/**
 * Created by almayce on 09.06.17.
 */
@InjectViewState
public class CharPresenter extends MvpPresenter<CharView> {
    AsyncTask<Void, Sounds, Void> asyncTask = new AsyncTask<Void, Sounds, Void>() {

        List<Sounds> soundsList = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            soundsList.add(Sounds.well_done);
            soundsList.add(Sounds.well_done_voice1);
            soundsList.add(Sounds.try_again);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (int o = 0; o < soundsList.size(); o++) {
                if (!App.isCancelled) {
                    publishProgress(soundsList.get(o));
                    waitSecond();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Sounds... values) {
            getViewState().playSound(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (!App.isCancelled)
            getViewState().restartActivity();

        }

        @Override
        protected void onCancelled() {
        }
    };

    public void onDone() {
        asyncTask.execute();
    }

    public void onClickExit() {
        App.isCancelled = true;
        getViewState().backToMainActivity();
    }

    private void waitSecond() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
