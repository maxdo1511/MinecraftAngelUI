package ru.angelui;

import ru.angelui.utils.configs.ScreenJSONConfig;
import ru.angelui.factory.file.FileFactory;
import ru.angelui.xml.screens.Screen;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuManager.getInstance().loadXMLScreens();
        MenuManager manager = MenuManager.getInstance();
        System.out.println(manager);
    }
}