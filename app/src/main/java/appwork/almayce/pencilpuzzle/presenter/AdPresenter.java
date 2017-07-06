package appwork.almayce.pencilpuzzle.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import appwork.almayce.pencilpuzzle.AdManager;
import appwork.almayce.pencilpuzzle.view.AdView;

/**
 * Created by almayce on 11.06.17.
 */

@InjectViewState
public class AdPresenter extends MvpPresenter<AdView> {
    public void checkTimer() {
        if (AdManager.getInstance().getUnblockAdMillis() < System.currentTimeMillis() * 2) {
            getViewState().checkTimer(printString(getHoursAndMinutes(AdManager.getInstance().getUnblockAdMillis() - System.currentTimeMillis())));
        } else getViewState().checkTimer("Реклама отключена");

    }
    private String printString(int[] i) {
        if (i[1] <= 0)
            return "";
        return "Без рекламы: " + i[0] + ":" + i[1];
    }

    private int[] getHoursAndMinutes(long millis) {
        int sec = (int) millis / 1000;
        int hours = sec / 3600 % 24;
        int minutes = sec / 60 % 60;
        return new int[]{hours, minutes};
    }

}
