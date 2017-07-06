package appwork.almayce.pencilpuzzle.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.databinding.ActivityParentBinding;
import appwork.almayce.pencilpuzzle.presenter.ParentPresenter;

/**
 * Created by almayce on 11.06.17.
 */

public class ParentActivity extends MvpAppCompatActivity implements ParentView {
    @InjectPresenter
    ParentPresenter parentPresenter;

    private ActivityParentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.hideSystemUI(getWindow());
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parent);
        binding.rlExit.setOnClickListener(v -> {
            block();
           App.playSound("neutral");
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });
    }

    private void block() {
        binding.rlExit.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
    }
}
