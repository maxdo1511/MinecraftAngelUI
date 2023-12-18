package ru.angelui.factory.screen;

import ru.angelui.builder.screen.DefaultScreenBuilder;
import ru.angelui.ui.enums.ScreenType;
import ru.angelui.ui.screens.CustomScreen;
import ru.angelui.xml.screens.Screen;

public class CustomScreenLocalizedFactory extends CustomScreenAbstractFactory {

    public CustomScreenLocalizedFactory(int windowSizeX, int windowSizeY) {
        super(windowSizeX, windowSizeY);
    }

    @Override
    public CustomScreen createScreen(Screen screen) {
        try {
            ScreenType type = getScreenType(screen.getType());
            switch (type) {
                case DEFAULT:
                    DefaultScreenBuilder builder = new DefaultScreenBuilder();
                    return builder.
                            applyID(screen.getId()).
                            applyWrapAttribute(screen.getWrap()).
                            applyAlignAttribute(screen.getAlign()).
                            applyAlignVerticalAttribute(screen.getAlignVertical()).
                            applyAlignHorizontalAttribute(screen.getAlignHorizontal()).
                            applyDimensions(
                                    getWindowSizeX(),
                                    getWindowSizeY(),
                                    screen.getX(),
                                    screen.getY(),
                                    screen.getSizeX(),
                                    screen.getSizeY()).
                            build(screen.getElements());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Wrong XML. ScreenLocalizedFactory can't create object");
    }

    private ScreenType getScreenType(String type) {
        if (type == null) {
            return ScreenType.DEFAULT;
        }
        try {
            return ScreenType.valueOf(type.toUpperCase());
        }catch (IllegalArgumentException e) {
            return ScreenType.DEFAULT;
        }
    }

}
