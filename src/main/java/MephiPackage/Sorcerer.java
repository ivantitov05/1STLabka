package MephiPackage;

public class Sorcerer {
    private String name;
    private String rank;
    private Technique technique;  // может быть null

    public Sorcerer() {}  // пустой конструктор обязателен!

    public Sorcerer(String name, String rank) {
        this.name = name;
        this.rank = rank;
    }

    // Геттеры и сеттеры для ВСЕХ полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }
}