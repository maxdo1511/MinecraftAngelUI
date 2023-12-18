package ru.angelui.ui;

import ru.angelui.ui.enums.ObjectType;
import ru.angelui.ui.utils.CustomBackground;

public abstract class CustomGuiElement extends BasicGuiElement implements Cloneable {

    private ObjectType type;
    private CustomBackground background;

    public CustomGuiElement() {
    }

    public CustomGuiElement(String id, int x, int y, int sizeX, int sizeY, ObjectType type, CustomBackground background) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.type = type;
        this.background = background;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public ObjectType getType() {
        return type;
    }

    public void setType(ObjectType type) {
        this.type = type;
    }

    public CustomBackground getBackground() {
        return background;
    }

    public void setBackground(CustomBackground background) {
        this.background = background;
    }

    public boolean doQualityCheck() {
        return true;
    }

    @Override
    public CustomGuiElement clone() {
        try {
            CustomGuiElement clone = (CustomGuiElement) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
