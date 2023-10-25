package ru.angelui.xml.elements;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class VerticalScroller {

    @XmlAttribute(name = "Background")
    private String bg;
    @XmlAttribute(name = "Scroller")
    private String scrollerBg;

}
