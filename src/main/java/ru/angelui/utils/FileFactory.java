package ru.angelui.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class FileFactory {

    private String encoding = "UTF-8";

    public FileFactory() {
    }

    public FileFactory(String encoding) {
        this.encoding = encoding;
    }

    public Object read(String path) {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path)) {
            String string_data = "";
            if (inputStream != null) {
                int data;
                while ((data = inputStream.read()) != -1) {
                    string_data = string_data + ((char) data);
                }
            }
            FileType type = FileType.getFileType(path);
            switch (type) {
                case JSON:
                    return JSONReader.readJSON(string_data, getFileName(path));
                case XML:
                    return XMLReader.readXML(string_data);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getFileName(String path) {
        String[] split = path.split("\\.");
        return split[split.length - 2];
    }
}
