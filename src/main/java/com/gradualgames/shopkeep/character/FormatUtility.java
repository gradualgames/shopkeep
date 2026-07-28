package com.gradualgames.shopkeep.character;

import java.util.Map;
import java.util.stream.Collectors;

public class FormatUtility {
    public static String formatMap(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            return "None";
        }

        return map.entrySet().stream()
            .map(entry -> "• " + entry.getKey() + ": " + entry.getValue())
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
                    .append(weapon.damage());

                if (weapon.range() != null) {
                    builder.append(", ").append(weapon.range());
                }

                if (weapon.rshort() != null) {
                    builder.append(", ")
                        .append(weapon.rshort())
                        .append("/")
                        .append(weapon.rmedium())
                        .append("/")
                        .append(weapon.rlong());
                }

                builder.append(")");

                return builder.toString();
            })
            .collect(Collectors.joining("\n"));
    }
}
