package MephiPackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Users/Ivan/Desktop/Данные о миссиях. Вариант 1/Mission A.txt");  // или .json, .xml

        try {
            // 1. Сначала определяем тип файла
            String fileType = detectFileType(file);
            System.out.println("Обнаружен формат: " + fileType);

            // 2. Создаем переменную для миссии
            Mission mission = null;

            // 3. В зависимости от типа вызываем нужный ридер
            switch (fileType) {
                case "json":
                    JSONReader jsonReader = new JSONReader(file);
                    mission = jsonReader.extract(file);
                    break;

                case "xml":
                    XMLReader xmlReader = new XMLReader(file);
                    mission = xmlReader.extract(file);
                    break;

                case "txt":
                    TXTReader txtReader = new TXTReader(file);
                    mission = txtReader.extract();
                    break;

                default:
                    System.out.println("Неподдерживаемый формат файла");
                    return;
            }

            // 4. Выводим результат
            if (mission != null) {
                System.out.println("✅ Миссия успешно загружена!");
                System.out.println("ID: " + mission.getMissionId());
                System.out.println("Локация: " + mission.getLocation());
            }

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Определяет тип файла с помощью readTree
     */
    public static String detectFileType(File file) {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        // Пробуем прочитать как JSON
        try {
            jsonMapper.readTree(file);
            return "json";  // Получилось! Это JSON
        } catch (IOException e) {
            // Не JSON, пробуем как XML
            try {
                xmlMapper.readTree(file);
                return "xml";  // Получилось! Это XML
            } catch (IOException ex) {
                // Не JSON и не XML - значит TXT
                return "txt";
            }
        }
    }
}