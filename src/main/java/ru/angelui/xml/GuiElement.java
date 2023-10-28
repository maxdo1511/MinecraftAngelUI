package ru.angelui.xml;

import ru.angelui.xml.elements.attributes.Background;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public abstract class GuiElement implements Cloneable {

    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "Padding")
    private int padding;
    @XmlAttribute(name = "PaddingTop")
    private int paddingTop;
    @XmlAttribute(name = "PaddingLeft")
    private int paddingLeft;
    @XmlAttribute(name = "PaddingRight")
    private int paddingRight;
    @XmlAttribute(name = "PaddingBottom")
    private int paddingBottom;
    @XmlAttribute(name = "Align")
    private String align;
    @XmlAttribute(name = "Align.Horizontal")
    private String alignHorizontal;
    @XmlAttribute(name = "Align.Vertical")
    private String alignVertical;
    @XmlAttribute(name = "Wrap")
    private String wrap;
    @XmlAttribute(name = "Size")
    private int size;
    @XmlAttribute(name = "SizeX")
    private int sizeX;
    @XmlAttribute(name = "SizeY")
    private int sizeY;
    @XmlAttribute(name = "posX")
    private int x;
    @XmlAttribute(name = "posY")
    private int y;
    @XmlElement(name = "Background", type = Background.class)
    private Background background;
    @XmlAttribute(name = "onOverlapped")
    private String overlapped;
    @XmlAttribute(name = "onEndOverlapped")
    private String overlappedEnd;

    public GuiElement() {
    }

    @Override
    public GuiElement clone() {
        try {
            GuiElement clone = (GuiElement) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getId() {
        return id;
    }

    public int getPadding() {
        return padding;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public String getAlign() {
        return align;
    }

    public String getAlignHorizontal() {
        return alignHorizontal;
    }

    public String getAlignVertical() {
        return alignVertical;
    }

    public String getWrap() {
        return wrap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOverlapped() {
        return overlapped;
    }

    public String getOverlappedEnd() {
        return overlappedEnd;
    }

    public int getSize() {
        return size;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Background getBackground() {
        return background;
    }
}
