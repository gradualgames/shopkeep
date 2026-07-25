package com.gradualgames.shopkeep.character;

import java.util.List;

public class Character {

    private String name;

    private String race;

    private String charClass;

    private Integer level;

    private Integer gp;

    private Integer xp;

    private Integer hp;

    private Integer maxHp;

    private Integer ac;

    private Integer atk;

    private Integer mvt;

    private Integer strength;

    private Integer intelligence;

    private Integer wisdom;

    private Integer dexterity;

    private Integer constitution;

    private Integer charisma;

    private List<SpecialAbility> specialAbilities;

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGp() {
        return gp;
    }

    public void setGp(Integer gp) {
        this.gp = gp;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getMvt() {
        return mvt;
    }

    public void setMvt(Integer mvt) {
        this.mvt = mvt;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public List<SpecialAbility> getSpecialAbilities() {
        return specialAbilities;
    }

    public void setSpecialAbilities(List<SpecialAbility> specialAbilities) {
        this.specialAbilities = specialAbilities;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        Character character;

        public Builder() {
            character = new Character();
        }

        public Builder name(String name) {
            character.setName(name);
            return this;
        }

        public Builder race(String race) {
            character.setRace(race);
            return this;
        }

        public Builder charClass(String charClass) {
            character.setCharClass(charClass);
            return this;
        }

        public Builder level(Integer level) {
            character.setLevel(level);
            return this;
        }

        public Builder gp(Integer gp) {
            character.setGp(gp);
            return this;
        }

        public Builder xp(Integer xp) {
            character.setXp(xp);
            return this;
        }

        public Builder hp(Integer hp) {
            character.setHp(hp);
            return this;
        }

        public Builder maxHp(Integer maxHp) {
            character.setMaxHp(maxHp);
            return this;
        }

        public Builder ac(Integer ac) {
            character.setAc(ac);
            return this;
        }

        public Builder atk(Integer atk) {
            character.setAtk(atk);
            return this;
        }

        public Builder mvt(Integer mvt) {
            character.setMvt(mvt);
            return this;
        }

        public Builder strength(Integer strength) {
            character.setStrength(strength);
            return this;
        }

        public Builder intelligence(Integer intelligence) {
            character.setIntelligence(intelligence);
            return this;
        }

        public Builder wisdom(Integer wisdom) {
            character.setWisdom(wisdom);
            return this;
        }

        public Builder dexterity(Integer dexterity) {
            character.setDexterity(dexterity);
            return this;
        }

        public Builder constitution(Integer constitution) {
            character.setConstitution(constitution);
            return this;
        }

        public Builder charisma(Integer charisma) {
            character.setCharisma(charisma);
            return this;
        }

        public Character build() {
            return character;
        }
    }
}