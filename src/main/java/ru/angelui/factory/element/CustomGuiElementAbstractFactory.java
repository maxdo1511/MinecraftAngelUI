package ru.angelui.factory.element;

import ru.angelui.ui.CustomGuiElement;
import ru.angelui.xml.GuiElement;

public abstract class CustomGuiElementAbstractFactory {

    public abstract CustomGuiElement createElement(GuiElement element);

}
