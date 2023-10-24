package ru.angelui.utils;

public enum FileName {

    MAIN_CONFIG("config.json"),
    SCREENS("screens.json");

    public final String name;

    FileName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSimpleName() {
        return name.split("\\.")[0];
    }
}
