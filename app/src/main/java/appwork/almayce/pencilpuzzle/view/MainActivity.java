package appwork.almayce.pencilpuzzle.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import appwork.almayce.pencilpuzzle.AdManager;
import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.databinding.ActivityMainBinding;
import appwork.almayce.pencilpuzzle.databinding.LayoutDialogBinding;
import appwork.almayce.pencilpuzzle.model.item.ItemChar;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;
import appwork.almayce.pencilpuzzle.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements Soundable, MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    private ActivityMainBinding binding;
    private InterstitialAd ad;
    private AlertDialog alert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSystemUI();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.getWindowManager().getDefaultDisplay().getMetrics(App.displayMetrics);
        initAd();

        int h = (int) (App.displayMetrics.heightPixels / 1.55);
        int w = (int) (App.displayMetrics.heightPixels * 1.55);

        binding.llPlayGround.getLayoutParams().width = w;
        binding.llPlayGround.getLayoutParams().height = h;
        binding.rlMain.getLayoutParams().width = w;
        binding.rlMenu.setOnClickListener(m -> {
            hideSystemUI();
            playSound(Sounds.neutral);
            LayoutDialogBinding dialogBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(this), R.layout.layout_dialog, null, false);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(dialogBinding.getRoot());
            dialogBinding.llMenuActiveZone.getLayoutParams().width = dialogBinding.ivMenuActiveZome.getLayoutParams().width;

            // назад
            dialogBinding.tr1.setOnClickListener(v -> {
                dialogBinding.llMenuActiveZone.setVisibility(View.INVISIBLE);
                playSound(Sounds.neutral);
                showAdforBackButton();
            });

            // родителям
            dialogBinding.tr2.setOnClickListener(v -> {
                dialogBinding.llMenuActiveZone.setVisibility(View.INVISIBLE);
                playSound(Sounds.neutral);
                Intent intent = new Intent(getApplicationContext(), ParentActivity.class);
                startActivity(intent);
            });

            // убрать рекламу
            dialogBinding.tr3.setOnClickListener(v -> {
                dialogBinding.llMenuActiveZone.setVisibility(View.INVISIBLE);
                playSound(Sounds.neutral);
                Intent intent = new Intent(getApplicationContext(), AdActivity.class);
                startActivity(intent);
            });

            // наши приложения
            dialogBinding.tr4.setOnClickListener(v -> {
                dialogBinding.llMenuActiveZone.setVisibility(View.INVISIBLE);
                playSound(Sounds.neutral);
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=IFOLICA"));
               browserIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(browserIntent);
            });

            // выйти из игры
            dialogBinding.tr5.setOnClickListener(v -> {
                dialogBinding.llMenuActiveZone.setVisibility(View.INVISIBLE);
                playSound(Sounds.neutral);
                showAdforExitButton();
            });

            builder.setCancelable(false);
            alert = builder.create();
            alert.show();
            alert.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        });

        binding.adView.setVisibility(AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()) ? View.VISIBLE : View.INVISIBLE);
        binding.adView.loadAd(new AdRequest.Builder().build());
        mainPresenter.setItems();
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


    @Override
    public void setItem(ItemChar item) {
        if (App.getProgressManagerInstance().getProgress().contains(item.getName())) {
            ImageView iv = (ImageView) findViewById(item.getViewId());
            iv.setImageResource(R.drawable.star);
            iv.getLayoutParams().width = (int) (App.displayMetrics.heightPixels / 18);
            iv.getLayoutParams().height = (int) (App.displayMetrics.heightPixels / 18);
        }
        findViewById(item.getLayoutId()).setOnClickListener(v -> {
            App.isCancelled = false;
            mainPresenter.onItemClick(item.getName(), item.getSound());
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (alert != null)
        alert.cancel();
    }

    @Override
    public void startItemActivity(String name) {
        Intent intent = new Intent(this, CharActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    private void initAd() {
        ad = new InterstitialAd(getApplicationContext());
        ad.setAdUnitId(getString(R.string.inter_ad_unit_id));
        ad.loadAd(new AdRequest.Builder().build());
    }

    private void showAdforBackButton() {
        if (AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()) && ad.isLoaded()) {
            ad.show();
            ad.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    ad.setAdListener(null);
                    ad.loadAd(new AdRequest.Builder().build());
                    alert.cancel();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            });
        } else
            alert.cancel();
    }

    private void showAdforExitButton() {
        if (AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()) && ad.isLoaded()) {
            ad.show();
            ad.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    ad.setAdListener(null);
                    ad.loadAd(new AdRequest.Builder().build());
                    pressHome();
                }
            });
        } else
            pressHome();
    }

    private void pressHome() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    @Override
    public void playSound(Sounds sound) {
        App.getSoundManagerInstance().playSound(sound);
    }

    @Override
    public void onBackPressed() {
    }
}
