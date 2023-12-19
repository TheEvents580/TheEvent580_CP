package fr.thefox580.theevent580.listeners;

import fr.thefox580.theevent580.main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class checkGUIClick implements Listener {

    private final main plugin;

    public checkGUIClick(main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void checkGUIClickEvent(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("Are you sure to start ?")){
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Material.LIME_CONCRETE || event.getCurrentItem().getType() == Material.RED_CONCRETE){

                if (event.getCurrentItem().getType() == Material.LIME_CONCRETE) {
                    player.performCommand("timer mode 1");
                    player.performCommand("timer set 1 30");
                    player.performCommand("timer toggle");

                    plugin.adventure().players().sendMessage(Component.text("[")
                            .append(Component.text("TheEvent580", TextColor.color(255, 85, 85), TextDecoration.BOLD))
                            .append(Component.text("] Event starting in 1 minute and 30 seconds", TextColor.color(255, 255, 255))));

                    for (Player loopPlayer : Bukkit.getOnlinePlayers()){
                        loopPlayer.playSound(loopPlayer, "custom:intro", SoundCategory.VOICE, 1, 1);
                    }
                }

                player.closeInventory();
            }
        }
    }

}
