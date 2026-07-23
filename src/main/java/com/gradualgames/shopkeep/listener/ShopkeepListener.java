package com.gradualgames.shopkeep.listener;

import com.gradualgames.shopkeep.entity.BFCharacter;
import com.gradualgames.shopkeep.service.BFCharacterService;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopkeepListener extends ListenerAdapter {

    private static final Logger log = LoggerFactory.getLogger(ShopkeepListener.class);

    private BFCharacterService bfCharacterService;

    public ShopkeepListener(BFCharacterService bfCharacterService) {
        this.bfCharacterService = bfCharacterService;
    }

    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        System.out.println("onReady() called.");
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("hello")) {
            log.info("hello command received.");
            event.reply("Lamp oil. Rope? Bombs? You want it? It's yours, my friend. As long as you have enough slash commands.").queue();
        }
        if (event.getName().equals("character")) {
            switch (event.getSubcommandName()) {
                case "create" -> {
                    BFCharacter.Builder builder = new BFCharacter.Builder();
                    BFCharacter bfCharacter = builder.name("Evangeline")
                            .level(1).xp(1106)
                            .hp(7).maxhp(7)
                            .ac(15).atk(1)
                            .strength(9)
                            .intelligence(11)
                            .wisdom(15)
                            .dexterity(13)
                            .constitution(13)
                            .charisma(8).build();
                    bfCharacterService.createCharacter(bfCharacter);
                    event.reply("Character created.").queue();
                }
                case "list" -> {
                    List<BFCharacter> allCharacters = bfCharacterService.getAllCharacters();
                    if (allCharacters.isEmpty()) {
                        event.reply("I'm sorry Link, but you have no characters.").queue();
                    } else {
                        StringBuilder fullReply = new StringBuilder();
                        for(BFCharacter bfCharacter: allCharacters) {
                            fullReply.append("""
                                    📜 **%s**
                                    
                                    Level: %d
                                    XP: %d
                                    
                                    HP: %d/%d
                                    AC: %d
                                    ATK: %+d
                                    
                                    STR %2d
                                    INT %2d
                                    WIS %2d
                                    DEX %2d
                                    CON %2d
                                    CHA %2d
                                    """
                                    .formatted(
                                            bfCharacter.getName(),
                                            bfCharacter.getLevel(),
                                            bfCharacter.getXp(),
                                            bfCharacter.getHp(),
                                            bfCharacter.getMaxHp(),
                                            bfCharacter.getAc(),
                                            bfCharacter.getAtk(),
                                            bfCharacter.getStrength(),
                                            bfCharacter.getIntelligence(),
                                            bfCharacter.getWisdom(),
                                            bfCharacter.getDexterity(),
                                            bfCharacter.getConstitution(),
                                            bfCharacter.getCharisma()
                                    ));
                        }
                        event.reply(fullReply.toString()).queue();
                    }
                }
            }
        }
    }
}
