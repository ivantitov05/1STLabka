package MephiPackage;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = FileChooser.selectFile();
        if (file == null) return;
        try {
            Mission mission = null;
            String type = FileTypeDetector.checkType(file);
            System.out.println("Тип файла: " + type);

            switch (type) {
                case "json":
                    mission = new JSONReader(file).extract(file);
                    break;
                case "xml":
                    mission = new XMLReader(file).extract(file);
                    break;
                case "txt":
                    mission = new TXTReader(file).extract();
                    break;
                default:
                    System.out.println("Неподдерживаемый формат");
                    return;
            }

            if (mission != null) {
                MissionPrinter.print(mission);
            }
        } catch (EmptyFileException | IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}