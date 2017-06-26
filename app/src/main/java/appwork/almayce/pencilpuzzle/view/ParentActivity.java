package appwork.almayce.pencilpuzzle.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.databinding.ActivityParentBinding;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;
import appwork.almayce.pencilpuzzle.presenter.ParentPresenter;

/**
 * Created by almayce on 11.06.17.
 */

public class ParentActivity extends MvpAppCompatActivity implements Soundable, ParentView {
    @InjectPresenter
    ParentPresenter parentPresenter;

    private ActivityParentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSystemUI();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parent);
        binding.rlExit.setOnClickListener(v -> {
            block();
            playSound(Sounds.neutral);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });

    }
    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    private void block() {
        binding.rlExit.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void playSound(Sounds sound) {
        App.getSoundManagerInstance().playSound(sound);
    }
}
