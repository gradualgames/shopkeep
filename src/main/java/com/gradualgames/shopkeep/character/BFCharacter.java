package com.gradualgames.shopkeep.character;

public class BFCharacter {

    private String name;

    private String bfRace;

    private String bfClass;

    private Integer level;

    private Integer xp;

    private Integer hp;

    private Integer maxHp;

    private Integer ac;

    private Integer atk;

    private Integer strength;

    private Integer intelligence;

    private Integer wisdom;

    private Integer dexterity;

    private Integer constitution;

    private Integer charisma;

    public BFCharacter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBfRace() {
        return bfRace;
    }

    public void setBfRace(String bfRace) {
        this.bfRace = bfRace;
    }

    public String getBfClass() {
        return bfClass;
    }

    public void setBfClass(String bfClass) {
        this.bfClass = bfClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        BFCharacter bfCharacter;

        public Builder() {
            bfCharacter = new BFCharacter();
        }

        public Builder name(String name) {
            bfCharacter.setName(name);
            return this;
        }

        public Builder bfRace(String bfRace) {
            bfCharacter.bfRace = bfRace;
            return this;
        }

        public Builder bfClass(String bfClass) {
            bfCharacter.bfClass = bfClass;
            return this;
        }

        public Builder level(Integer level) {
            bfCharacter.setLevel(level);
            return this;
        }

        public Builder xp(Integer xp) {
            bfCharacter.setXp(xp);
            return this;
        }

        public Builder hp(Integer hp) {
            bfCharacter.setHp(hp);
            return this;
        }

        public Builder maxHp(Integer maxHp) {
            bfCharacter.setMaxHp(maxHp);
            return this;
        }

        public Builder ac(Integer ac) {
            bfCharacter.setAc(ac);
            return this;
        }

        public Builder atk(Integer atk) {
            bfCharacter.setAtk(atk);
            return this;
        }

        public Builder strength(Integer strength) {
            bfCharacter.setStrength(strength);
            return this;
        }

        public Builder intelligence(Integer intelligence) {
            bfCharacter.setIntelligence(intelligence);
            return this;
        }

        public Builder wisdom(Integer wisdom) {
            bfCharacter.setWisdom(wisdom);
            return this;
        }

        public Builder dexterity(Integer dexterity) {
            bfCharacter.setDexterity(dexterity);
            return this;
        }

        public Builder constitution(Integer constitution) {
            bfCharacter.setConstitution(constitution);
            return this;
        }

        public Builder charisma(Integer charisma) {
            bfCharacter.setCharisma(charisma);
            return this;
        }

        public BFCharacter build() {
            return bfCharacter;
        }
    }
}