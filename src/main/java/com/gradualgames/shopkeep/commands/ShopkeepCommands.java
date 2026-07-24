package com.gradualgames.shopkeep.commands;

import com.gradualgames.shopkeep.character.BFCharacter;
import com.gradualgames.shopkeep.character.BFCharacterStore;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.io.IOException;

public class ShopkeepCommands extends ListenerAdapter {

    private BFCharacterStore bfCharacterStore;

    public ShopkeepCommands() throws IOException {
        bfCharacterStore = new BFCharacterStore();
    }

    public void registerCommands(Guild guild) {
        guild.upsertCommand("hello", "Tell Shopkeep to say hello.")
            .queue();
        guild.upsertCommand(
            Commands.slash("character", "Character commands")
                .addSubcommands(
                    new SubcommandData("create", "Create a character")
                        .addOption(
                            OptionType.STRING,
                            "name",
                            "name",
                            true
                        )
                        .addOption(
                            OptionType.STRING,
                            "race",
                            "race",
                            true
                        )
                        .addOption(
                            OptionType.STRING,
                            "class",
                            "class",
                            true
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "level",
                            "level",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "xp",
                            "experience",
                            false
                        ),
                    new SubcommandData("list", "List characters")
                )
        ).queue();
    }

    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        System.out.println("onReady() called.");
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("hello")) {
            System.out.println("hello command received.");
            event.reply("Lamp oil. Rope? Bombs? You want it? It's yours, my friend. As long as you have enough slash commands.").queue();
        }
        if (event.getName().equals("character")) {
            switch (event.getSubcommandName()) {
                case "create" -> {
                    String name = event.getOption("name").getAsString();
                    String race = event.getOption("race").getAsString();
                    String bfClass = event.getOption("class").getAsString();
                    Integer level = event.getOption("level").getAsInt();
                    Integer xp = event.getOption("xp").getAsInt();

                    BFCharacter.Builder builder = new BFCharacter.Builder();
                    BFCharacter bfCharacter =
                        builder.name(name)
                            .bfRace(race)
                            .bfClass(bfClass)
                            .level(level)
                            .xp(xp)
                            .build();

                    try {
                        bfCharacterStore.save(bfCharacter);
                    } catch (IOException e) {
                        System.out.println("Error, could not safe character.");
                        throw new RuntimeException(e);
                    }

                    System.out.println("character create command received.");
                }
                case "list" -> {
                    System.out.println("character list command received.");
                }
            }
            event.reply("Done").queue();
        }
    }
}