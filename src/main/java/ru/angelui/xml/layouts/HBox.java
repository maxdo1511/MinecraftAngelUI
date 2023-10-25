package ru.angelui.xml.layouts;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "HBox")
public class HBox extends Box {

    @XmlAttribute(name = "Border")
    private int border;
    @XmlAttribute(name = "onSectionClick")
    private int onClick;

    public HBox() {
    }

    public int getBorder() {
        return border;
    }

    public int getOnClick() {
        return onClick;
    }
}
