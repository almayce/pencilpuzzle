package appwork.almayce.pencilpuzzle.model.item;

import java.util.HashMap;
import java.util.Map;

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
        parts.put("А1", new Part(-33F, -4F, -16.0F, 0F));
        parts.put("А2", new Part(27F, -4F, 16.0F, 0F));
        parts.put("А3", new Part(-2F, 37F, 0F, 16.0F));
        parts.put("Ф1", new Part(-33F, -8.8F, -27F, -1F));
        parts.put("Ф2", new Part(36.5F, -8.8F, 27F, -1F));
        parts.put("Ф3", new Part(22.5F, 2.7F, 0F, 0F));
        parts.put("Д1", new Part(-35F, -20F, -36F, 45F));
        parts.put("Д2", new Part(-35F, 8.35F, 36F, 45F));
        parts.put("Д3", new Part(-3F, 36.8F, 0F, 38F));
        parts.put("Д4", new Part(25.88F, -3.3F, -13F, 0F));
        parts.put("Д5", new Part(40.3F, -3.3F, 13F, 0F));
        parts.put("З1", new Part(30.5F, -13.9F, 2.3F, 20.2F));
        parts.put("З2", new Part(30.1F, 17.7F, 0.6F, -25.4F));
        parts.put("С1", new Part(32.9F, 15.55F, 0F, -22.8F));
        parts.put("С2", new Part(32.5F, -15.55F, -2F, 22.7F));
        parts.put("Е1", new Part(-34.8F, -2.75F, -25.8F, 1F));
        parts.put("Е2", new Part(30F, -24.2F, 5.3F, -38.5F));
        parts.put("Е3", new Part(30F, -5.1F, 2F, -2.6F));
        parts.put("Е4", new Part(-2.96F, 36.79F, 7.36F, 38.2F));
        parts.put("Ж1", new Part(-34.7F, -2.75F, 0F, 0F));
        parts.put("Ж2", new Part(26.5F, -14.66F, 30F, 20F));
        parts.put("Ж3", new Part(40.1F, -14.75F, -29F, -22F));
        parts.put("Ж4", new Part(26.25F, 14.26F, -31F, 20F));
        parts.put("Ж5", new Part(40.73F, 14.26F, 30F, -22F));
        parts.put("Ь1", new Part(-34.79F, -2.75F, -28F, 0F));
        parts.put("Ь2", new Part(30.20F, -13.12F, 6F, 18F));
        parts.put("Ъ1", new Part(-34.84F, -2.83F, -21F, 1F));
        parts.put("Ъ2", new Part(30.26F, -13.12F, 13F, 19F));
        parts.put("Ъ3", new Part(-4.58F, 36.55F, -28F, -38F));
        parts.put("У1", new Part(-31.87F, -13.69F, 13F, 0F));
        parts.put("У2", new Part(27.3F, -4.13F, -18F, -18F));
        parts.put("В1", new Part(-34.79F, -2.75F, -29F, 1F));
        parts.put("В2", new Part(30.2F, -13F, 7F, 18F));
        parts.put("В3", new Part(29.4F, 17.4F, 6F, -27F));
        parts.put("Т1", new Part(-3.0F, 36.8F, 0F, -38F));
        parts.put("Т2", new Part(37F, -2.83F, 0F, 0F));
        parts.put("Х1", new Part(-37.6F, -2.83F, 0F, 0F));
        parts.put("Х2", new Part(31.4F, -3F, 0F, 0F));
        parts.put("Л1", new Part(-34.7F, -3.32F, 15F, 0F));
        parts.put("Л2", new Part(25.78F, -3.24F, -15F, 0F));
        parts.put("Я1", new Part(-34.84F, -2.8F, 25F, 0F));
        parts.put("Я2", new Part(23.17F, 17.74F, -13F, 29F));
        parts.put("Я3", new Part(30.2F, -13.04F, -4F, -16F));
        parts.put("Ё1", new Part(27.34F, 9.88F, 0F, -56F));
        parts.put("Ё2", new Part(-34.84F, -2.83F, -25F, 0F));
        parts.put("Ё3", new Part(30F, -24.31F, 5F, -38F));
        parts.put("Ё4", new Part(30F, -5.18F, 2F, -3F));
        parts.put("Ё5", new Part(-2.96F, 36.79F, 7F, 38F));
        parts.put("Щ1", new Part(-34.84F, -2.59F, -49F, 0F));
        parts.put("Щ2", new Part(32.18F, -2.59F, -4F, 0F));
        parts.put("Щ3", new Part(41.77F, -2.59F, 41F, 0F));
        parts.put("Щ4", new Part(-4.68F, 36.79F, -1F, 38F));
        parts.put("Щ5", new Part(22.44F, -20.34F, 50F, 46F));
        parts.put("М1", new Part(-40.46F, -2.67F, -36F, 0F));
        parts.put("М2", new Part(-28.8F, -2.75F, 36F, 0F));
        parts.put("М3", new Part(25.72F, -3.32F, 14F, 0F));
        parts.put("М4", new Part(40.31F, -3.4F, -14F, 0F));
        parts.put("О1", new Part(-33.69F, -3.07F, 22F, 0F));
        parts.put("О2", new Part(28.12F, -3.07F, -22F, 0F));
        parts.put("Н1", new Part(-34.79F, -2.67F, -28F, 0F));
        parts.put("Н2", new Part(32.03F, -2.67F, 28F, 0F));
        parts.put("Н3", new Part(-2.96F, 36.79F, 0F, 0F));
        parts.put("Ы1", new Part(-38.07F, -2.67F, -42F, 0F));
        parts.put("Ы2", new Part(-28.8F, -2.67F, 42F, 0F));
        parts.put("Ы3", new Part(30.2F, -13.12F, -10F, 18F));
        parts.put("Р1", new Part(-34.73F, -2.67F, -26F, 0F));
        parts.put("Р2", new Part(30.26F, -12.96F, 5F, -18F));
        parts.put("Э1", new Part(32.5F, -15.64F, 0F, 21F));
        parts.put("Э2", new Part(32.7F, 12.72F, 0F, -25F));
        parts.put("Э3", new Part(-4.63F, 36.6F, 8F, 0F));
        parts.put("Ч1", new Part(-34.79F, -2.75F, 27F, 0F));
        parts.put("Ч2", new Part(29.42F, -11.66F, -8F, -15F));
        parts.put("Ш1", new Part(-34.73F, -2.75F, -46F, 0F));
        parts.put("Ш2", new Part(22.65F, 2.8F, 0F, 0F));
        parts.put("Ш3", new Part(36.9F, -2.75F, 46F, 0F));
        parts.put("Ш4", new Part(-4.73F, 36.95F, 0F, 38F));
        parts.put("П1", new Part(-34.79F, -2.67F, -28F, 0F));
        parts.put("П2", new Part(32.08F, -2.75F, 28F, 0F));
        parts.put("П3", new Part(-2.96F, 36.79F, 0F, -38F));
        parts.put("Б1", new Part(-34.84F, -2.83F, -29F, 0F));
        parts.put("Б2", new Part(30.20F, -13.04F, 7F, 18F));
        parts.put("Б3", new Part(-2.97F, 36.79F, 0F, -38F));
        parts.put("Г1", new Part(22.5F, -2.83F, -22F, 0F));
        parts.put("Г2", new Part(-2.96F, 36.79F, 0F, -38F));
        parts.put("К1", new Part(-34.79F, -2.75F, -25F, 0F));
        parts.put("К2", new Part(26.25F, -14.5F, 8F, 20F));
        parts.put("К3", new Part(26.72F, 13.85F, 8F, -21F));
        parts.put("И1", new Part(-35.78F, -5.91F, 1F, 0F));
        parts.put("И2", new Part(22.55F, -2.75F, -28F, 0F));
        parts.put("И3", new Part(37.03F, -2.83F, 28F, 0F));
        parts.put("Й1", new Part(-2.96F, 36.22F, 0F, -53F));
        parts.put("Й2", new Part(-35.72F, -5.91F, 1F, 0F));
        parts.put("Й3", new Part(22.5F, -2.83F, -28F, 0F));
        parts.put("Й4", new Part(37.03F, -2.75F, 28F, 0F));
        parts.put("Ю1", new Part(-33.8F, -2.99F, 35F, 0F));
        parts.put("Ю2", new Part(28.07F, -3.07F, -3F, 0F));
        parts.put("Ю3", new Part(41.77F, -2.75F, -49F, 0F));
        parts.put("Ю4", new Part(-4.6F, 36.62F, -30F, 0F));
        parts.put("Ц1", new Part(-34.84F, -2.67F, -31F, 0F));
        parts.put("Ц2", new Part(-2.96F, 36.79F, 0F, 39F));
        parts.put("Ц3", new Part(32.13F, -2.75F, 24F, 0F));
        parts.put("Ц4", new Part(22.34F, -20.25F, 33F, 46F));
    }

    public float getxPos(String name) {
        return parts.get(name).getxPos();
    }

    public float getyPos(String name) {
        return parts.get(name).getyPos();
    }

    public float getxPosEnd(String name) {
        return parts.get(name).getxPosEnd();
    }

    public float getyPosEnd(String name) {
        return parts.get(name).getyPosEnd();
    }
}
