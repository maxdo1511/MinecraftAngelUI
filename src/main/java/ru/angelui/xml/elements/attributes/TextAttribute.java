package ru.angelui.xml.elements.attributes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType
public class TextAttribute {

    @XmlAttribute(name = "Color")
    private String color;
    @XmlValue
    private String text;

}
