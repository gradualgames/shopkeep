package com.gradualgames.shopkeep.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gradualgames.shopkeep.Shopkeep;
import com.gradualgames.shopkeep.character.BFCharacter;
import com.gradualgames.shopkeep.character.BFCharacterStore;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.IOException;

public class ShopkeepListener extends ListenerAdapter {

    private BFCharacterStore bfCharacterStore;

    public ShopkeepListener() throws IOException {
        bfCharacterStore = new BFCharacterStore();
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