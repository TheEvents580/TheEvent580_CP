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

import java.util.UUID;

public class checkGUIClick implements Listener {

    private final main plugin;

    public checkGUIClick(main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void checkGUIClickEvent(InventoryClickEvent event) {

        FileConfiguration config = plugin.getConfig();

        Player player = (Player) event.getWhoClicked();

        UUID playerUUID = player.getUniqueId();

        if (event.getView().getTitle().equals("Are you sure to start ?")) {
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Material.LIME_CONCRETE || event.getCurrentItem().getType() == Material.RED_CONCRETE) {

                if (event.getCurrentItem().getType() == Material.LIME_CONCRETE) {
                    player.performCommand("timer mode 1");
                    player.performCommand("timer set 1 30");
                    player.performCommand("timer toggle");

                    plugin.adventure().players().sendMessage(Component.text("[")
                            .append(Component.text("TheEvent580", TextColor.color(255, 85, 85), TextDecoration.BOLD))
                            .append(Component.text("] Event starting in 1 minute and 30 seconds", TextColor.color(255, 255, 255))));

                    for (Player loopPlayer : Bukkit.getOnlinePlayers()) {
                        loopPlayer.playSound(loopPlayer, "custom:intro", SoundCategory.VOICE, 1, 1);
                    }
                }

                player.closeInventory();
            }
        }

        if (event.getView().getTitle().equals("Choose you pronouns :")) {
            event.setCancelled(true);
            if (event.getCurrentItem().getType() == Material.RED_CONCRETE) {
                config.set("pronouns_1." + playerUUID, "[He");
                player.sendMessage("Your 1st pronoun has been set to \"He\"");
            }
            if (event.getCurrentItem().getType() == Material.ORANGE_CONCRETE) {
                config.set("pronouns_1." + playerUUID, "[She");
                player.sendMessage("Your 1st pronoun has been set to \"She\"");
            }
            if (event.getCurrentItem().getType() == Material.YELLOW_CONCRETE) {
                config.set("pronouns_1." + playerUUID, "[They");
                player.sendMessage("Your 1st pronoun has been set to \"They\"");
            }
            if (event.getCurrentItem().getType() == Material.LIME_CONCRETE) {
                config.set("pronouns_1." + playerUUID, "[Any");
                player.sendMessage("Your 1st pronoun has been set to \"Any\"");
            }
            if (event.getCurrentItem().getType() == Material.GREEN_CONCRETE) {
                config.set("pronouns_2." + playerUUID, "Him]");
                player.sendMessage("Your 2nd pronoun has been set to \"Him\"");
            }
            if (event.getCurrentItem().getType() == Material.CYAN_CONCRETE) {
                config.set("pronouns_2." + playerUUID, "Her]");
                player.sendMessage("Your 2nd pronoun has been set to \"Her\"");
            }
            if (event.getCurrentItem().getType() == Material.LIGHT_BLUE_CONCRETE) {
                config.set("pronouns_2." + playerUUID, "Them]");
                player.sendMessage("Your 2nd pronoun has been set to \"Them\"");
            }
            if (event.getCurrentItem().getType() == Material.BLUE_CONCRETE) {
                config.set("pronouns_2." + playerUUID, "All]");
                player.sendMessage("Your 2nd pronoun has been set to \"All\"");
            }

            if (event.getCurrentItem().getType() == Material.BARRIER) {
                player.closeInventory();
            }
        }
    }
}
