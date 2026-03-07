package MephiPackage;

import java.util.List;

public class Mission {
    private String missionId;
    private String date;
    private String location;
    private String outcome;
    private long damageCost;
    private Curse curse;
    private List<Sorcerer> sorcerers;
    private List<Technique> techniques;

    // Пустой конструктор обязателен!
    public Mission() {}

    // Геттеры и сеттеры для ВСЕХ полей

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public long getDamageCost() {
        return damageCost;
    }

    public void setDamageCost(long damageCost) {
        this.damageCost = damageCost;
    }

    public Curse getCurse() {
        return curse;
    }

    public void setCurse(Curse curse) {           // ← этого не хватало
        this.curse = curse;
    }

    public List<Sorcerer> getSorcerers() {
        return sorcerers;
    }

    public void setSorcerers(List<Sorcerer> sorcerers) {  // ← этого не хватало
        this.sorcerers = sorcerers;
    }

    public List<Technique> getTechniques() {
        return techniques;
    }

    public void setTechniques(List<Technique> techniques) {  // ← этого не хватало
        this.techniques = techniques;
    }

    // Вспомогательные методы для удобства

    public void addSorcerer(Sorcerer sorcerer) {
        if (this.sorcerers == null) {
            this.sorcerers = new java.util.ArrayList<>();
        }
        this.sorcerers.add(sorcerer);
    }

    public void addTechnique(Technique technique) {
        if (this.techniques == null) {
            this.techniques = new java.util.ArrayList<>();
        }
        this.techniques.add(technique);
    }
}