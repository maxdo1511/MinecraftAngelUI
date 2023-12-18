package ru.angelui.builder.element;

import ru.angelui.ui.CustomGuiElement;
import ru.angelui.ui.utils.CustomBackground;
import ru.angelui.xml.elements.attributes.Background;

import java.util.Collection;

public interface IElementBuilder {

    public IElementBuilder applyID(String id);
    public IElementBuilder applyWrapAttribute(String wrap);
    public IElementBuilder applyAlignAttribute(String align);
    public IElementBuilder applyAlignHorizontalAttribute(String horizontal);
    public IElementBuilder applyAlignVerticalAttribute(String vertical);
    public IElementBuilder applyDimensions(int screenX, int screenY, int screenSizeX, int screenSizeY, int x, int y, int sizeX, int sizeY);
    public IElementBuilder applyBackground(Background background);
    public CustomGuiElement build();

}
