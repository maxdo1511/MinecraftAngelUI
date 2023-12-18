package ru.angelui.xml.layouts;

import ru.angelui.xml.enums.ElementType;
import ru.angelui.xml.screens.Screen;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Box")
public class Box extends Screen {

    private final ElementType elementType = ElementType.BOX;

    public ElementType getElementType() {
        return elementType;
    }
}
