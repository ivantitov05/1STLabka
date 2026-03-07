package MephiPackage;

public class Curse {
    private String name;        // добавил private (было package-private)
    private String threatLevel;  // добавил private
    private Technique technique; // может быть null

    public Curse() {}  // пустой конструктор обязателен!

    public Curse(String name, String threatLevel) {
        this.name = name;
        this.threatLevel = threatLevel;
    }

    // Геттеры и сеттеры для ВСЕХ полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(String threatLevel) {
        this.threatLevel = threatLevel;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }
}