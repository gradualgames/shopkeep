package com.gradualgames.shopkeep.config;

import com.gradualgames.shopkeep.listener.ShopkeepListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopkeepConfig {

    @Value("${shopkeep.discord.token}")
    private String token;

    @Value("${shopkeep.discord.server_id}")
    private String serverId;

    @Bean
    public JDA jda(ShopkeepListener shopkeepListener) throws InterruptedException {
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
                                    new SubcommandData("create", "Create a character"),
                                    new SubcommandData("list", "List characters")
                            )
            ).queue();
        }
        return jda;
    }

}
