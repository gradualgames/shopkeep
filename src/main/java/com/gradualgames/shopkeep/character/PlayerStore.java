package com.gradualgames.shopkeep.character;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PlayerStore extends Store {

    private static final String PLAYERS_FILE = "players.json";

    private final ObjectMapper mapper =
        new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
            );

    public void save(long guildId, String campaignName, long userId, String characterName) throws IOException, IOException {
        Path campaignDirectory =
            getCampaignDirectory(guildId, campaignName);

        Files.createDirectories(campaignDirectory);

        Path path = campaignDirectory.resolve(PLAYERS_FILE);

        Map<String, String> players;

        if (Files.exists(path)) {
            players = mapper.readValue(
                path.toFile(),
                new TypeReference<Map<String, String>>() {}
            );
        } else {
            players = new HashMap<>();
        }

        players.put(Long.toString(userId), characterName);

        mapper.writeValue(path.toFile(), players);
    }

    public String load(long guildId, String campaignName, long userId) throws IOException {
        Path campaignDirectory =
            getCampaignDirectory(guildId, campaignName);

        Path path = campaignDirectory.resolve(PLAYERS_FILE);

        if (!Files.exists(path)) {
            return null;
        }

        Map<String, String> players =
            mapper.readValue(
                path.toFile(),
                new TypeReference<Map<String, String>>() {}
            );

        return players.get(Long.toString(userId));
    }
}
