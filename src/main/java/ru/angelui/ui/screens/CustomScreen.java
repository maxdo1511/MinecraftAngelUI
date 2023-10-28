package ru.angelui.ui.screens;

import ru.angelui.ui.CustomGuiElement;
import ru.angelui.ui.enums.ObjectType;

import java.util.HashMap;
import java.util.Map;

public class CustomScreen {

    private String id;
    private int x, y, sizeX, sizeY;
    private Map<String, CustomGuiElement> elements;

    public CustomScreen(String id, int x, int y, int sizeX, int sizeY, Map<String, CustomGuiElement> elements) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.elements = elements;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public void setElements(Map<String, CustomGuiElement> elements) {
        this.elements = elements;
    }

    public Map<String, CustomGuiElement> getElements() {
        return elements;
    }

    public boolean doQualityCheck() {
        if (elements == null) {
            return false;
        }
        if (sizeX <= 0 || sizeY <= 0) {
            return false;
        }
        return true;
    }
}
