package com.gradualgames.shopkeep.config;

import com.gradualgames.shopkeep.listener.ShopkeepListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopkeepConfig {

    @Value("${shopkeep.discord.token}")
    private String token;

    @Bean
    public JDA jda(ShopkeepListener shopkeepListener) throws InterruptedException {
        JDA jda = JDABuilder.createDefault(token)
                .addEventListeners(shopkeepListener)
                .build();
        jda.awaitReady();
        return jda;
    }

}
