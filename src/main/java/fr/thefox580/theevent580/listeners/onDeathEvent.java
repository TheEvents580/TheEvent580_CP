package fr.thefox580.theevent580.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onDeathEvent implements Listener {

    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent event){ //On player death
        event.setDeathMessage(""); //Clear death message
    }
}

