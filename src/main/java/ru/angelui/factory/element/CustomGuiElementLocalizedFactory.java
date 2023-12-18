package ru.angelui.factory.element;

import ru.angelui.builder.element.DefaultElementBuilder;
import ru.angelui.ui.BasicGuiElement;
import ru.angelui.ui.CustomGuiElement;
import ru.angelui.xml.GuiElement;
import ru.angelui.xml.enums.ElementType;

import java.util.ArrayList;

public class CustomGuiElementLocalizedFactory extends CustomGuiElementAbstractFactory {

    @Override
    public CustomGuiElement createElement(GuiElement element, BasicGuiElement parent) {
        ElementType type = element.getElementType();
        switch (type){
            case DEFAULT:
                return createDefaultElement(element, parent);
            case BOX:
                return createDefaultLayout(element, parent);
            case HBOX:
            case VBOX:
                return createOrientatedLayout(element, parent);
            case GRID:
                return createGridLayout(element, parent);
            case SCROLLED_GRID:
                return createScrollerGridLayout(element, parent);
            case BUTTON:
                return createClickableElement(element, parent);
            case TEXT:
                return createTextElement(element, parent);
        }
        throw new RuntimeException("CustomElementFactory error! element " + element.getId() + " can not be produced");
    }

    private CustomGuiElement createDefaultElement(GuiElement element, BasicGuiElement parent) {
        DefaultElementBuilder builder = new DefaultElementBuilder();
        return builder.
                applyID(element.getId()).
                applyWrapAttribute(element.getWrap()).
                applyAlignAttribute(element.getAlign()).
                applyAlignVerticalAttribute(element.getAlignVertical()).
                applyAlignHorizontalAttribute(element.getAlignHorizontal()).
                applyDimensions(
                        parent.getX(),
                        parent.getY(),
                        parent.getSizeX(),
                        parent.getSizeY(),
                        element.getX(),
                        element.getY(),
                        element.getSizeX(),
                        element.getSizeY()
                ).
                applyBackground(element.getBackground()).
                build();
    }

    private CustomGuiElement createDefaultLayout(GuiElement element, BasicGuiElement parent) {

    }

    private CustomGuiElement createOrientatedLayout(GuiElement element, BasicGuiElement parent) {

    }

    private CustomGuiElement createGridLayout(GuiElement element, BasicGuiElement parent) {

    }

    private CustomGuiElement createScrollerGridLayout(GuiElement element, BasicGuiElement parent) {

    }

    private CustomGuiElement createClickableElement(GuiElement element, BasicGuiElement parent) {

    }

    private CustomGuiElement createTextElement(GuiElement element, BasicGuiElement parent) {

    }

}
