package ru.angelui.builder.element;

import ru.angelui.factory.element.CustomGuiElementLocalizedFactory;
import ru.angelui.ui.CustomGuiElement;
import ru.angelui.ui.elements.sprites.CustomSprite;
import ru.angelui.ui.enums.ObjectType;
import ru.angelui.ui.screens.CustomScreen;
import ru.angelui.ui.utils.CustomBackground;
import ru.angelui.utils.other.StringsParser;
import ru.angelui.xml.GuiElement;
import ru.angelui.xml.elements.attributes.Background;
import ru.angelui.xml.enums.Align;
import ru.angelui.xml.enums.Wrap;

import java.util.*;

public class DefaultElementBuilder implements IElementBuilder {

    private String id;
    private int x, y, sizeX, sizeY;
    private Wrap wrap;
    private Align.Horizontal horizontal;
    private Align.Vertical vertical;
    private Map<String, CustomGuiElement> elements;
    private CustomBackground background;

    public DefaultElementBuilder() {
        elements = new HashMap<>();
    }

    @Override
    public IElementBuilder applyID(String id) {
        if (id == null) {
            this.id = UUID.randomUUID().toString();
            return this;
        }
        this.id = id;
        return this;
    }

    @Override
    public IElementBuilder applyWrapAttribute(String wrapAttribute) {
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
    public IElementBuilder applyAlignAttribute(String align) {
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
    public IElementBuilder applyAlignHorizontalAttribute(String horizontal) {
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
    public IElementBuilder applyAlignVerticalAttribute(String vertical) {
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
    public IElementBuilder applyDimensions(int screenX, int screenY, int screenSizeX, int screenSizeY, int x, int y, int sizeX, int sizeY) {
        switch (wrap) {
            case CUSTOM:
                this.sizeX = sizeX;
                this.sizeY = sizeY;
                break;
            case FILL:
                this.sizeX = screenSizeX;
                this.sizeY = screenSizeY;
        }

        this.x = screenX + x;
        this.y = screenY + y;
        return this;
    }

    @Override
    public IElementBuilder applyBackground(Background background) {
        if (background == null) {
            this.background = new CustomBackground(
                    null
            );
            return this;
        }
        if (background.getImage() == null || background.getImage().isEmpty()) {
            this.background = new CustomBackground(
                    StringsParser.parsStringToColorRGB(background.getColor()),
                    background.getAlpha()
            );
        } else {
            if (background.getAlpha() == 1) {
                this.background = new CustomBackground(
                        background.getImage()
                );
            }else {
                this.background = new CustomBackground(
                        background.getAlpha(),
                        background.getImage()
                );
            }
        }
        return this;
    }

    @Override
    public CustomGuiElement build() {
        CustomGuiElement customSprite = new CustomSprite(
                id,
                x,
                y,
                sizeX,
                sizeY,
                ObjectType.SPRITE,
                background
        );
        if (customSprite.doQualityCheck()) {
            return customSprite;
        } else {
            throw new RuntimeException("Screen " + id + " error build!");
        }
    }

}
