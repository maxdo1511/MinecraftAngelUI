package ru.angelui.xml.layouts;

import ru.angelui.xml.enums.ElementType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "HBox")
public class HBox extends Box {

    private final ElementType elementType = ElementType.HBOX;
    @XmlAttribute(name = "Border")
    private int border;
    @XmlAttribute(name = "onSectionClick")
    private int onClick;

    public HBox() {
    }

    public ElementType getElementType() {
        return elementType;
    }
    public int getBorder() {
        return border;
    }

    public int getOnClick() {
        return onClick;
    }
}
