package appwork.almayce.pencilpuzzle.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import appwork.almayce.pencilpuzzle.AdManager;
import appwork.almayce.pencilpuzzle.App;
import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.databinding.ActivityCharBinding;
import appwork.almayce.pencilpuzzle.model.item.PartsCollection;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;
import appwork.almayce.pencilpuzzle.presenter.CharPresenter;

/**
 * Created by almayce on 09.06.17.
 */

public class CharActivity extends MvpAppCompatActivity implements Soundable, CharView {

    @InjectPresenter
    CharPresenter charPresenter;

    private ActivityCharBinding binding;
    private InterstitialAd ad;

    private List<ImageView> slots;
    private int counter = 0;
    private final int itemSide = (int) (App.displayMetrics.heightPixels / 1.8);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hideSystemUI();

        slots = new ArrayList<>();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_char);

        initAd();

        slots.add(null);
        slots.add(binding.ivPart1);
        slots.add(binding.ivPart2);
        slots.add(binding.ivPart3);
        slots.add(binding.ivPart4);
        slots.add(binding.ivPart5);

        binding.ivChar.getLayoutParams().width = itemSide;
        binding.ivChar.getLayoutParams().height = itemSide;
        binding.ivPart1.getLayoutParams().width = itemSide;
        binding.ivPart1.getLayoutParams().height = itemSide;
        binding.ivPart2.getLayoutParams().width = itemSide;
        binding.ivPart2.getLayoutParams().height = itemSide;
        binding.ivPart3.getLayoutParams().width = itemSide;
        binding.ivPart3.getLayoutParams().height = itemSide;
        binding.ivPart4.getLayoutParams().width = itemSide;
        binding.ivPart4.getLayoutParams().height = itemSide;
        binding.ivPart5.getLayoutParams().width = itemSide;
        binding.ivPart5.getLayoutParams().height = itemSide;

        setCharImageView();
        setPartsImageView();

        binding.adView.loadAd(new AdRequest.Builder().build());
        binding.adView.setVisibility(AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()) ? View.VISIBLE : View.INVISIBLE);
        binding.ivExit.getLayoutParams().height = (int) (App.displayMetrics.heightPixels / 5);
        binding.ivExit.getLayoutParams().width = (int) (App.displayMetrics.heightPixels / 5);
        binding.ivExit.setOnClickListener(v -> {
            charPresenter.onClickExit();
            binding.ivExit.setOnClickListener(null);
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

    private void initAd() {
        ad = new InterstitialAd(getApplicationContext());
        ad.setAdUnitId(getString(R.string.inter_ad_unit_id));
        ad.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        ad.loadAd(new AdRequest.Builder().build());
    }

    private void setCharImageView() {
        StringBuilder path = new StringBuilder();
        path.append("chars/").append(getIntent().getStringExtra("name")).append(".png");
        try {
            // get input stream
            InputStream ims = getAssets().open(path.toString());
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            binding.ivChar.setImageDrawable(d);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void setPartsImageView() {
        PartsCollection parts = new PartsCollection();
        StringBuilder path = new StringBuilder();
        String current = getIntent().getStringExtra("name");
        for (int o = 1; o < 6; o++) {
            try {
                path.append("chars/")
                        .append(current)
                        .append("/")
                        .append(current)
                        .append(o).append(".png");
                // get input stream
                InputStream ims = getAssets().open(path.toString());
                path.setLength(0);
                // load image as Drawable
                Drawable d = Drawable.createFromStream(ims, null);

                float w = App.displayMetrics.widthPixels / App.displayMetrics.xdpi;
                float h = App.displayMetrics.heightPixels / App.displayMetrics.ydpi;
//                float q = 0.0F;
//                if (w > h) q = w / h;
//                else q = h / w;
//                System.out.println(w);

                float scaleX = w / 17.5F * App.displayMetrics.density;
                float scaleY = h / 12.0F * App.displayMetrics.density;

//                if (q > 1.7) {
//                     16.9
//                    scaleX = 0.95F;
//                    scaleY = 0.80F;
//                } else if (q < 1.7 && q > 1.5) {
//                     16:9
//                    scaleX = 0.75F;
//                    scaleY = 0.60F;
//                } else if (q < 1.5 && q > 1.3) {
//                     4:3
//                    scaleX = 1.50F;
//                    scaleY = 1.20F;
//                } else if (q < 1.3) {
//                     4:3
//                    scaleX = 1.50F;
//                    scaleY = 1.20F;
//                }

                StringBuilder partName = new StringBuilder();
                partName.append(current).append(o);
                slots.get(o).setX(scaleX * parts.getxPos(partName.toString()));
                slots.get(o).setY(scaleY * parts.getyPos(partName.toString()));
                slots.get(o).setImageDrawable(d);
                slots.get(o).setOnTouchListener(onTouchListener);
                partName.setLength(0);
                counter++;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        float startX;
        float startY;

        int tolerance = 40;
        float dX, dY;

        @Override
        public boolean onTouch(View view, MotionEvent event) {

            boolean doneX = false;
            boolean doneY = false;

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:
                    startX = view.getX();
                    startY = view.getY();
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    view.setX(event.getRawX() + dX);
                    view.setY(event.getRawY() + dY);
                    break;

                case MotionEvent.ACTION_UP:
                    float x = view.getX() + (view.getWidth() / 2);
                    float y = view.getY() + (view.getHeight() / 2);
                    float centerX = binding.ivChar.getX() + (binding.ivChar.getWidth() / 2);
                    float centerY = binding.ivChar.getY() + (binding.ivChar.getHeight() / 2);

                    if (x > centerX - tolerance && x < centerX + tolerance)
                        doneX = true;
                    if (y > centerY - tolerance && y < centerY + tolerance)
                        doneY = true;
                    if (doneX && doneY) {

                        view.setX(centerX - (view.getWidth() / 2));
                        view.setY(centerY - (view.getHeight() / 2));

                        playSound(Sounds.correctly);
                        counter--;
                        view.setOnTouchListener(null);

                        if (counter == 0) {
                            App.getProgressManagerInstance().saveProgress(getIntent().getStringExtra("name"));
                            charPresenter.onDone();
                        }

                    } else {
                        playSound(Sounds.wrong);
                        view.setX(startX);
                        view.setY(startY);
                    }

                default:
                    return false;
            }
            return true;
        }
    };

    @Override
    public void playSound(Sounds sound) {
        App.getSoundManagerInstance().playSound(sound);
    }

    @Override
    public void restartActivity() {
        Intent i = new Intent(this, this.getClass());
        i.putExtra("name", getIntent().getStringExtra("name"));
        finish();
        this.startActivity(i);
    }

    @Override
    public void backToMainActivity() {
        playSound(Sounds.neutral);
        showAd();
    }

    public void showAd() {
        if (AdManager.getInstance().itIsTimeToShowAds(System.currentTimeMillis()) && ad.isLoaded())
            ad.show();
        else startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onBackPressed() {
    }
}
