package com.gradualgames.shopkeep.commands;

import com.gradualgames.shopkeep.character.Character;
import com.gradualgames.shopkeep.character.CharacterStore;
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

    private CharacterStore characterStore;

    public ShopkeepCommands() throws IOException {
        characterStore = new CharacterStore();
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
                            "gp",
                            "gold",
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
                    new SubcommandData("list", "List characters"),
                    new SubcommandData("add-ability", "Add special ability to character")
                        .addOption(
                            OptionType.STRING,
                            "name",
                            "Name of character to add ability to",
                            true
                        )
                        .addOption(
                            OptionType.STRING,
                            "type",
                            "Ability type",
                            true
                        )
                        .addOption(
                            OptionType.STRING,
                            "description",
                            "Ability description",
                            true
                        ),
                    new SubcommandData("update", "Updates a character stat.")
                        .addOption(
                            OptionType.STRING,
                            "name",
                            "Character name",
                            true
                        )
                        .addOption(
                            OptionType.STRING,
                            "stat",
                            "Stat name",
                            true
                        )
                        .addOption(
                            OptionType.STRING,
                            "value",
                            "Stat value",
                            true
                        )
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
                    String charClass = event.getOption("class").getAsString();
                    Integer level = event.getOption("level", null, OptionMapping::getAsInt);
                    Integer gp = event.getOption("gp", null, OptionMapping::getAsInt);
                    Integer xp = event.getOption("xp", null, OptionMapping::getAsInt);
                    Integer hp = event.getOption("hp", null, OptionMapping::getAsInt);
                    Integer maxHp = event.getOption("maxhp", null, OptionMapping::getAsInt);
                    Integer ac = event.getOption("ac", null, OptionMapping::getAsInt);
                    Integer atk = event.getOption("atk", null, OptionMapping::getAsInt);
                    Integer mvt = event.getOption("mvt", null, OptionMapping::getAsInt);
                    Integer strength = event.getOption("strength", null, OptionMapping::getAsInt);
                    Integer intelligence = event.getOption("intelligence", null, OptionMapping::getAsInt);
                    Integer wisdom = event.getOption("wisdom", null, OptionMapping::getAsInt);
                    Integer dexterity = event.getOption("dexterity", null, OptionMapping::getAsInt);
                    Integer constitution = event.getOption("constitution", null, OptionMapping::getAsInt);
                    Integer charisma = event.getOption("charisma", null, OptionMapping::getAsInt);

                    Character.Builder builder = new Character.Builder();
                    Character character =
                        builder.name(name)
                            .race(race)
                            .charClass(charClass)
                            .level(level)
                            .gp(gp)
                            .xp(xp)
                            .hp(hp)
                            .maxHp(maxHp)
                            .ac(ac)
                            .atk(atk)
                            .mvt(mvt)
                            .strength(strength)
                            .intelligence(intelligence)
                            .wisdom(wisdom)
                            .dexterity(dexterity)
                            .constitution(constitution)
                            .charisma(charisma)
                            .build();

                    try {
                        characterStore.save(character);
                    } catch (IOException e) {
                        System.out.println("Error, could not safe character.");
                        throw new RuntimeException(e);
                    }

                    System.out.println("character create command received.");
                }
                case "add-ability" -> {
                    String name = event.getOption("name").getAsString();
                    String type = event.getOption("type").getAsString();
                    String description = event.getOption("description").getAsString();
                    try {
                        Character character = characterStore.load(name);
                        character.getSpecialAbilities().putIfAbsent(type, description);
                        characterStore.save(character);
                    } catch (IOException e) {
                        System.out.println("Failed to load character: " + name);
                    }
                }
                case "update" -> {
                    String name = event.getOption("name").getAsString();
                    String stat = event.getOption("stat").getAsString();
                    String value = event.getOption("value").getAsString();
                    Character character = null;
                    try {
                        character = characterStore.load(name);
                        switch(stat) {
                            case "race" ->
                                character.setRace(value);
                            case "class" ->
                                character.setCharClass(value);
                            case "level" ->
                                character.setLevel(Integer.parseInt(value));
                            case "gp" ->
                                character.setGp(Integer.parseInt(value));
                            case "xp" ->
                                character.setXp(Integer.parseInt(value));
                            case "hp" ->
                                character.setHp(Integer.parseInt(value));
                            case "maxhp" ->
                                character.setMaxHp(Integer.parseInt(value));
                            case "ac" ->
                                character.setAc(Integer.parseInt(value));
                            case "atk" ->
                                character.setAtk(Integer.parseInt(value));
                            case "mvt" ->
                                character.setMvt(Integer.parseInt(value));
                            case "strength" ->
                                character.setStrength(Integer.parseInt(value));
                            case "intelligence" ->
                                character.setIntelligence(Integer.parseInt(value));
                            case "wisdom" ->
                                character.setWisdom(Integer.parseInt(value));
                            case "dexterity" ->
                                character.setDexterity(Integer.parseInt(value));
                            case "constitution" ->
                                character.setConstitution(Integer.parseInt(value));
                            case "charisma" ->
                                character.setCharisma(Integer.parseInt(value));
                        }
                        characterStore.save(character);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "list" -> {
                    System.out.println("character list command received.");
                }
            }
            event.reply("Done").queue();
        }
    }
}