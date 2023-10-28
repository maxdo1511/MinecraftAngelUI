package ru.angelui.ui.elements.layouts;

import ru.angelui.ui.CustomGuiElement;

import java.util.HashMap;
import java.util.Map;

public class CustomLayout extends CustomGuiElement {

    private Map<String, CustomGuiElement> elements;

    public CustomLayout() {
        elements = new HashMap<>();
    }

    public Map<String, CustomGuiElement> getElements() {
        return elements;
    }
}
