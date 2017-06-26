package appwork.almayce.pencilpuzzle.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import appwork.almayce.pencilpuzzle.AdManager;
import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.databinding.ActivityAdBinding;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;
import appwork.almayce.pencilpuzzle.presenter.AdPresenter;

/**
 * Created by almayce on 11.06.17.
 */

public class AdActivity extends MvpAppCompatActivity implements Soundable, AdView, BillingProcessor.IBillingHandler {

    @InjectPresenter
    AdPresenter adPresenter;

    private ActivityAdBinding binding;
    private BillingProcessor bp;

    @Override
    protected void onResume() {
        super.onResume();
        checkTimer();
        App.loadRewardedVideoAd();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSystemUI();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ad);
        bp = new BillingProcessor(this, "YOUR LICENSE KEY FROM GOOGLE PLAY CONSOLE HERE", this); // // TODO: 13.06.17

        checkTimer();

        DisplayMetrics displayMetrics = App.displayMetrics;
        binding.rlMenu.getLayoutParams().width = (int) (displayMetrics.widthPixels / 1.14);
        binding.rlAd1.getLayoutParams().width = (int) (displayMetrics.widthPixels / 3.32);
        binding.rlAd1.getLayoutParams().height = (int) (displayMetrics.widthPixels / 3.32);
        binding.rlAd2.getLayoutParams().width = (int) (displayMetrics.widthPixels / 3.32);
        binding.rlAd2.getLayoutParams().height = (int) (displayMetrics.widthPixels / 3.32);
        binding.rlExit.setOnClickListener(v -> {
            playSound(Sounds.neutral);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
       finish();
        });

        // просмотр ролика
        binding.rlAd1.setOnClickListener(v -> {
            playSound(Sounds.neutral);
            App.showRewardedVideo(this);
        });

        // покупка приложения
        binding.rlAd2.setOnClickListener(v -> {
            playSound(Sounds.neutral);
            if (BillingProcessor.isIabServiceAvailable(getApplicationContext()))
                bp.purchase(this, "YOUR PRODUCT ID FROM GOOGLE PLAY CONSOLE HERE"); // // TODO: 13.06.17
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

    public void checkTimer() {
        if (AdManager.getInstance().getUnblockAdMillis() < System.currentTimeMillis() * 2) {
            binding.tvTimer.setText(printString(getHoursAndMinutes(AdManager.getInstance().getUnblockAdMillis() - System.currentTimeMillis())));
        } else binding.tvTimer.setText("Реклама отключена");
    }

    private String printString(int[] i) {
        if (i[0] <= 0 || i[1] <= 0)
            return "";
        return "Без рекламы: " + i[0] + ":" + i[1];
    }

    private int[] getHoursAndMinutes(long millis) {
        int sec = (int) millis / 1000;
        int hours = sec / 3600 % 24;
        int minutes = sec / 60 % 60;
        return new int[]{hours, minutes};
    }

    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
    }

    // billing
    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        AdManager.getInstance().setOffAdMillis();
        App.getProgressManagerInstance().saveMillis();
    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {

    }

    @Override
    public void onBillingInitialized() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void playSound(Sounds sound) {
        App.getSoundManagerInstance().playSound(sound);
    }
}
