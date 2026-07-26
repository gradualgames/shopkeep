package com.gradualgames.shopkeep.character;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class CharacterStore {

    private final ObjectMapper mapper =
        new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false
            );

    public CharacterStore() {
    }

    public void save(long guildId, String campaignName, Character character) throws IOException {
        Path path = getCampaignDirectory(guildId, campaignName);
        Files.createDirectories(path);
        mapper.writeValue(
            characterFile(path, character.getName()).toFile(),
            character
        );
    }

    public Character load(long guildId, String campaignName, String characterName) throws IOException {
        Path path = getCampaignDirectory(guildId, campaignName);
        return mapper.readValue(
            characterFile(path, characterName).toFile(),
            Character.class
        );
    }

    private Path getCampaignDirectory(long guildId, String campaignName) {
        Path path = Path.of("data", Long.toString(guildId), sanitizePathName(campaignName), "character");
        return path;
    }

    private String sanitizePathName(String pathName) {
        return pathName.trim().replace(' ', '-').toLowerCase(Locale.ROOT);
    }

    private Path characterFile(Path campaignDirectory, String characterName) {
        return campaignDirectory.resolve(sanitizePathName(characterName) + ".json");
    }
}