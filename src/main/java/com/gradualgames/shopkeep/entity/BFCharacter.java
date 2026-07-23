package com.gradualgames.shopkeep.entity;

import jakarta.persistence.*;

@Entity
public class BFCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer level;

    @Column
    private Integer xp;

    @Column
    private Integer hp;

    @Column
    private Integer maxHp;

    @Column
    private Integer ac;

    @Column
    private Integer atk;

    @Column
    private Integer strength;

    @Column
    private Integer intelligence;

    @Column
    private Integer wisdom;

    @Column
    private Integer dexterity;

    @Column
    private Integer constitution;

    @Column
    private Integer charisma;

    public BFCharacter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        BFCharacter BFCharacter;

        public Builder() {
            BFCharacter = new BFCharacter();
        }

        public Builder name(String name) {
            BFCharacter.setName(name);
            return this;
        }

        public Builder level(Integer level) {
            BFCharacter.setLevel(level);
            return this;
        }

        public Builder xp(Integer xp) {
            BFCharacter.setXp(xp);
            return this;
        }

        public Builder hp(Integer hp) {
            BFCharacter.setHp(hp);
            return this;
        }

        public Builder maxhp(Integer maxhp) {
            BFCharacter.setMaxHp(maxhp);
            return this;
        }

        public Builder ac(Integer ac) {
            BFCharacter.setAc(ac);
            return this;
        }

        public Builder atk(Integer atk) {
            BFCharacter.setAtk(atk);
            return this;
        }

        public Builder strength(Integer strength) {
            BFCharacter.setStrength(strength);
            return this;
        }

        public Builder intelligence(Integer intelligence) {
            BFCharacter.setIntelligence(intelligence);
            return this;
        }

        public Builder wisdom(Integer wisdom) {
            BFCharacter.setWisdom(wisdom);
            return this;
        }

        public Builder dexterity(Integer dexterity) {
            BFCharacter.setDexterity(dexterity);
            return this;
        }

        public Builder constitution(Integer constitution) {
            BFCharacter.setConstitution(constitution);
            return this;
        }

        public Builder charisma(Integer charisma) {
            BFCharacter.setCharisma(charisma);
            return this;
        }

        public BFCharacter build() {
            return BFCharacter;
        }
    }
}