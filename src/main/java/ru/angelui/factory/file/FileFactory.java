package ru.angelui.factory.file;

import ru.angelui.utils.file.CSSReader;
import ru.angelui.utils.file.enums.FileType;
import ru.angelui.utils.file.JSONReader;
import ru.angelui.utils.file.XMLReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FileFactory {

    private String encoding = "UTF-8";

    public FileFactory() {
    }

    public FileFactory(String encoding) {
        this.encoding = encoding;
    }

    public Object read(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(path)), encoding
                ))) {
            String string_data = "";
            while (bufferedReader.ready()) {
                string_data = string_data + bufferedReader.readLine();
            }
            FileType type = FileType.getFileType(path);
            switch (type) {
                case JSON:
                    return JSONReader.readJSON(string_data, getFileName(path));
                case XML:
                    return XMLReader.readXML(string_data);
                case CSS:
                    return CSSReader.readCSS(string_data);
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
