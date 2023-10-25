package ru.angelui.xml.layouts;

import ru.angelui.xml.elements.VerticalScroller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ScrollGrid")
public class ScrollGrid extends Grid{

    @XmlElement(name = "Scroller", type = VerticalScroller.class)
    private VerticalScroller scroller;

}
