package ru.angelui;

import ru.angelui.configs.ScreenJSONConfig;
import ru.angelui.factory.file.FileFactory;
import ru.angelui.xml.screens.Screen;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileFactory fileFactory = new FileFactory();
        Object o = fileFactory.read("screens.json");
        List<ScreenJSONConfig> list = (List<ScreenJSONConfig>) o;
        for (ScreenJSONConfig m : list) {
            Screen body = (Screen) fileFactory.read(m.getPath());
            System.out.println(body);
        }
        //XMLReader reader = new XMLReader();
        //CustomScreen customScreen = reader.read("main.xml");
        //System.out.println(customScreen.getName());
    }
}