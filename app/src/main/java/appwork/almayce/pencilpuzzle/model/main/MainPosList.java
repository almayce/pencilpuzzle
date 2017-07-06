package appwork.almayce.pencilpuzzle.model.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by almayce on 26.06.17.
 */

public class MainPosList {
    private List<MainItem> mainPosList;


    public MainPosList() {
        mainPosList = new ArrayList<>();
        init();
    }

    public List<MainItem> getMainPosList() {
        return mainPosList;
    }

    private void init() {
        mainPosList.add(new MainItem("А", -43.1F, -22.8F));
        mainPosList.add(new MainItem("У", -43.1F, -6.32F));
        mainPosList.add(new MainItem("М", -43.1F, 10.00F));
        mainPosList.add(new MainItem("П", -43.1F, 26.29F));
        mainPosList.add(new MainItem("Б", -32.3F, 26.29F));
        mainPosList.add(new MainItem("О", -32.3F, 10.00F));
        mainPosList.add(new MainItem("В", -32.3F, -6.32F));
        mainPosList.add(new MainItem("Ф", -32.3F, -22.8F));
        mainPosList.add(new MainItem("Д", -21.6F, -22.8F));
        mainPosList.add(new MainItem("Т", -21.6F, -6.32F));
        mainPosList.add(new MainItem("Н", -21.6F, 10.00F));
        mainPosList.add(new MainItem("Г", -21.6F, 26.29F));
        mainPosList.add(new MainItem("К", -10.8F, 26.29F));
        mainPosList.add(new MainItem("Ы", -10.8F, 10.00F));
        mainPosList.add(new MainItem("Х", -10.8F, -6.32F));
        mainPosList.add(new MainItem("З", -10.8F, -22.8F));
        mainPosList.add(new MainItem("С", -0.02F, -22.8F));
        mainPosList.add(new MainItem("Л", -0.02F, -6.32F));
        mainPosList.add(new MainItem("Р", -0.02F, 10.00F));
        mainPosList.add(new MainItem("И", -0.02F, 26.29F));
        mainPosList.add(new MainItem("Й", 10.70F, 26.29F));
        mainPosList.add(new MainItem("Э", 10.70F, 10.00F));
        mainPosList.add(new MainItem("Я", 10.70F, -6.32F));
        mainPosList.add(new MainItem("Е", 10.70F, -22.8F));
        mainPosList.add(new MainItem("Ж", 21.53F, -22.8F));
        mainPosList.add(new MainItem("Ё", 21.53F, -6.32F));
        mainPosList.add(new MainItem("Ч", 21.53F, 10.00F));
        mainPosList.add(new MainItem("Ю", 21.53F, 26.29F));
        mainPosList.add(new MainItem("Ц", 32.31F, 26.29F));
        mainPosList.add(new MainItem("Ш", 32.31F, 10.00F));
        mainPosList.add(new MainItem("Щ", 32.31F, -6.32F));
        mainPosList.add(new MainItem("Ь", 32.31F, -22.8F));
        mainPosList.add(new MainItem("Ъ", 43.09F, -22.8F));
    }
}
