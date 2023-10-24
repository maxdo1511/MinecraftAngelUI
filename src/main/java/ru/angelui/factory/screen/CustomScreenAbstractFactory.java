package ru.angelui.factory.screen;

import ru.angelui.xml.screens.Screen;

public abstract class CustomScreenAbstractFactory {

    public abstract Screen createElement(Object... pars);

}
