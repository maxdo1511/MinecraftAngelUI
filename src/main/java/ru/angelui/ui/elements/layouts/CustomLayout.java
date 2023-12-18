package ru.angelui.ui.elements.layouts;

import ru.angelui.ui.CustomGuiElement;
import ru.angelui.ui.enums.ObjectType;
import ru.angelui.ui.utils.CustomBackground;

import java.util.HashMap;
import java.util.Map;

public class CustomLayout extends CustomGuiElement {

    private Map<String, CustomGuiElement> elements;

    public CustomLayout(String id, int x, int y, int sizeX, int sizeY, ObjectType type, CustomBackground background) {
        super(id, x, y, sizeX, sizeY, type, background);
    }

    public CustomLayout(String id, int x, int y, int sizeX, int sizeY, ObjectType type, CustomBackground background, Map<String, CustomGuiElement> elements) {
        super(id, x, y, sizeX, sizeY, type, background);
        this.elements = elements;
    }

    public void setElements(Map<String, CustomGuiElement> elements) {
        this.elements = elements;
    }

    public Map<String, CustomGuiElement> getElements() {
        return elements;
    }
}
