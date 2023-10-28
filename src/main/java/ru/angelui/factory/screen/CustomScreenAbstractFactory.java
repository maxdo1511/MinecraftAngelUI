package ru.angelui.factory.screen;

import ru.angelui.ui.screens.CustomScreen;
import ru.angelui.xml.screens.Screen;

public abstract class CustomScreenAbstractFactory {

    private int windowSizeX, windowSizeY;

    public CustomScreenAbstractFactory(int windowSizeX, int windowSizeY) {
        this.windowSizeX = windowSizeX;
        this.windowSizeY = windowSizeY;
    }

    public abstract CustomScreen createScreen(Screen screen);
    //public abstract CustomScreen


    public int getWindowSizeX() {
        return windowSizeX;
    }

    public int getWindowSizeY() {
        return windowSizeY;
    }
}
