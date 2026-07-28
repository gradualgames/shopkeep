package com.gradualgames.shopkeep.commands;

import com.gradualgames.shopkeep.character.Character;
import com.gradualgames.shopkeep.character.FormatUtility;
import com.gradualgames.shopkeep.store.CharacterStore;
import com.gradualgames.shopkeep.store.PlayerStore;
import com.gradualgames.shopkeep.character.Weapon;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

public class ShopkeepCommands extends ListenerAdapter {

    private static final Logger log = LoggerFactory.getLogger(ShopkeepCommands.class);

    private CharacterStore characterStore;

    private PlayerStore playerStore;

    private static final Random RANDOM = new Random();

    private static final String[] morshuQuotes = {
        "Lamp oil? Rope? Bombs? You want it? It's yours, my friend, as long as you have enough slash commands!",
        "Sorry, Link. I can't give credit! Come back when you're a little... mmmm... richer!",
        "MMMMMMMMMMMMMMMMMMMMMMMMMM"
    };

    public ShopkeepCommands(String dataDir) throws IOException {
        characterStore = new CharacterStore(dataDir);
        playerStore = new PlayerStore(dataDir);
    }

    public void registerCommands(Guild guild) {
        guild.upsertCommand("hello", "Tell Shopkeep to say hello")
            .queue();

        guild.upsertCommand(
            Commands.slash("create", "Create a character")
                .addOption(OptionType.STRING, "name", "name", true)
                .addOption(OptionType.STRING, "race", "race", true)
                .addOption(OptionType.STRING, "class", "class", true)
                .addOption(OptionType.INTEGER, "level", "level", false)
                .addOption(OptionType.INTEGER, "gp", "gold", false)
                .addOption(OptionType.INTEGER, "xp", "experience", false)
                .addOption(OptionType.INTEGER, "hp", "hit points", false)
                .addOption(OptionType.INTEGER, "maxhp", "max hit points", false)
                .addOption(OptionType.INTEGER, "ac", "armor class", false)
                .addOption(OptionType.INTEGER, "atk", "attack bonus", false)
                .addOption(OptionType.INTEGER, "mvt", "movement", false)
                .addOption(OptionType.INTEGER, "strength", "strength", false)
                .addOption(OptionType.INTEGER, "intelligence", "intelligence", false)
                .addOption(OptionType.INTEGER, "wisdom", "wisdom", false)
                .addOption(OptionType.INTEGER, "dexterity", "dexterity", false)
                .addOption(OptionType.INTEGER, "constitution", "constitution", false)
                .addOption(OptionType.INTEGER, "charisma", "charisma", false)
        ).queue();

        guild.upsertCommand(
            Commands.slash("update", "Update a character")
                .addOption(OptionType.STRING, "race", "race", false)
                .addOption(OptionType.STRING, "class", "class", false)
                .addOption(OptionType.INTEGER, "level", "level", false)
                .addOption(OptionType.INTEGER, "gp", "gold", false)
                .addOption(OptionType.INTEGER, "xp", "experience", false)
                .addOption(OptionType.INTEGER, "hp", "hit points", false)
                .addOption(OptionType.INTEGER, "maxhp", "max hit points", false)
                .addOption(OptionType.INTEGER, "ac", "armor class", false)
                .addOption(OptionType.INTEGER, "atk", "attack bonus", false)
                .addOption(OptionType.INTEGER, "mvt", "movement", false)
                .addOption(OptionType.INTEGER, "strength", "strength", false)
                .addOption(OptionType.INTEGER, "intelligence", "intelligence", false)
                .addOption(OptionType.INTEGER, "wisdom", "wisdom", false)
                .addOption(OptionType.INTEGER, "dexterity", "dexterity", false)
                .addOption(OptionType.INTEGER, "constitution", "constitution", false)
                .addOption(OptionType.INTEGER, "charisma", "charisma", false)
        ).queue();

        guild.upsertCommand(
            Commands.slash("play", "Play a character in a given campaign.")
                .addOption(OptionType.STRING, "character-name", "Character name", true)
        ).queue();

        guild.upsertCommand(
            Commands.slash("sheet", "Show character sheet")
        ).queue();

        guild.upsertCommand(
            Commands.slash("add-ability", "Add special ability to character")
                .addOption(OptionType.STRING, "type", "Ability type", true)
                .addOption(OptionType.STRING, "description", "Ability description", true)
        ).queue();

        guild.upsertCommand(
            Commands.slash("add-spell", "Add spell to character")
                .addOption(OptionType.STRING, "type", "Spell type", true)
                .addOption(OptionType.STRING, "description", "Spell description", true)
        ).queue();

        guild.upsertCommand(
            Commands.slash("add-saving-throw", "Add saving throw to character")
                .addOption(OptionType.STRING, "type", "Saving throw type", true)
                .addOption(OptionType.INTEGER, "value", "Saving throw value", true)
        ).queue();

        guild.upsertCommand(
            Commands.slash("add-equipment", "Add equipment to character")
                .addOption(OptionType.STRING, "type", "Equipment type", true)
                .addOption(OptionType.INTEGER, "quantity", "Equipment quantity", true)
        ).queue();

        guild.upsertCommand(
            Commands.slash("add-weapon", "Add weapon to character")
                .addOption(OptionType.STRING, "type", "Weapon type", true)
                .addOption(OptionType.STRING, "damage", "Weapon damage dice", true)
                .addOption(OptionType.STRING, "range", "Weapon range type", true)
                .addOption(OptionType.INTEGER, "short", "Short range bonus/penalty", false)
                .addOption(OptionType.INTEGER, "medium", "Medium range bonus/penalty", false)
                .addOption(OptionType.INTEGER, "long", "Long range bonus/penalty", false)
        ).queue();

        guild.upsertCommand(
            Commands.slash("health", "View health and AC")
        ).queue();

        guild.upsertCommand(
            Commands.slash("saving-throws", "View saving throws")
        ).queue();

        guild.upsertCommand(
            Commands.slash("abilities", "View abilities")
        ).queue();

        guild.upsertCommand(
            Commands.slash("spells", "View spells")
        ).queue();

        guild.upsertCommand(
            Commands.slash("equipment", "View equipment")
        ).queue();

        guild.upsertCommand(
            Commands.slash("weapons", "View weapons")
        ).queue();
    }

    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        log.info("onReady() called.");
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        long guildId = event.getGuild().getIdLong();
        long userId = event.getUser().getIdLong();
        String campaignName = event.getChannel().getName();
        String characterName = null;

        log.info(
            "Command /{} from {} ({}) in guild={} campaign={}",
            event.getName(),
            event.getUser().getName(),
            userId,
            guildId,
            campaignName
        );

        try {
            characterName = playerStore.load(guildId, campaignName, userId);
        } catch (IOException e) {
            log.error("Could not load player's claimed character.", e);
        }

        if (event.getName().equals("hello")) {
            log.info("hello command received.");
            event.reply(morshuQuotes[RANDOM.nextInt(morshuQuotes.length)]).queue();
        }
        switch (event.getName()) {
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
                    characterStore.save(guildId, campaignName, character);
                    log.info(
                        "Created character '{}' in campaign '{}'.",
                        name,
                        campaignName
                    );
                } catch (IOException e) {
                    log.error("Could not save character '{}'.", name, e);
                }
                event.reply("Done").setEphemeral(true).queue();
                return;
            }
            case "play" -> {
                String playCharacterName = event.getOption("character-name").getAsString();

                try {
                    playerStore.save(guildId, campaignName, userId, playCharacterName);
                    log.info(
                        "User {} is now playing '{}'.",
                        userId,
                        playCharacterName
                    );
                } catch (IOException e) {
                    log.error("Could not play character '{}'.", playCharacterName, e);
                }
                event.reply("Done.").setEphemeral(true).queue();
                return;
            }
        }

        if (characterName == null) {
            event.reply("User has not claimed a character in this campaign. Use /play first.").setEphemeral(true).queue();
            log.warn(
                "User {} attempted /{} without claiming a character.",
                userId,
                event.getName()
            );
            return;
        }

        switch (event.getName()) {
            case "update" -> {
                String race = event.getOption("race", null, OptionMapping::getAsString);
                String charClass = event.getOption("class", null, OptionMapping::getAsString);
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
                    builder.name(characterName)
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
                    characterStore.save(guildId, campaignName, character);
                    log.info(
                        "Updated character '{}' in campaign '{}'.",
                        characterName,
                        campaignName
                    );
                } catch (IOException e) {
                    log.error("Could not save character '{}'.", characterName, e);
                }
                event.reply("Done").setEphemeral(true).queue();
            }
            case "add-ability" -> {
                String type = event.getOption("type").getAsString();
                String description = event.getOption("description").getAsString();
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    character.getSpecialAbilities().putIfAbsent(type, description);
                    characterStore.save(guildId, campaignName, character);
                    log.info("Added ability '{}' to '{}'.", type, characterName);
                } catch (IOException e) {
                    log.error("Failed to load character '{}'", characterName, e);
                }
                event.reply("Done").setEphemeral(true).queue();
            }
            case "add-spell" -> {
                String type = event.getOption("type").getAsString();
                String description = event.getOption("description").getAsString();
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    character.getSpells().putIfAbsent(type, description);
                    characterStore.save(guildId, campaignName, character);
                    log.info("Added spell '{}' to '{}'.", type, characterName);
                } catch (IOException e) {
                    log.error("Failed to load character '{}'", characterName, e);
                }
                event.reply("Done").setEphemeral(true).queue();
            }
            case "add-saving-throw" -> {
                String type = event.getOption("type").getAsString();
                Integer value = event.getOption("value").getAsInt();
                Character character = null;
                try {
                    character = characterStore.load(guildId, campaignName, characterName);
                    character.getSavingThrows().putIfAbsent(type, value);
                    characterStore.save(guildId, campaignName, character);
                    log.info("Added saving throw '{}'={} to '{}'.", type, value, characterName);
                } catch (IOException e) {
                    log.error("Could not add saving throw to character '{}'", characterName, e);
                }
                event.reply("Done").setEphemeral(true).queue();
            }
            case "add-equipment" -> {
                String type = event.getOption("type").getAsString();
                Integer quantity = event.getOption("quantity").getAsInt();
                Character character = null;
                try {
                    character = characterStore.load(guildId, campaignName, characterName);
                    character.getEquipment().putIfAbsent(type, quantity);
                    characterStore.save(guildId, campaignName, character);
                    log.info(
                        "Added equipment '{}' x{} to '{}'.",
                        type,
                        quantity,
                        characterName
                    );
                } catch (IOException e) {
                    log.error("Could not add equipment to character '{}'", characterName, e);
                }
                event.reply("Done").setEphemeral(true).queue();
            }
            case "add-weapon" -> {
                String type = event.getOption("type").getAsString();
                String damage = event.getOption("damage").getAsString();
                String range = event.getOption("range").getAsString();
                Integer rshort = event.getOption("short", null, OptionMapping::getAsInt);
                Integer rmedium = event.getOption("medium", null, OptionMapping::getAsInt);
                Integer rlong = event.getOption("long", null, OptionMapping::getAsInt);
                Weapon weapon = new Weapon(damage, range, rshort, rmedium, rlong);
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    character.getWeapons().putIfAbsent(type, weapon);
                    characterStore.save(guildId, campaignName, character);
                    log.info("Added weapon '{}' to '{}'.", type, characterName);
                } catch (IOException e) {
                    log.error("Could not add weapon to '{}'.", characterName, e);
                }
                event.reply("Done").setEphemeral(true).queue();
            }
            case "sheet" -> {
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    log.info("Displayed character sheet for '{}'.", characterName);
                    event.reply(character.toString()).setEphemeral(true).queue();;
                } catch (IOException e) {
                    log.error("Could not load character '{}'", characterName, e);
                }
            }
            case "health" -> {
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    String health = """
                        ❤️ **HP:** %d/%d
                        🛡️ **AC:** %d                        
                        """.formatted(character.getHp(), character.getMaxHp(), character.getAc());
                    log.info("Displayed health for '{}'.", characterName);
                    event.reply(health).setEphemeral(true).queue();;
                } catch (IOException e) {
                    log.error("Could not load character '{}'", characterName, e);
                }
            }
            case "saving-throws" -> {
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    String savingThrows = """
                        🛡️ **Saving Throws:**
                        %s                        
                        """.formatted(FormatUtility.formatMap(character.getSavingThrows()));
                    log.info("Displayed saving throws for '{}'.", characterName);
                    event.reply(savingThrows).setEphemeral(true).queue();;
                } catch (IOException e) {
                    log.error("Could not load character '{}'", characterName, e);
                }
            }
            case "abilities" -> {
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    String abilities = """
                        ✨ **Special Abilities:**
                        %s
                        """.formatted(FormatUtility.formatMap(character.getSpecialAbilities()));
                    log.info("Displayed abilities for '{}'.", characterName);
                    event.reply(abilities).setEphemeral(true).queue();;
                } catch (IOException e) {
                    log.error("Could not load character '{}'", characterName, e);
                }
            }
            case "spells" -> {
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    String spells = """
                        🪄 **Spells:**
                        %s                        
                        """.formatted(FormatUtility.formatMap(character.getSpells()));
                    log.info("Displayed spells for '{}'.", characterName);
                    event.reply(spells).setEphemeral(true).queue();;
                } catch (IOException e) {
                    log.error("Could not load character '{}'", characterName, e);
                }
            }
            case "equipment" -> {
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    String equipment = """
                        🎒 **Equipment:**
                        %s
                        """.formatted(FormatUtility.formatMap(character.getEquipment()));
                    log.info("Displayed equipment for '{}'.", characterName);
                    event.reply(equipment).setEphemeral(true).queue();;
                } catch (IOException e) {
                    log.error("Could not load character '{}'", characterName, e);
                }
            }
            case "weapons" -> {
                try {
                    Character character = characterStore.load(guildId, campaignName, characterName);
                    String weapons = """
                        ⚔️ **Weapons:**
                        %s
                        """.formatted(FormatUtility.formatWeapons(character.getWeapons()));
                    log.info("Displayed weapons for '{}'.", characterName);
                    event.reply(weapons).setEphemeral(true).queue();;
                } catch (IOException e) {
                    log.error("Could not load character '{}'", characterName, e);
                }
            }
        }
    }
}