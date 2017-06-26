package appwork.almayce.pencilpuzzle.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import appwork.almayce.pencilpuzzle.model.item.ItemChar;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;

/**
 * Created by almayce on 08.06.17.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {
    void setItem(ItemChar item);
    void startItemActivity(String name);
    void playSound(Sounds sound);
}
