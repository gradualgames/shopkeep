package com.gradualgames.shopkeep.character;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FormatUtility {
    public static String formatMap(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            return "None";
        }

        return map.entrySet().stream()
            .map(entry -> "• " + entry.getKey() + ": " + entry.getValue())
            .collect(Collectors.joining("\n"));
    }

    public static String formatSet(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return "None";
        }

        return set.stream()
            .map(entry -> "• " + entry)
            .collect(Collectors.joining("\n"));
    }

    public static String formatSpells(Map<String, Spell> spells) {
        if (spells == null || spells.isEmpty()) {
            return "None";
        }

        return spells.entrySet().stream()
            .map(entry -> {
                Spell spell = entry.getValue();

                StringBuilder builder = new StringBuilder()
                    .append("• ")
                    .append(entry.getKey());

                if (spell.getLevel() != null) {
                    builder.append(" (Level ").append(spell.getLevel());
                }

                if (spell.getPrepared() != null) {
                    if (spell.getLevel() != null) {
                        builder.append(", ");
                    } else {
                        builder.append(" (");
                    }

                    builder.append("Prepared: ").append(spell.getPrepared());
                }

                if (spell.getLevel() != null || spell.getPrepared() != null) {
                    builder.append(")");
                }

                return builder.toString();
            })
            .collect(Collectors.joining("\n"));
    }

    public static String formatSpellSlots(Map<String, Spell> spells) {
        if (spells == null || spells.isEmpty()) {
            return IntStream.rangeClosed(1, 6)
                .mapToObj(level -> "L" + level + ": 0")
                .collect(Collectors.joining("\n"));
        }

        return IntStream.rangeClosed(1, 6)
            .mapToObj(level -> {
                int prepared = spells.values().stream()
                    .filter(spell -> spell.getLevel() != null && spell.getLevel() == level)
                    .mapToInt(spell -> spell.getPrepared() == null ? 0 : spell.getPrepared())
                    .sum();

                return "L" + level + ": " + prepared;
            })
            .collect(Collectors.joining("\n"));
    }

    public static String formatWeapons(Map<String, Weapon> weapons) {
        if (weapons == null || weapons.isEmpty()) {
            return "None";
        }

        return weapons.entrySet().stream()
            .map(entry -> {
                Weapon weapon = entry.getValue();

                StringBuilder builder = new StringBuilder()
                    .append("• ")
                    .append(entry.getKey())
                    .append(" (")
                    .append(weapon.getDamage());

                if (weapon.getRange() != null) {
                    builder.append(", ").append(weapon.getRange());
                }

                if (weapon.getRShort() != null) {
                    builder.append(", ")
                        .append(weapon.getRShort())
                        .append("/")
                        .append(weapon.getRMedium())
                        .append("/")
                        .append(weapon.getRLong());
                }

                builder.append(")");

                return builder.toString();
            })
            .collect(Collectors.joining("\n"));
    }
}
