package com.gradualgames.shopkeep.commands;

import com.gradualgames.shopkeep.character.BFCharacter;
import com.gradualgames.shopkeep.character.BFCharacterStore;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
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
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "hp",
                            "hit points",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "maxhp",
                            "max hit points",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "ac",
                            "armor class",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "atk",
                            "attack bonus",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "mvt",
                            "movement",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "strength",
                            "strength",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "intelligence",
                            "intelligence",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "wisdom",
                            "wisdom",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "dexterity",
                            "dexterity",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "constitution",
                            "constitution",
                            false
                        )
                        .addOption(
                            OptionType.INTEGER,
                            "charisma",
                            "charisma",
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
                    Integer level = event.getOption("level", null, OptionMapping::getAsInt);
                    Integer gp = event.getOption("gp", null, OptionMapping::getAsInt);
                    Integer xp = event.getOption("xp", null, OptionMapping::getAsInt);
                    Integer hp = event.getOption("hp", null, OptionMapping::getAsInt);
                    Integer maxHp = event.getOption("maxhp", null, OptionMapping::getAsInt);
                    Integer ac = event.getOption("ac", null, OptionMapping::getAsInt);
                    Integer atk = event.getOption("atk", null, OptionMapping::getAsInt);
                    Integer strength = event.getOption("strength", null, OptionMapping::getAsInt);
                    Integer intelligence = event.getOption("intelligence", null, OptionMapping::getAsInt);
                    Integer wisdom = event.getOption("wisdom", null, OptionMapping::getAsInt);
                    Integer dexterity = event.getOption("dexterity", null, OptionMapping::getAsInt);
                    Integer constitution = event.getOption("constitution", null, OptionMapping::getAsInt);
                    Integer charisma = event.getOption("charisma", null, OptionMapping::getAsInt);

                    BFCharacter.Builder builder = new BFCharacter.Builder();
                    BFCharacter bfCharacter =
                        builder.name(name)
                            .bfRace(race)
                            .bfClass(bfClass)
                            .level(level)
                            .gp(gp)
                            .xp(xp)
                            .hp(hp)
                            .maxHp(maxHp)
                            .ac(ac)
                            .atk(atk)
                            .strength(strength)
                            .intelligence(intelligence)
                            .wisdom(wisdom)
                            .dexterity(dexterity)
                            .constitution(constitution)
                            .charisma(charisma)
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