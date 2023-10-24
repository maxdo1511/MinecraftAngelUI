package ru.angelui.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.logging.Logger;

public class JSONWriter {

    public void writeJSON(File file, Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, obj);
        }catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().warning("File {name} error to write".replace("{name}", file.getName()));
        }
    }

}
