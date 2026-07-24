package com.gradualgames.shopkeep;

import com.gradualgames.shopkeep.listener.ShopkeepListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.io.IOException;

public class Shopkeep {

    public static void main(String[] args) throws InterruptedException, IOException {
        String token = System.getenv("DISCORD_TOKEN");
        String serverId = System.getenv("SERVER_ID");
        ShopkeepListener shopkeepListener = new ShopkeepListener();
        JDA jda = JDABuilder.createDefault(token)
            .addEventListeners(shopkeepListener)
            .build();
        jda.awaitReady();
        Guild guild = jda.getGuildById(serverId);
        if (guild != null) {
            guild.upsertCommand("hello", "Tell Shopkeep to say hello.")
                .queue();
            guild.upsertCommand(
                Commands.slash("character", "Character commands")
                    .addSubcommands(
                        new SubcommandData("create", "Create a character")
                            .addOption(
                                OptionType.STRING,
                                "name",
                                "The character's name",
                                true
                            )
                            .addOption(
                                OptionType.STRING,
                                "race",
                                "The character's race",
                                true
                            )
                            .addOption(
                                OptionType.STRING,
                                "class",
                                "The character's class",
                                true
                            ),
                        new SubcommandData("list", "List characters")
                    )
            ).queue();
        }
    }
}
