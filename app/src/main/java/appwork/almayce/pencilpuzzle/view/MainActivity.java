package appwork.almayce.pencilpuzzle.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import appwork.almayce.pencilpuzzle.AdManager;
import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.databinding.ActivityMainBinding;
import appwork.almayce.pencilpuzzle.databinding.LayoutDialogBinding;
import appwork.almayce.pencilpuzzle.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    private ActivityMainBinding binding;
    private InterstitialAd ad;
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        App.hideSystemUI(getWindow());
        initMenu();
        initAd();
    }

    public void onItemClick(View v) {
        play("neutral");
        mainPresenter.onItemClick(v);
    }

    private void initMenu() {
        binding.ivMenu.setOnClickListener(m -> {
            play("neutral");
            LayoutDialogBinding dialogBinding = DataBindingUtil
                    .inflate(LayoutInflater.from(this), R.layout.layout_dialog, null, false);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(dialogBinding.getRoot());

            // назад
            dialogBinding.ivMenuBack.setOnClickListener(v -> {
                play("neutral");
                showAdforBackButton();
            });

            // родителям
            dialogBinding.ivMenuBtn1.setOnClickListener(v -> {
                play("neutral");
                Intent intent = new Intent(getApplicationContext(), ParentActivity.class);
                startActivity(intent);
            });

            // убрать рекламу
            dialogBinding.ivMenuBtn2.setOnClickListener(v -> {
                play("neutral");
                Intent intent = new Intent(getApplicationContext(), AdActivity.class);
                startActivity(intent);
            });

            // наши приложения
            dialogBinding.ivMenuBtn3.setOnClickListener(v -> {
                play("neutral");
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=IFOLICA"));
                browserIntent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivity(browserIntent);
            });

            // выйти из игры
            dialogBinding.ivMenuBtn4.setOnClickListener(v -> {
                play("neutral");
                showAdforExitButton();
            });

            builder.setCancelable(false);
            alert = builder.create();
            alert.show();
            alert.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.stopSound();
    }

    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, boolean bool) {
        bool = false;
        try {
            bool = App.getProgressManagerInstance().getProgress().contains(view.getContentDescription().toString());
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }

        view.setVisibility(bool ? View.VISIBLE : View.GONE);
    }

    @Override
    public void startCharActivity(String name) {
        Intent intent = new Intent(this, CharActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (alert != null)
            alert.cancel();
    }

    private void initAd() {
        ad = new InterstitialAd(getApplicationContext());
        ad.setAdUnitId(getString(R.string.inter_ad_unit_id));
        ad.loadAd(new AdRequest.Builder().build());
        com.google.android.gms.ads.AdView adView = (AdView) findViewById(R.id.adView);
        adView.setVisibility(AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()) ? View.VISIBLE : View.INVISIBLE);
        adView.loadAd(new AdRequest.Builder().build());
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

    @Override
    public void play(String s) {
        mainPresenter.playSound(s);
    }

    private void pressHome() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
    }
}
