package MephiPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TXTReader implements Reader {

    private File file;

    public TXTReader(File file) {
        this.file = file;
    }

    @Override
    public Mission extract(File file) throws IOException {
        this.file = file;
        return extract();
    }

    public Mission extract() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));

        Mission mission = new Mission();
        Curse curse = new Curse();
        List<Sorcerer> sorcerers = new ArrayList<>();
        List<Technique> techniques = new ArrayList<>();

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;

            String[] parts = line.split(": ", 2);
            if (parts.length < 2) continue;

            String key = parts[0].trim();
            String value = parts[1].trim();

            // Простые поля Mission
            if (key.equals("missionId")) {
                mission.setMissionId(value);
            }
            else if (key.equals("date")) {
                mission.setDate(value);
            }
            else if (key.equals("location")) {
                mission.setLocation(value);
            }
            else if (key.equals("outcome")) {
                mission.setOutcome(value);
            }
            else if (key.equals("damageCost")) {
                mission.setDamageCost(Long.parseLong(value));
            }

            // Поля Curse
            else if (key.equals("curse.name")) {
                curse.setName(value);
                mission.setCurse(curse);
            }
            else if (key.equals("curse.threatLevel")) {
                curse.setThreatLevel(value);
                mission.setCurse(curse);
            }

            // Поля Sorcerer
            else if (key.startsWith("sorcerer[")) {
                processSorcererField(key, value, sorcerers);
            }

            // Поля Technique
            else if (key.startsWith("technique[")) {
                processTechniqueField(key, value, techniques);
            }
        }

        mission.setSorcerers(sorcerers);
        mission.setTechniques(techniques);

        return mission;
    }

    private void processSorcererField(String key, String value, List<Sorcerer> sorcerers) {
        int index = parseIndex(key);
        String field = parseField(key);

        // Расширяем список если нужно (ГАРАНТИРОВАННО НЕ NULL)
        ensureSorcererListSize(sorcerers, index);

        Sorcerer sorcerer = sorcerers.get(index);  // теперь точно не null

        switch (field) {
            case "name":
                sorcerer.setName(value);
                break;
            case "rank":
                sorcerer.setRank(value);
                break;
        }
    }

    private void processTechniqueField(String key, String value, List<Technique> techniques) {
        int index = parseIndex(key);
        String field = parseField(key);

        // Расширяем список если нужно (ГАРАНТИРОВАННО НЕ NULL)
        ensureTechniqueListSize(techniques, index);

        Technique technique = techniques.get(index);  // теперь точно не null

        switch (field) {
            case "name":
                technique.setName(value);
                break;
            case "type":
                technique.setType(value);
                break;
            case "damage":
                technique.setDamage(Long.parseLong(value));
                break;
        }
    }

    // 👇 НОВЫЕ МЕТОДЫ: гарантированно создают объекты
    private void ensureSorcererListSize(List<Sorcerer> list, int index) {
        while (list.size() <= index) {
            list.add(new Sorcerer());  // всегда создаем новый объект!
        }
    }

    private void ensureTechniqueListSize(List<Technique> list, int index) {
        while (list.size() <= index) {
            list.add(new Technique());  // всегда создаем новый объект!
        }
    }

    private int parseIndex(String key) {
        int openBracket = key.indexOf('[');
        int closeBracket = key.indexOf(']');
        return Integer.parseInt(key.substring(openBracket + 1, closeBracket));
    }

    private String parseField(String key) {
        int closeBracket = key.indexOf(']');
        return key.substring(closeBracket + 2);
    }
}