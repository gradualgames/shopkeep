package com.gradualgames.shopkeep.listener;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Component
public class ShopkeepListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        System.out.println("onReady() called.");
    }
}
