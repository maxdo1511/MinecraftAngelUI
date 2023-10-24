package ru.angelui.xml.elements.attributes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Background {

    @XmlAttribute(name = "Color")
    private String color;
    @XmlAttribute(name = "Alpha")
    private float alpha;
    @XmlAttribute(name = "Image")
    private String image;

}
