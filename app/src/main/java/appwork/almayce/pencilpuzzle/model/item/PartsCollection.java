package appwork.almayce.pencilpuzzle.model.item;

import java.util.HashMap;
import java.util.Map;

import appwork.almayce.pencilpuzzle.R;
import appwork.almayce.pencilpuzzle.model.sound.Sounds;

/**
 * Created by almayce on 22.06.17.
 */

public class PartsCollection {

    private Map<String, Part> parts;

    public PartsCollection() {
        parts = new HashMap<>();
        init();
    }

    private void init() {
        parts.put("А1", new Part(400, 571));
        parts.put("А2", new Part(1482, 566));
        parts.put("А3", new Part(950, 910));
        parts.put("Ф1", new Part(2060, 508));
        parts.put("Ф2", new Part(114, 508));
        parts.put("Ф3", new Part(1592, 583));
        parts.put("Д1", new Part(600, 366));
        parts.put("Д2", new Part(20, 100));
        parts.put("Д3", new Part(901, 920));
        parts.put("Д4", new Part(1457, 576));
        parts.put("Д5", new Part(2034, 576));
        parts.put("З1", new Part(1545, 200));
        parts.put("З2", new Part(1538, 1000));
        parts.put("С1", new Part(1593, 1109));
        parts.put("С2", new Part(1583, 125));
        parts.put("Е1", new Part(291, 583));
        parts.put("Е2", new Part(1536, 318));
        parts.put("Е3", new Part(1536, 954));
        parts.put("Е4", new Part(903, 871));
        parts.put("Ж1", new Part(293, 583));
        parts.put("Ж2", new Part(1400, 100));
        parts.put("Ж3", new Part(1800, 993));
        parts.put("Ж4", new Part(1800, 100));
        parts.put("Ж5", new Part(1400, 993));
        parts.put("Ь1", new Part(292, 583));
        parts.put("Ь2", new Part(1540, 455));
        parts.put("Ъ1", new Part(291, 582));
        parts.put("Ъ2", new Part(1540, 455));
        parts.put("Ъ3", new Part(872, 1368));
        parts.put("У1", new Part(1484, 566));
        parts.put("У2", new Part(348, 566));
        parts.put("В1", new Part(292, 583));
        parts.put("В2", new Part(1540, 156));
        parts.put("В3", new Part(1524, 1000));
        parts.put("Т1", new Part(1670, 582));
        parts.put("Т2", new Part(904, 1571));
        parts.put("Х1", new Part(238, 582));
        parts.put("Х2", new Part(1563, 580));
        parts.put("Л1", new Part(1455, 577));
        parts.put("Л2", new Part(294, 576));
        parts.put("Я1", new Part(291, 582));
        parts.put("Я2", new Part(1405, 836));
        parts.put("Я3", new Part(1540, 456));
        parts.put("Ё1", new Part(1785, 0));
        parts.put("Ё2", new Part(291, 582));
        parts.put("Ё3", new Part(1536, 1417));
        parts.put("Ё4", new Part(1785, 553));
        parts.put("Ё5", new Part(903, 750));
        parts.put("Щ1", new Part(291, 585));
        parts.put("Щ2", new Part(2062, 585));
        parts.put("Щ3", new Part(1378, 585));
        parts.put("Щ4", new Part(870, 871));
        parts.put("Щ5", new Part(1091, 10));
        parts.put("М1", new Part(800, 584));
        parts.put("М2", new Part(1, 583));
        parts.put("М3", new Part(1654, 576));
        parts.put("М4", new Part(1734, 575));
        parts.put("О1", new Part(313, 579));
        parts.put("О2", new Part(1700, 579));
        parts.put("Н1", new Part(292, 584));
        parts.put("Н2", new Part(1575, 584));
        parts.put("Н3", new Part(903, 1130));
        parts.put("Ы1", new Part(-250, 584));
        parts.put("Ы2", new Part(707, 584));
        parts.put("Ы3", new Part(1740, 455));
        parts.put("Р1", new Part(293, 584));
        parts.put("Р2", new Part(1541, 457));
        parts.put("Э1", new Part(1584, 124));
        parts.put("Э2", new Part(1589, 1074));
        parts.put("Э3", new Part(871, 1069));
        parts.put("Ч1", new Part(292, 583));
        parts.put("Ч2", new Part(1525, 473));
        parts.put("Ш1", new Part(293, 583));
        parts.put("Ш2", new Part(1195, 582));
        parts.put("Ш3", new Part(2069, 583));
        parts.put("Ш4", new Part(869, 873));
        parts.put("П1", new Part(292, 584));
        parts.put("П2", new Part(1576, 583));
        parts.put("П3", new Part(903, 1520));
        parts.put("Б1", new Part(291, 582));
        parts.put("Б2", new Part(1540, 456));
        parts.put("Б3", new Part(903, 1520));
        parts.put("Г1", new Part(1592, 582));
        parts.put("Г2", new Part(903, 1471));
        parts.put("К1", new Part(292, 583));
        parts.put("К2", new Part(1464, 1038));
        parts.put("К3", new Part(1473, 188));
        parts.put("И1", new Part(273, 544));
        parts.put("И2", new Part(1293, 583));
        parts.put("И3", new Part(2071, 582));
        parts.put("Й1", new Part(1000, 1500));
        parts.put("Й2", new Part(274, 544));
        parts.put("Й3", new Part(1292, 582));
        parts.put("Й4", new Part(2071, 582));
        parts.put("Ю1", new Part(10, 580));
        parts.put("Ю2", new Part(1499, 579));
        parts.put("Ю3", new Part(2162, 583));
        parts.put("Ю4", new Part(870, 1169));
        parts.put("Ц1", new Part(291, 584));
        parts.put("Ц2", new Part(903, 871));
        parts.put("Ц3", new Part(1977, 583));
        parts.put("Ц4", new Part(1189, 67));
    }

    public int getxPos(String name) {
        return parts.get(name).getxPos();
    }
    public int getyPos(String name) {
        return parts.get(name).getyPos();
    }
}
