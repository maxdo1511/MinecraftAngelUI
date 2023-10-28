package ru.angelui.xml.screens;

import ru.angelui.interfaces.XMLModel;
import ru.angelui.xml.elements.Button;
import ru.angelui.xml.GuiElement;
import ru.angelui.xml.elements.TextField;
import ru.angelui.xml.layouts.*;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "Screen")
@XmlAccessorType(XmlAccessType.FIELD)
public class Screen extends GuiElement implements XMLModel {

    @XmlElementWrapper(name = "Elements")
    @XmlElements(value = {
            @XmlElement(name = "Box", type = Box.class),
            @XmlElement(name = "VBox", type = VBox.class),
            @XmlElement(name = "HBox", type = HBox.class),
            @XmlElement(name = "Grid", type = Grid.class),
            @XmlElement(name = "ScrollGrid", type = ScrollGrid.class),
            @XmlElement(name = "GuiElement", type = GuiElement.class),
            @XmlElement(name = "Button", type = Button.class),
            @XmlElement(name = "TextField", type = TextField.class)
    })
    private List<GuiElement> Elements;

    @XmlAttribute(name = "type")
    private String type;

    public Screen() {
    }

    public List<GuiElement> getElements() {
        return Elements;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return getId();
    }
}
