package ru.angelui.ui;

public abstract class CustomGuiElement implements Cloneable {

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
