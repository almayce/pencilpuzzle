package appwork.almayce.pencilpuzzle.model.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import appwork.almayce.pencilpuzzle.R;

/**
 * Created by almayce on 22.06.17.
 */

public class Markers {

    private Map<String, List<Integer>> map;
    private List<Integer> markersId;

    public Markers() {
        map = new HashMap<>();
        markersId = new ArrayList<>();
        init();
    }

    private void init() {
        markersId.add(R.id.pt1);
        markersId.add(R.id.pt2);
        markersId.add(R.id.pt3);
        markersId.add(R.id.pt4);
        markersId.add(R.id.pt5);

        map.put("А", createArray(3));
        map.put("Ф", createArray(3));
        map.put("Д", createArray(5));
        map.put("З", createArray(2));
        map.put("С", createArray(2));
        map.put("Е", createArray(4));
        map.put("Ж", createArray(5));
        map.put("Ь", createArray(2));
        map.put("Ъ", createArray(3));
        map.put("У", createArray(2));
        map.put("В", createArray(3));
        map.put("Т", createArray(2));
        map.put("Х", createArray(2));
        map.put("Л", createArray(2));
        map.put("Я", createArray(3));
        map.put("Ё", createArray(5));
        map.put("Щ", createArray(5));
        map.put("М", createArray(4));
        map.put("О", createArray(2));
        map.put("Н", createArray(3));
        map.put("Ы", createArray(3));
        map.put("Р", createArray(2));
        map.put("Э", createArray(3));
        map.put("Ч", createArray(2));
        map.put("Ш", createArray(4));
        map.put("П", createArray(3));
        map.put("Б", createArray(3));
        map.put("Г", createArray(2));
        map.put("К", createArray(3));
        map.put("И", createArray(3));
        map.put("Й", createArray(4));
        map.put("Ю", createArray(4));
        map.put("Ц", createArray(4));
    }

private List<Integer> createArray(int count) {
    List<Integer> target = new ArrayList<>();
    try {
        for (int o = 0; o < count; o++) {
            target.add(markersId.get(o));
        }
    } catch (IndexOutOfBoundsException e) {
        e.printStackTrace();
    }
    return target;
}

    public List<Integer> getMarkers(String name) {
        return map.get(name);
    }
}
