package ru.angelui;

import ru.angelui.api.IManager;
import ru.angelui.factory.file.FileFactory;
import ru.angelui.factory.screen.CustomScreenLocalizedFactory;
import ru.angelui.ui.CustomGuiElement;
import ru.angelui.ui.elements.layouts.CustomLayout;
import ru.angelui.ui.enums.ObjectType;
import ru.angelui.ui.screens.CustomScreen;
import ru.angelui.utils.configs.MainJSONConfig;
import ru.angelui.utils.configs.ScreenJSONConfig;
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
            CustomScreenLocalizedFactory factory = new CustomScreenLocalizedFactory(1980, 1080);
            FileFactory fileFactory = new FileFactory(config.getEncoding());
            Object o = fileFactory.read(config.getScreens_file_path());
            List<ScreenJSONConfig> list = (List<ScreenJSONConfig>) o;
            for (ScreenJSONConfig m : list) {
                Screen screen = (Screen) fileFactory.read(m.getScreen());
                registerScreen(factory.createScreen(screen));
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading screens. Check xml files, and config.json");
        }
    }

    public void registerScreen(CustomScreen screen) {
        registerScreens.put(screen.getId(), screen);
        for (CustomGuiElement element : screen.getElements().values()) {
            registerObject(element);
        }
    }

    public void registerObject(CustomGuiElement element) {
        registeredObjects.put(getId(element), element);
        if (element.getType() == ObjectType.LAYOUT || element.getType() == ObjectType.GRID) {
            CustomLayout layout = (CustomLayout) element;
            for (CustomGuiElement child : layout.getElements().values()) {
                registerObject(child);
            }
        }
    }

    private void readConfig() {
        FileFactory fileFactory = new FileFactory();
        config = (MainJSONConfig) fileFactory.read("config.json");
    }

    private String getId(CustomGuiElement element) {
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
