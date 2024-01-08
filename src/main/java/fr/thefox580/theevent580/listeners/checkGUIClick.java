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

        if (event.getView().getTitle().equals("Set your pronouns")) {
            event.setCancelled(true);
            String pronoun1 = config.getString("pronoun_1." + playerUUID);
            String pronoun2 = config.getString("pronoun_2." + playerUUID);
            if (event.getCurrentItem().getType() == Material.RED_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "He";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "He";
                }
            }
            if (event.getCurrentItem().getType() == Material.ORANGE_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "She";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "She";
                }
            }
            if (event.getCurrentItem().getType() == Material.YELLOW_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "They";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "They";
                }
            }
            if (event.getCurrentItem().getType() == Material.LIME_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "Any";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "Any";
                }
            }
            if (event.getCurrentItem().getType() == Material.GREEN_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "All";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "All";
                }
            }
            if (event.getCurrentItem().getType() == Material.CYAN_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "Ask";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "Ask";
                }
            }
            if (event.getCurrentItem().getType() == Material.LIGHT_BLUE_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "Him";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "Him";
                }
            }
            if (event.getCurrentItem().getType() == Material.BLUE_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "Her";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "Her";
                }
            }
            if (event.getCurrentItem().getType() == Material.PURPLE_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "Them";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "Them";
                }
            }
            if (event.getCurrentItem().getType() == Material.MAGENTA_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "All";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "All";
                }
            }
            if (event.getCurrentItem().getType() == Material.PINK_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "Its";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "Its";
                }
            }
            if (event.getCurrentItem().getType() == Material.BROWN_CONCRETE){
                if (event.getClick().isLeftClick()){
                    pronoun1 = "Me";
                }
                if (event.getClick().isRightClick()){
                    pronoun2 = "Me";
                }
            }
            if (event.getCurrentItem().getType() == Material.BARRIER){
                player.closeInventory();
                player.sendMessage("You 1st pronoun is now set to : " + pronoun1);
                player.sendMessage("Your second pronoun is now set to : " + pronoun2);
                config.set("pronoun_1." + playerUUID, '[' + pronoun1);
                config.set("pronoun_2." + playerUUID, pronoun2 + ']');
            }
        }
    }
}
