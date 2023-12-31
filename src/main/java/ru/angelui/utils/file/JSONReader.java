package ru.angelui.utils.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import ru.angelui.utils.configs.MainJSONConfig;
import ru.angelui.utils.configs.ScreenJSONConfig;
import ru.angelui.utils.file.enums.FileName;

import java.util.List;
import java.util.logging.Logger;

public class JSONReader {

    public static Object readJSON(String data, String file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if (file.startsWith(FileName.MAIN_CONFIG.getSimpleName())) {
                return objectMapper.readValue(data, MainJSONConfig.class);
            }
            if (file.startsWith(FileName.SCREENS.getSimpleName())) {
                return objectMapper.readValue(data, new TypeReference<List<ScreenJSONConfig>>() {
                });
            }
        } catch (MismatchedInputException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().warning("File {name} error to read".replace("{name}", file));
            return null;
        }
        return null;
    }

}
