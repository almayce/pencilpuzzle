package appwork.almayce.pencilpuzzle;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by almayce on 13.06.17.
 */

public class App extends Application implements RewardedVideoAdListener {

    private static ProgressManager progressManager;

    private static RewardedVideoAd rewardedVideoAd;
    private static AdRequest.Builder builder;

    public static boolean isCancelled = false;
    public static boolean isDone = false;

    @Override
    public void onCreate() {
        super.onCreate();
        initSoundPool(getApplicationContext());
        progressManager = new ProgressManager(getApplicationContext());

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

    public static ProgressManager getProgressManagerInstance() {
        return progressManager;
    }

    public static RewardedVideoAd getRewardedVideoAdInstance() {
        return rewardedVideoAd;
    }


    public static void hideSystemUI(Window window) {
        // TODO: 06.07.17
//        window.getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LOW_PROFILE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE);


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

    private static SoundPool sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 100);

    private static Map<String, Integer> soundMap = new HashMap<>();

    public void initSoundPool(Context context) {
        try {
            soundMap.put("А", sp.load(context.getAssets().openFd("sounds/bukva_А.mp3"), 1));
            soundMap.put("Б", sp.load(context.getAssets().openFd("sounds/bukva_Б.mp3"), 1));
            soundMap.put("В", sp.load(context.getAssets().openFd("sounds/bukva_В.mp3"), 1));
            soundMap.put("Г", sp.load(context.getAssets().openFd("sounds/bukva_Г.mp3"), 1));
            soundMap.put("Д", sp.load(context.getAssets().openFd("sounds/bukva_Д.mp3"), 1));
            soundMap.put("Е", sp.load(context.getAssets().openFd("sounds/bukva_Е.mp3"), 1));
            soundMap.put("Ё", sp.load(context.getAssets().openFd("sounds/bukva_Ё.mp3"), 1));
            soundMap.put("Ж", sp.load(context.getAssets().openFd("sounds/bukva_Ж.mp3"), 1));
            soundMap.put("З", sp.load(context.getAssets().openFd("sounds/bukva_З.mp3"), 1));
            soundMap.put("И", sp.load(context.getAssets().openFd("sounds/bukva_И.mp3"), 1));
            soundMap.put("Й", sp.load(context.getAssets().openFd("sounds/bukva_Й.mp3"), 1));
            soundMap.put("К", sp.load(context.getAssets().openFd("sounds/bukva_К.mp3"), 1));
            soundMap.put("Л", sp.load(context.getAssets().openFd("sounds/bukva_Л.mp3"), 1));
            soundMap.put("М", sp.load(context.getAssets().openFd("sounds/bukva_М.mp3"), 1));
            soundMap.put("Н", sp.load(context.getAssets().openFd("sounds/bukva_Н.mp3"), 1));
            soundMap.put("О", sp.load(context.getAssets().openFd("sounds/bukva_О.mp3"), 1));
            soundMap.put("П", sp.load(context.getAssets().openFd("sounds/bukva_П.mp3"), 1));
            soundMap.put("Р", sp.load(context.getAssets().openFd("sounds/bukva_Р.mp3"), 1));
            soundMap.put("С", sp.load(context.getAssets().openFd("sounds/bukva_С.mp3"), 1));
            soundMap.put("Т", sp.load(context.getAssets().openFd("sounds/bukva_Т.mp3"), 1));
            soundMap.put("У", sp.load(context.getAssets().openFd("sounds/bukva_У.mp3"), 1));
            soundMap.put("Ф", sp.load(context.getAssets().openFd("sounds/bukva_Ф.mp3"), 1));
            soundMap.put("Х", sp.load(context.getAssets().openFd("sounds/bukva_Х.mp3"), 1));
            soundMap.put("Ц", sp.load(context.getAssets().openFd("sounds/bukva_Ц.mp3"), 1));
            soundMap.put("Ч", sp.load(context.getAssets().openFd("sounds/bukva_Ч.mp3"), 1));
            soundMap.put("Ш", sp.load(context.getAssets().openFd("sounds/bukva_Ш.mp3"), 1));
            soundMap.put("Щ", sp.load(context.getAssets().openFd("sounds/bukva_Щ.mp3"), 1));
            soundMap.put("Ъ", sp.load(context.getAssets().openFd("sounds/bukva_Ъ.mp3"), 1));
            soundMap.put("Ы", sp.load(context.getAssets().openFd("sounds/bukva_Ы.mp3"), 1));
            soundMap.put("Ь", sp.load(context.getAssets().openFd("sounds/bukva_Ь.mp3"), 1));
            soundMap.put("Э", sp.load(context.getAssets().openFd("sounds/bukva_Э.mp3"), 1));
            soundMap.put("Ю", sp.load(context.getAssets().openFd("sounds/bukva_Ю.mp3"), 1));
            soundMap.put("Я", sp.load(context.getAssets().openFd("sounds/bukva_Я.mp3"), 1));

            soundMap.put("click", sp.load(context.getAssets().openFd("sounds/click.mp3"), 1));
            soundMap.put("neutral", sp.load(context.getAssets().openFd("sounds/neutral.mp3"), 1));
            soundMap.put("correctly", sp.load(context.getAssets().openFd("sounds/correctly.mp3"), 1));
            soundMap.put("try_again", sp.load(context.getAssets().openFd("sounds/try_again.mp3"), 1));
            soundMap.put("voice_pencil", sp.load(context.getAssets().openFd("sounds/voice_pencil.mp3"), 1));
            soundMap.put("well_done", sp.load(context.getAssets().openFd("sounds/well_done.mp3"), 1));
            soundMap.put("well_done_voice1", sp.load(context.getAssets().openFd("sounds/well_done_voice1.mp3"), 1));
            soundMap.put("wrong", sp.load(context.getAssets().openFd("sounds/wrong.mp3"), 1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> streamIdList = new ArrayList<>();

    public static void playSound(String name) {
        int streamId = sp.play(soundMap.get(name), 1, 1, 0, 0, 1);
        streamIdList.add(streamId);
    }

    public static void stopSound() {
        for (int id : streamIdList)
            sp.stop(id);
        streamIdList.clear();
    }
}
