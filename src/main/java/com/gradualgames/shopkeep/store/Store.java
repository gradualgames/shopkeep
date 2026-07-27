package com.gradualgames.shopkeep.store;

import java.nio.file.Path;
import java.util.Locale;

public abstract class Store {

    private String dataDir;

    public Store(String dataDir) {
        this.dataDir = dataDir;
    }

    protected Path getCampaignDirectory(long guildId, String campaignName) {
        Path path = Path.of(dataDir, Long.toString(guildId), sanitizePathName(campaignName));
        return path;
    }

    protected String sanitizePathName(String pathName) {
        return pathName.trim().replace(' ', '-').toLowerCase(Locale.ROOT);
    }
}
