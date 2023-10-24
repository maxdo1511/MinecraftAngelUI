package ru.angelui.xml.elements;

import ru.angelui.xml.GuiElement;
import ru.angelui.xml.elements.attributes.TextAttribute;

import javax.xml.bind.annotation.*;

@XmlType(name = "Button")
public class Button extends GuiElement {

    @XmlElement(name = "Title", type = TextAttribute.class)
    private TextAttribute title;
    @XmlAttribute(name = "onClick")
    private String click;

}
