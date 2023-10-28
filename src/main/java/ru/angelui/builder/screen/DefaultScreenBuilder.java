package ru.angelui.builder.screen;

import ru.angelui.factory.element.CustomGuiElementLocalizedFactory;
import ru.angelui.ui.CustomGuiElement;
import ru.angelui.ui.screens.CustomScreen;
import ru.angelui.xml.GuiElement;
import ru.angelui.xml.enums.Align;
import ru.angelui.xml.enums.Wrap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DefaultScreenBuilder implements IScreenBuilder {

    private String id;
    private int x, y, sizeX, sizeY;
    private Wrap wrap;
    private Align align;
    private Align.Horizontal horizontal;
    private Align.Vertical vertical;
    private Map<String, CustomGuiElement> elements;

    public DefaultScreenBuilder() {
        elements = new HashMap<>();
    }

    @Override
    public IScreenBuilder applyID(String id) {
        if (id == null) {
            this.id = UUID.randomUUID().toString();
            return this;
        }
        this.id = id;
        return this;
    }

    @Override
    public IScreenBuilder applyWrapAttribute(String wrapAttribute) {
        wrap = Wrap.FILL;
        try {
            wrap = Wrap.valueOf(wrapAttribute.toUpperCase());
        }catch (IllegalArgumentException e) {
            throw new RuntimeException("Wrong XML! Check wrap attribute in screen id: " + id);
        } catch (NullPointerException e) {

        }
        return this;
    }

    @Override
    public IScreenBuilder applyAlignAttribute(String align) {
        if (align == null) {
            horizontal = Align.Horizontal.LEFT;
            vertical = Align.Vertical.TOP;
            return this;
        }
        try {
            Align align1 = Align.valueOf(align.toUpperCase());
            switch (align1){
                case CENTER:
                    horizontal = Align.Horizontal.CENTER;
                    vertical = Align.Vertical.CENTER;
                    return this;
            }
        }catch (IllegalArgumentException e) {
            throw new RuntimeException("Wrong XML! Check align attribute in screen id: " + id);
        }
        return this;
    }

    @Override
    public IScreenBuilder applyAlignHorizontalAttribute(String horizontal) {
        if (horizontal == null) {
            return this;
        }
        try {
            this.horizontal = Align.Horizontal.valueOf(horizontal);
        }catch (IllegalArgumentException e) {
            throw new RuntimeException("Wrong XML! Check align horizontal attribute in screen id: " + id);
        }
        return this;
    }

    @Override
    public IScreenBuilder applyAlignVerticalAttribute(String vertical) {
        if (vertical == null) {
            return this;
        }
        try {
            this.vertical = Align.Vertical.valueOf(vertical);
        }catch (IllegalArgumentException e) {
            throw new RuntimeException("Wrong XML! Check align vertical attribute in screen id: " + id);
        }
        return this;
    }

    @Override
    public IScreenBuilder applyDimensions(int windowX, int windowY, int x, int y, int sizeX, int sizeY) {
        switch (wrap) {
            case CUSTOM:
                this.sizeX = sizeX;
                this.sizeY = sizeY;
                break;
            case FILL:
                this.sizeX = windowX - x;
                this.sizeY = windowY - y;
        }

        this.x = x;
        this.y = y;
        return this;
    }

    @Override
    public IScreenBuilder initChildren(Collection<GuiElement> children) {
        CustomGuiElementLocalizedFactory factory = new CustomGuiElementLocalizedFactory();
        for (GuiElement element : children) {
            CustomGuiElement customGuiElement = factory.createElement(element);
            elements.put(customGuiElement.getId(), customGuiElement);
        }
        return this;
    }

    @Override
    public CustomScreen build() {
        CustomScreen customScreen = new CustomScreen(
                id,
                x,
                y,
                sizeX,
                sizeY,
                elements
        );
        if (customScreen.doQualityCheck()) {
            return customScreen;
        } else {
            throw new RuntimeException("Screen " + id + " error build!");
        }
    }
}
