package ru.angelui.utils.other;

public class StringsParser {

    public static Integer[] parsStringToColorRGB(String string) {
        Integer[] color = new Integer[3];
        String[] str_color = string.split(";");
        for (int i = 0; i < str_color.length; i++) {
            color[i] = Integer.parseInt(str_color[i]);
        }
        return color;
    }

}
