package com.gradualgames.shopkeep.character;

public class Spell {

    private Integer level;

    private Integer prepared;

    public Spell() {
    }

    public Spell(Integer level, int prepared) {
        this.level = level;
        this.prepared = prepared;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPrepared() {
        return prepared;
    }

    public void setPrepared(Integer prepared) {
        this.prepared = prepared;
    }

    public void prepare() {
        this.prepared++;
    }
}
