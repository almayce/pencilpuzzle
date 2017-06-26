package appwork.almayce.pencilpuzzle.model.item;

import java.util.ArrayList;
import java.util.List;

import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;

/**
 * Created by almayce on 08.06.17.
 */

public class ItemCharsCollection {

    private List<ItemChar> itemCharList;

    public ItemCharsCollection() {
        itemCharList = new ArrayList<>();
        init();
    }

    public List<ItemChar> getItemCharList() {
        return itemCharList;
    }

    private void init() {
        itemCharList.add(new ItemChar("А", Sounds.А, R.id.rl11, R.id.iv11));
        itemCharList.add(new ItemChar("Ф", Sounds.Ф, R.id.rl12, R.id.iv12));
        itemCharList.add(new ItemChar("Д", Sounds.Д, R.id.rl13, R.id.iv13));
        itemCharList.add(new ItemChar("З", Sounds.З, R.id.rl14, R.id.iv14));
        itemCharList.add(new ItemChar("С", Sounds.С, R.id.rl15, R.id.iv15));
        itemCharList.add(new ItemChar("Е", Sounds.Е, R.id.rl16, R.id.iv16));
        itemCharList.add(new ItemChar("Ж", Sounds.Ж, R.id.rl17, R.id.iv17));
        itemCharList.add(new ItemChar("Ь", Sounds.Ь, R.id.rl18, R.id.iv18));
        itemCharList.add(new ItemChar("Ъ", Sounds.Ъ, R.id.rl19, R.id.iv19));
        itemCharList.add(new ItemChar("У", Sounds.У, R.id.rl21, R.id.iv21));
        itemCharList.add(new ItemChar("В", Sounds.В, R.id.rl22, R.id.iv22));
        itemCharList.add(new ItemChar("Т", Sounds.Т, R.id.rl23, R.id.iv23));
        itemCharList.add(new ItemChar("Х", Sounds.Х, R.id.rl24, R.id.iv24));
        itemCharList.add(new ItemChar("Л", Sounds.Л, R.id.rl25, R.id.iv25));
        itemCharList.add(new ItemChar("Я", Sounds.Я, R.id.rl26, R.id.iv26));
        itemCharList.add(new ItemChar("Ё", Sounds.Ё, R.id.rl27, R.id.iv27));
        itemCharList.add(new ItemChar("Щ", Sounds.Щ, R.id.rl28, R.id.iv28));
        itemCharList.add(new ItemChar("М", Sounds.М, R.id.rl31, R.id.iv31));
        itemCharList.add(new ItemChar("О", Sounds.О, R.id.rl32, R.id.iv32));
        itemCharList.add(new ItemChar("Н", Sounds.Н, R.id.rl33, R.id.iv33));
        itemCharList.add(new ItemChar("Ы", Sounds.Ы, R.id.rl34, R.id.iv34));
        itemCharList.add(new ItemChar("Р", Sounds.Р, R.id.rl35, R.id.iv35));
        itemCharList.add(new ItemChar("Э", Sounds.Э, R.id.rl36, R.id.iv36));
        itemCharList.add(new ItemChar("Ч", Sounds.Ч, R.id.rl37, R.id.iv37));
        itemCharList.add(new ItemChar("Ш", Sounds.Ш, R.id.rl38, R.id.iv38));
        itemCharList.add(new ItemChar("П", Sounds.П, R.id.rl41, R.id.iv41));
        itemCharList.add(new ItemChar("Б", Sounds.Б, R.id.rl42, R.id.iv42));
        itemCharList.add(new ItemChar("Г", Sounds.Г, R.id.rl43, R.id.iv43));
        itemCharList.add(new ItemChar("К", Sounds.К, R.id.rl44, R.id.iv44));
        itemCharList.add(new ItemChar("И", Sounds.И, R.id.rl45, R.id.iv45));
        itemCharList.add(new ItemChar("Й", Sounds.Й, R.id.rl46, R.id.iv46));
        itemCharList.add(new ItemChar("Ю", Sounds.Ю, R.id.rl47, R.id.iv47));
        itemCharList.add(new ItemChar("Ц", Sounds.Ц, R.id.rl48, R.id.iv48));
    }


}
