package com.gradualgames.shopkeep.character;

public class Weapon {

    private String damage;
    private String range;
    private Integer rshort;
    private Integer rmedium;
    private Integer rlong;

    public Weapon() {
    }

    public Weapon(String damage, String range, Integer rshort, Integer rmedium, Integer rlong) {
        this.damage = damage;
        this.range = range;
        this.rshort = rshort;
        this.rmedium = rmedium;
        this.rlong = rlong;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Integer getRShort() {
        return rshort;
    }

    public void setRshort(Integer rshort) {
        this.rshort = rshort;
    }

    public Integer getRMedium() {
        return rmedium;
    }

    public void setRmedium(Integer rmedium) {
        this.rmedium = rmedium;
    }

    public Integer getRLong() {
        return rlong;
    }

    public void setRlong(Integer rlong) {
        this.rlong = rlong;
    }
}