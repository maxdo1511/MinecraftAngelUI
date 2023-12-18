package ru.angelui.ui.elements.sprites;

import ru.angelui.ui.CustomGuiElement;
import ru.angelui.ui.enums.ObjectType;
import ru.angelui.ui.utils.CustomBackground;

public class CustomSprite extends CustomGuiElement {

    public CustomSprite(String id, int x, int y, int sizeX, int sizeY, ObjectType type, CustomBackground background) {
        super(id, x, y, sizeX, sizeY, type, background);
    }
}
