package appwork.almayce.pencilpuzzle.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import appwork.almayce.pencilpuzzle.AdManager;
import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.databinding.ActivityAdBinding;
import appwork.almayce.pencilpuzzle.presenter.AdPresenter;

/**
 * Created by almayce on 11.06.17.
 */

public class AdActivity extends MvpAppCompatActivity implements AdView, BillingProcessor.IBillingHandler {

    @InjectPresenter
    AdPresenter adPresenter;

    private ActivityAdBinding binding;
    private BillingProcessor bp;

    @Override
    protected void onResume() {
        super.onResume();
        adPresenter.checkTimer();
        App.loadRewardedVideoAd();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.hideSystemUI(getWindow());
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ad);
        bp = new BillingProcessor(this, "YOUR LICENSE KEY FROM GOOGLE PLAY CONSOLE HERE", this); // // TODO: 13.06.17
        adPresenter.checkTimer();
        binding.rlExit.setOnClickListener(v -> {
            App.playSound("neutral");
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
       finish();
        });

        // просмотр ролика
        binding.rlAd1.setOnClickListener(v -> {
            App.playSound("neutral");
            App.showRewardedVideo(this);
        });

        // покупка приложения
        binding.rlAd2.setOnClickListener(v -> {
            App.playSound("neutral");
            if (BillingProcessor.isIabServiceAvailable(getApplicationContext()))
                bp.purchase(this, "YOUR PRODUCT ID FROM GOOGLE PLAY CONSOLE HERE"); // // TODO: 13.06.17
        });
    }

    public void checkTimer(String timerText) {
       binding.tvTimer.setText(timerText);
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
}
