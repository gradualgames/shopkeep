package com.gradualgames.shopkeep.store;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Locale;

public class MapStore extends Store {

    private static final String MAP_PATH = "map";

    public MapStore(String dataDir) {
        super(dataDir);
    }

    public Path save(
        long guildId,
        String campaignName,
        String fileName,
        InputStream inputStream
    ) throws IOException {
        String safeFileName = Path.of(fileName).getFileName().toString();

        if (!isJpeg(safeFileName)) {
            throw new IOException("Map file must be a JPEG.");
        }

        Path mapDirectory = getMapDirectory(guildId, campaignName);
        Files.createDirectories(mapDirectory);

        Path mapFile = mapDirectory.resolve(safeFileName);
        Files.copy(inputStream, mapFile, StandardCopyOption.REPLACE_EXISTING);
        return mapFile;
    }

    public List<Path> loadAll(long guildId, String campaignName) throws IOException {
        Path mapDirectory = getMapDirectory(guildId, campaignName);

        if (!Files.isDirectory(mapDirectory)) {
            return List.of();
        }

        try (var paths = Files.list(mapDirectory)) {
            return paths
                .filter(Files::isRegularFile)
                .filter(path -> isJpeg(path.getFileName().toString()))
                .sorted((left, right) -> left.getFileName().toString()
                    .compareToIgnoreCase(right.getFileName().toString()))
                .toList();
        }
    }

    private Path getMapDirectory(long guildId, String campaignName) {
        return getCampaignDirectory(guildId, campaignName).resolve(MAP_PATH);
    }

    private boolean isJpeg(String fileName) {
        String lowerCaseFileName = fileName.toLowerCase(Locale.ROOT);
        return lowerCaseFileName.endsWith(".jpg") || lowerCaseFileName.endsWith(".jpeg");
    }
}
