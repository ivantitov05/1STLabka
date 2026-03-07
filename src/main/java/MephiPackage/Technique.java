package MephiPackage;

public class Technique {
    private String name;
    private String type;
    private long damage;
    private String owner;  // Добавлено! Было только в JSON/TXT, но не в классе

    public Technique() {}

    // Геттеры и сеттеры для ВСЕХ полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long damage) {
        this.damage = damage;
    }

    // ДОБАВЛЕНО: поле owner
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}