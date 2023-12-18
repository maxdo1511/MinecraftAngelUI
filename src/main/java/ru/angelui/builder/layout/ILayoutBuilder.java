package ru.angelui.builder.layout;

import ru.angelui.builder.element.IElementBuilder;
import ru.angelui.builder.screen.IScreenBuilder;
import ru.angelui.ui.CustomGuiElement;
import ru.angelui.ui.screens.CustomScreen;
import ru.angelui.xml.GuiElement;
import ru.angelui.xml.elements.attributes.Background;

import java.util.Collection;

public interface ILayoutBuilder {

    public ILayoutBuilder applyID(String id);
    public ILayoutBuilder applyWrapAttribute(String wrap);
    public ILayoutBuilder applyAlignAttribute(String align);
    public ILayoutBuilder applyAlignHorizontalAttribute(String horizontal);
    public ILayoutBuilder applyAlignVerticalAttribute(String vertical);
    public ILayoutBuilder applyDimensions(int screenX, int screenY, int screenSizeX, int screenSizeY, int x, int y, int sizeX, int sizeY);
    public ILayoutBuilder applyBackground(Background background);
    public CustomGuiElement build(Collection<Object> children);

}
