package ru.angelui.builder.screen;

import ru.angelui.ui.screens.CustomScreen;
import ru.angelui.xml.GuiElement;

import java.util.Collection;

public interface IScreenBuilder {

    public IScreenBuilder applyID(String id);
    public IScreenBuilder applyWrapAttribute(String wrap);
    public IScreenBuilder applyAlignAttribute(String align);
    public IScreenBuilder applyAlignHorizontalAttribute(String horizontal);
    public IScreenBuilder applyAlignVerticalAttribute(String vertical);
    public IScreenBuilder applyDimensions(int windowX, int windowY, int x, int y, int sizeX, int sizeY);
    public IScreenBuilder initChildren(Collection<GuiElement> children);
    public CustomScreen build();

}
