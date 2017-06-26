package appwork.almayce.pencilpuzzle;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import appwork.almayce.pencilpuzzle.model.sound.SoundManager;

/**
 * Created by almayce on 13.06.17.
 */

public class App extends Application implements RewardedVideoAdListener {

    private static SoundManager soundManager;
    private static ProgressManager progressManager;
    public static DisplayMetrics displayMetrics;

    private static RewardedVideoAd rewardedVideoAd;
    private static AdRequest.Builder builder;

    public static boolean isCancelled = false;

    @Override
    public void onCreate() {
        super.onCreate();
        soundManager = new SoundManager(getApplicationContext());
        progressManager = new ProgressManager(getApplicationContext());
        displayMetrics = new DisplayMetrics();

        progressManager.loadProgress();
        AdManager.getInstance().setUnblockAdMillis(progressManager.loadMillis());

        MobileAds.initialize(getApplicationContext(), getString(R.string.app_ad_unit_id));
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getApplicationContext());
        rewardedVideoAd.setRewardedVideoAdListener(this);

        loadRewardedVideoAd();
    }

    public static void loadRewardedVideoAd() {
        if (!rewardedVideoAd.isLoaded()) {
            builder = new AdRequest.Builder();
            builder.addTestDevice("E7726D22076690020302C090DC9108E3");
            rewardedVideoAd.loadAd("ca-app-pub-1516756348988094/5800086566", builder.build());
        }
    }

    public static SoundManager getSoundManagerInstance() {
        return soundManager;
    }

    public static ProgressManager getProgressManagerInstance() {
        return progressManager;
    }

    public static RewardedVideoAd getRewardedVideoAdInstance() {
        return rewardedVideoAd;
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        App.getRewardedVideoAdInstance().pause(this);
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        App.getRewardedVideoAdInstance().resume(this);
//    }

    public static void showRewardedVideo(Context context) {
        if (rewardedVideoAd.isLoaded()) {
            rewardedVideoAd.show();
        } else {
            Toast.makeText(context, "Ролик загружается, повторите еще раз", Toast.LENGTH_SHORT).show();
        }
        loadRewardedVideoAd();

    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {
    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        AdManager.getInstance().hourIncrement();
        progressManager.saveMillis();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }
}
