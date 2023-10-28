package ru.angelui.ui;

import ru.angelui.ui.enums.ObjectType;
import ru.angelui.ui.utils.CustomBackground;

public abstract class CustomGuiElement implements Cloneable {

    private String id;
    private int x, y, sizeX, sizeY;
    private ObjectType type;
    private CustomBackground background;

    public CustomGuiElement() {



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
