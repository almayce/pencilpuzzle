package appwork.almayce.pencilpuzzle.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;
import java.util.concurrent.TimeUnit;

import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.SchedulersTransformer;
import appwork.almayce.pencilpuzzle.model.item.Markers;
import appwork.almayce.pencilpuzzle.view.CharView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by almayce on 09.06.17.
 */
@InjectViewState
public class CharPresenter extends MvpPresenter<CharView> {

    private Disposable disposable;
    private Markers markers = new Markers();

    public void onDone() {
        App.isDone = true;
        disposable = Observable.interval(1, TimeUnit.MILLISECONDS)
                .compose(new SchedulersTransformer<>())
                .subscribe(aLong -> {
                    if (aLong == 1)
                        App.playSound("well_done");
                    if (aLong == 1000)
                        App.playSound("well_done_voice1");
                    if (aLong == 2000)
                        App.playSound("try_again");
                    if (aLong == 2500)
                        getViewState().restartActivity();
                    if (App.isCancelled || aLong > 3000)
                        disposable.dispose();
                });
    }

    public void addMarkers(String name) {
        List<Integer> markersArray = markers.getMarkers(name);
        Observable.range(0, markersArray.size())
                .compose(new SchedulersTransformer<>())
                .subscribe(integer -> {
                    getViewState().addMarker(markersArray.get(integer));
                });


    }

    public void playSound(String name) {
        App.playSound(name);
    }

    public void stopSound() {
        App.stopSound();
    }

    public void onClickExit() {
        App.stopSound();
        App.isCancelled = true;
        getViewState().backToMainActivity();
    }
}
