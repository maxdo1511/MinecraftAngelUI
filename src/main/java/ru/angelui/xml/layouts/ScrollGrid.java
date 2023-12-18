package ru.angelui.xml.layouts;

import ru.angelui.xml.elements.VerticalScroller;
import ru.angelui.xml.enums.ElementType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ScrollGrid")
public class ScrollGrid extends Grid{

    private final ElementType elementType = ElementType.SCROLLED_GRID;

    public ElementType getElementType() {
        return elementType;
    }
    @XmlElement(name = "Scroller", type = VerticalScroller.class)
    private VerticalScroller scroller;

}
