package ru.angelui;

import ru.angelui.api.IManager;

import java.util.HashMap;
import java.util.Map;

public class MenuManager implements IManager {

    public static MenuManager instance;
    private Map<String, Object> registeredObjects;


    public MenuManager() {
        instance = this;
        registeredObjects = new HashMap<>();
    }

    public static MenuManager getInstance() {
        if (instance == null) {
            new MenuManager();
        }
        return instance;
    }
}
