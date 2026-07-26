package com.gradualgames.shopkeep.character;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class CharacterStore extends Store {

    private static final String CHARACTER_PATH = "character";

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
        Path characterPath = getCampaignDirectory(guildId, campaignName).resolve(CHARACTER_PATH);
        Files.createDirectories(characterPath);
        mapper.writeValue(
            characterFile(characterPath, character.getName()).toFile(),
            character
        );
    }

    public Character load(long guildId, String campaignName, String characterName) throws IOException {
        Path characterPath = getCampaignDirectory(guildId, campaignName).resolve(CHARACTER_PATH);
        return mapper.readValue(
            characterFile(characterPath, characterName).toFile(),
            Character.class
        );
    }

    private Path characterFile(Path campaignDirectory, String characterName) {
        return campaignDirectory.resolve(sanitizePathName(characterName) + ".json");
    }
}