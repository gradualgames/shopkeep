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

    private final Path characterDirectory =
        Path.of("data", "characters");

    public CharacterStore() throws IOException {
        Files.createDirectories(characterDirectory);
    }

    public void save(Character character) throws IOException {
        mapper.writeValue(
            characterFile(character.getName()).toFile(),
            character
        );
    }

    public Character load(String characterName) throws IOException {
        return mapper.readValue(
            characterFile(characterName).toFile(),
            Character.class
        );
    }

    private Path characterFile(String characterName) {
        String fileName = characterName
            .trim()
            .replace(' ', '-')
            .toLowerCase(Locale.ROOT);

        return characterDirectory.resolve(fileName + ".json");
    }
}