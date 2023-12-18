package ru.angelui.xml.elements;

import ru.angelui.xml.GuiElement;
import ru.angelui.xml.elements.attributes.TextAttribute;
import ru.angelui.xml.enums.ElementType;

import javax.xml.bind.annotation.*;

@XmlType(name = "Button")
public class Button extends GuiElement {

    private final ElementType elementType = ElementType.BUTTON;
    @XmlElement(name = "Title", type = TextAttribute.class)
    private TextAttribute title;
    @XmlAttribute(name = "onClick")
    private String click;

    public Button() {
    }

    public ElementType getElementType() {
        return elementType;
    }
    public TextAttribute getTitle() {
        return title;
    }

    public String getClick() {
        return click;
    }
}
