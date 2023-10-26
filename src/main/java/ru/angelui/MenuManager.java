package ru.angelui;

import ru.angelui.api.IManager;
import ru.angelui.factory.file.FileFactory;
import ru.angelui.utils.configs.MainJSONConfig;
import ru.angelui.utils.configs.ScreenJSONConfig;
import ru.angelui.xml.GuiElement;
import ru.angelui.xml.screens.Screen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MenuManager implements IManager {

    public static MenuManager instance;
    private Map<String, Object> registeredObjects;
    private Map<String, Object> registerScreens;
    private MainJSONConfig config;


    public MenuManager() {
        instance = this;
        registeredObjects = new HashMap<>();
        registerScreens = new HashMap<>();
        readConfig();
    }

    @Override
    public boolean createScreens() {
        return false;
    }

    public void loadXMLScreens() {
        try {
            FileFactory fileFactory = new FileFactory(config.getEncoding());
            Object o = fileFactory.read(config.getScreens_file_path());
            List<ScreenJSONConfig> list = (List<ScreenJSONConfig>) o;
            for (ScreenJSONConfig m : list) {
                Screen screen = (Screen) fileFactory.read(m.getPath());
                registerScreen(screen);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading screens. Check xml files, and config.json");
        }
    }

    private void readConfig() {
        FileFactory fileFactory = new FileFactory();
        config = (MainJSONConfig) fileFactory.read("config.json");
    }

    private void registerScreen(Screen screen) {
        registerScreens.put(getId(screen), screen);
        registerObject(screen);
    }

    private void registerObject(Object object) {
        if (object instanceof GuiElement) {
            GuiElement element = (GuiElement) object;
            registeredObjects.put(getId(element), element);
        }
    }

    private String getId(GuiElement element) {
        if (element.getId() == null) {
            return UUID.randomUUID().toString();
        }
        return element.getId();
    }

    public static MenuManager getInstance() {
        if (instance == null) {
            new MenuManager();
        }
        return instance;
    }
}
