package ru.angelui.utils.file;

import ru.angelui.xml.screens.Screen;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XMLReader {

    public XMLReader() {
    }

    public static Object readXML(String data) {
        try {
            StringReader reader = new StringReader(data);
            JAXBContext context = JAXBContext.newInstance(Screen.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(reader);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
