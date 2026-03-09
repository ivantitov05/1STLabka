package MephiPackage;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class FileTypeDetector {
    public static String checkType(File file) {

        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        //if (file.length() == 0) {
        //    return "txt";
        //}

        try {
            jsonMapper.readTree(file);
            return "json";
        } catch (JsonParseException e) {
            try {
                xmlMapper.readTree(file);
                return "xml";
            } catch (JsonParseException ex) {
                return "txt";
            } catch (IOException ex) {
                System.err.println("Ошибка при чтении XML: " + ex.getMessage());
                return "txt";
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return "txt";
        }
    }
}