package ru.angelui.xml.layouts;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Grid")
public class Grid extends Box {

    @XmlAttribute(name = "Border")
    private int border;
    @XmlAttribute(name = "onSectionClick")
    private int onClick;
    @XmlAttribute(name = "Columns")
    private int columns;
    @XmlAttribute(name = "Rows")
    private int rows;

    public Grid() {
    }

    public int getBorder() {
        return border;
    }

    public int getOnClick() {
        return onClick;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
