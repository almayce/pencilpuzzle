package appwork.almayce.pencilpuzzle.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import appwork.almayce.pencilpuzzle.AdManager;
import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.databinding.ActivityMenuBinding;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;
import appwork.almayce.pencilpuzzle.presenter.MenuPresenter;

/**
 * Created by almayce on 11.06.17.
 */

public class MenuActivity extends MvpAppCompatActivity implements Soundable, MenuView {
    @InjectPresenter
    MenuPresenter menuPresenter;

    private ActivityMenuBinding binding;
    private InterstitialAd ad;
    private boolean isExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSystemUI();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);

        DisplayMetrics displayMetrics = App.displayMetrics;
        binding.rlMenu.getLayoutParams().width = (int) (displayMetrics.widthPixels / 2.30);
        binding.rlMenu.setY(displayMetrics.widthPixels / 35);
        binding.rl1.getLayoutParams().height = (int) (displayMetrics.widthPixels / 11);
        binding.rl2.getLayoutParams().height = (int) (displayMetrics.widthPixels / 11);
        binding.rl3.getLayoutParams().height = (int) (displayMetrics.widthPixels / 11);
        binding.rl4.getLayoutParams().height = (int) (displayMetrics.widthPixels / 11);

        initAd();

        // назад
        binding.rlBack.setOnClickListener(v -> {
            block();
            showAd(false);
            playSound(Sounds.neutral);
        });

        // родителям
        binding.rl1.setOnClickListener(v -> {
            block();
            playSound(Sounds.neutral);
            Intent intent = new Intent(getApplicationContext(), ParentActivity.class);
            startActivity(intent);
        });

        // убрать рекламу
        binding.rl2.setOnClickListener(v -> {
            block();
            playSound(Sounds.neutral);
            Intent intent = new Intent(getApplicationContext(), AdActivity.class);
            startActivity(intent);
            binding.rl2.setOnClickListener(null);
        });

        // наши приложения
        binding.rl3.setOnClickListener(v -> {
            block();
            playSound(Sounds.neutral);
            Intent browserIntent = new
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Educational+Systems"));
            startActivity(browserIntent);
            binding.rl3.setOnClickListener(null);
        });

        // выйти из игры
        binding.rl4.setOnClickListener(v -> {
            block();
            showAd(true);
            playSound(Sounds.neutral);
            binding.rl4.setOnClickListener(null);
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
        binding.rlMenu.setVisibility(View.INVISIBLE);
    }

    private void initAd() {
        ad = new InterstitialAd(getApplicationContext());
        ad.setAdUnitId(getString(R.string.inter_ad_unit_id));
        ad.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (ad.isLoaded())
                    ad.show();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                if (isExit)
                    pressHome();
                else startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if (isExit)
                    pressHome();
                else startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }

    private void showAd(Boolean isExit) {
        this.isExit = isExit;

        if (AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()))
            ad.loadAd(new AdRequest.Builder().build());
        else {
            if (isExit)
                pressHome();
            else
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
    }

    private void pressHome() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void playSound(Sounds sound) {
        App.getSoundManagerInstance().playSound(sound);
    }
}
