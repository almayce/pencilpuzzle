package appwork.almayce.pencilpuzzle.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by almayce on 08.06.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {
    void startCharActivity(String name);
    void play(String name);
}
