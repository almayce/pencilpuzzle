package appwork.almayce.pencilpuzzle.model.sound;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

/**
 * Created by almayce on 05.06.17.
 */

public class SoundManager {

    private SoundPool sp;

    private int А;
    private int Б;
    private int В;
    private int Г;
    private int Д;
    private int Е;
    private int Ё;
    private int Ж;
    private int З;
    private int И;
    private int Й;
    private int К;
    private int Л;
    private int М;
    private int Н;
    private int О;
    private int П;
    private int Р;
    private int С;
    private int Т;
    private int У;
    private int Ф;
    private int Х;
    private int Ц;
    private int Ч;
    private int Ш;
    private int Щ;
    private int Ъ;
    private int Ы;
    private int Ь;
    private int Э;
    private int Ю;
    private int Я;

    private int click;
    private int neutral;
    private int correctly;
    private int try_again;
    private int voice_pencil;
    private int well_done;
    private int well_done_voice1;
    private int wrong;

    public SoundManager(Context context) {
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 100);
        try {
            А = sp.load(context.getAssets().openFd("sounds/bukva_А.mp3"), 1);
            Б = sp.load(context.getAssets().openFd("sounds/bukva_Б.mp3"), 1);
            В = sp.load(context.getAssets().openFd("sounds/bukva_В.mp3"), 1);
            Г = sp.load(context.getAssets().openFd("sounds/bukva_Г.mp3"), 1);
            Д = sp.load(context.getAssets().openFd("sounds/bukva_Д.mp3"), 1);
            Е = sp.load(context.getAssets().openFd("sounds/bukva_Е.mp3"), 1);
            Ё = sp.load(context.getAssets().openFd("sounds/bukva_Ё.mp3"), 1);
            Ж = sp.load(context.getAssets().openFd("sounds/bukva_Ж.mp3"), 1);
            З = sp.load(context.getAssets().openFd("sounds/bukva_З.mp3"), 1);
            И = sp.load(context.getAssets().openFd("sounds/bukva_И.mp3"), 1);
            Й = sp.load(context.getAssets().openFd("sounds/bukva_Й.mp3"), 1);
            К = sp.load(context.getAssets().openFd("sounds/bukva_К.mp3"), 1);
            Л = sp.load(context.getAssets().openFd("sounds/bukva_Л.mp3"), 1);
            М = sp.load(context.getAssets().openFd("sounds/bukva_М.mp3"), 1);
            Н = sp.load(context.getAssets().openFd("sounds/bukva_Н.mp3"), 1);
            О = sp.load(context.getAssets().openFd("sounds/bukva_О.mp3"), 1);
            П = sp.load(context.getAssets().openFd("sounds/bukva_П.mp3"), 1);
            Р = sp.load(context.getAssets().openFd("sounds/bukva_Р.mp3"), 1);
            С = sp.load(context.getAssets().openFd("sounds/bukva_С.mp3"), 1);
            Т = sp.load(context.getAssets().openFd("sounds/bukva_Т.mp3"), 1);
            У = sp.load(context.getAssets().openFd("sounds/bukva_У.mp3"), 1);
            Ф = sp.load(context.getAssets().openFd("sounds/bukva_Ф.mp3"), 1);
            Х = sp.load(context.getAssets().openFd("sounds/bukva_Х.mp3"), 1);
            Ц = sp.load(context.getAssets().openFd("sounds/bukva_Ц.mp3"), 1);
            Ч = sp.load(context.getAssets().openFd("sounds/bukva_Ч.mp3"), 1);
            Ш = sp.load(context.getAssets().openFd("sounds/bukva_Ш.mp3"), 1);
            Щ = sp.load(context.getAssets().openFd("sounds/bukva_Щ.mp3"), 1);
            Ъ = sp.load(context.getAssets().openFd("sounds/bukva_Ъ.mp3"), 1);
            Ы = sp.load(context.getAssets().openFd("sounds/bukva_Ы.mp3"), 1);
            Ь = sp.load(context.getAssets().openFd("sounds/bukva_Ь.mp3"), 1);
            Э = sp.load(context.getAssets().openFd("sounds/bukva_Э.mp3"), 1);
            Ю = sp.load(context.getAssets().openFd("sounds/bukva_Ю.mp3"), 1);
            Я = sp.load(context.getAssets().openFd("sounds/bukva_Я.mp3"), 1);

            click = sp.load(context.getAssets().openFd("sounds/click.mp3"), 1);
            neutral = sp.load(context.getAssets().openFd("sounds/neutral.mp3"), 1);
            correctly = sp.load(context.getAssets().openFd("sounds/correctly.mp3"), 1);
            try_again = sp.load(context.getAssets().openFd("sounds/try_again.mp3"), 1);
            voice_pencil = sp.load(context.getAssets().openFd("sounds/voice_pencil.mp3"), 1);
            well_done = sp.load(context.getAssets().openFd("sounds/well_done.mp3"), 1);
            well_done_voice1 = sp.load(context.getAssets().openFd("sounds/well_done_voice1.mp3"), 1);
            wrong = sp.load(context.getAssets().openFd("sounds/wrong.mp3"), 1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playSound(String name) {
        switch (name) {
            case "А": sp.play(А, 1, 1, 0, 0, 1); break;
            case "Б": sp.play(Б, 1, 1, 0, 0, 1); break;
            case "В": sp.play(В, 1, 1, 0, 0, 1); break;
            case "Г": sp.play(Г, 1, 1, 0, 0, 1); break;
            case "Д": sp.play(Д, 1, 1, 0, 0, 1); break;
            case "Е": sp.play(Е, 1, 1, 0, 0, 1); break;
            case "Ё": sp.play(Ё, 1, 1, 0, 0, 1); break;
            case "Ж": sp.play(Ж, 1, 1, 0, 0, 1); break;
            case "З": sp.play(З, 1, 1, 0, 0, 1); break;
            case "И": sp.play(И, 1, 1, 0, 0, 1); break;
            case "Й": sp.play(Й, 1, 1, 0, 0, 1); break;
            case "К": sp.play(К, 1, 1, 0, 0, 1); break;
            case "Л": sp.play(Л, 1, 1, 0, 0, 1); break;
            case "М": sp.play(М, 1, 1, 0, 0, 1); break;
            case "Н": sp.play(Н, 1, 1, 0, 0, 1); break;
            case "О": sp.play(О, 1, 1, 0, 0, 1); break;
            case "П": sp.play(П, 1, 1, 0, 0, 1); break;
            case "Р": sp.play(Р, 1, 1, 0, 0, 1); break;
            case "С": sp.play(С, 1, 1, 0, 0, 1); break;
            case "Т": sp.play(Т, 1, 1, 0, 0, 1); break;
            case "У": sp.play(У, 1, 1, 0, 0, 1); break;
            case "Ф": sp.play(Ф, 1, 1, 0, 0, 1); break;
            case "Х": sp.play(Х, 1, 1, 0, 0, 1); break;
            case "Ц": sp.play(Ц, 1, 1, 0, 0, 1); break;
            case "Ч": sp.play(Ч, 1, 1, 0, 0, 1); break;
            case "Ш": sp.play(Ш, 1, 1, 0, 0, 1); break;
            case "Щ": sp.play(Щ, 1, 1, 0, 0, 1); break;
            case "Ъ": sp.play(Ъ, 1, 1, 0, 0, 1); break;
            case "Ы": sp.play(Ы, 1, 1, 0, 0, 1); break;
            case "Ь": sp.play(Ь, 1, 1, 0, 0, 1); break;
            case "Э": sp.play(Э, 1, 1, 0, 0, 1); break;
            case "Ю": sp.play(Ю, 1, 1, 0, 0, 1); break;
            case "Я": sp.play(Я, 1, 1, 0, 0, 1); break;

            case "click": sp.play(click, 1, 1, 0, 0, 1); break;
            case "neutral": sp.play(neutral, 1, 1, 0, 0, 1); break;
            case "correctly": sp.play(correctly, 1, 1, 0, 0, 1); break;
            case "try_again": sp.play(try_again, 1, 1, 0, 0, 1); break;
            case "voice_pencil": sp.play(voice_pencil, 1, 1, 0, 0, 1); break;
            case "well_done": sp.play(well_done, 1, 1, 0, 0, 1); break;
            case "well_done_voice1": sp.play(well_done_voice1, 1, 1, 0, 0, 1); break;
            case "wrong": sp.play(wrong, 1, 1, 0, 0, 1); break;
        }
    }

    public void stopSound() {
        sp.stop(1);
        sp.stop(2);
        sp.stop(3);
        sp.stop(4);
        sp.stop(5);
    }
}
