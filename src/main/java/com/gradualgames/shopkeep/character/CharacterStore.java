package com.gradualgames.shopkeep.character;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
        Path file =
            characterDirectory.resolve(character.getName() + ".json");
        mapper.writeValue(file.toFile(), character);
    }
}