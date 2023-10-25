package ru.angelui.xml.elements;

import ru.angelui.xml.GuiElement;
import ru.angelui.xml.elements.attributes.TextAttribute;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(name = "TextField")
public class TextField extends GuiElement {

    @XmlElement(name = "Text", type = TextAttribute.class)
    private TextAttribute text;
    @XmlAttribute(name = "TextColor")
    private String color;
    @XmlAttribute(name = "TextAlign")
    private String textAlign;

    public TextField() {
    }

    public TextAttribute getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public String getTextAlign() {
        return textAlign;
    }
}
