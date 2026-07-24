package com.gradualgames.shopkeep;

import com.gradualgames.shopkeep.commands.ShopkeepCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import java.io.IOException;

public class Shopkeep {

    public static void main(String[] args) throws InterruptedException, IOException {
        String token = System.getenv("DISCORD_TOKEN");
        String serverId = System.getenv("SERVER_ID");
        ShopkeepCommands shopkeepCommands = new ShopkeepCommands();
        JDA jda = JDABuilder.createDefault(token)
            .addEventListeners(shopkeepCommands)
            .build();
        jda.awaitReady();
        Guild guild = jda.getGuildById(serverId);
        if (guild != null) {
            shopkeepCommands.registerCommands(guild);
        }
    }
}
