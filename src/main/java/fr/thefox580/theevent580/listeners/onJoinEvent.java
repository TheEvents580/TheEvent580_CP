package fr.thefox580.theevent580.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {

    @EventHandler
    public void playerJoinsEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player.hasPermission("group.spectators")){
            event.setJoinMessage("["+ ChatColor.GREEN +"+"+ChatColor.RESET +"] "+ChatColor.DARK_GRAY +player.getName());
        }
        else {
            if (player.hasPermission("group.rouge")) {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + ChatColor.RED + player.getName());
            } else if (player.hasPermission("group.orange")) {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + ChatColor.GOLD + player.getName());
            } else if (player.hasPermission("group.jaune")) {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + ChatColor.YELLOW + player.getName());
            } else if (player.hasPermission("group.vert")) {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + ChatColor.GREEN + player.getName());
            } else if (player.hasPermission("group.bleu_clair")) {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + ChatColor.AQUA + player.getName());
            } else if (player.hasPermission("group.bleu")) {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + ChatColor.DARK_BLUE + player.getName());
            } else if (player.hasPermission("group.violet")) {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + ChatColor.DARK_PURPLE + player.getName());
            } else if (player.hasPermission("group.rose")) {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + ChatColor.LIGHT_PURPLE + player.getName());
            } else {
                event.setJoinMessage("[" + ChatColor.GREEN + "+" + ChatColor.RESET + "] " + player.getName());
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.hasPermission("theevent580.staff")) {
                        p.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Staff" + ChatColor.RESET + "] Player "
                                + player.getName() + "has joined the server but isn't assigned to a color (1st time playing / New color not assigned ? / Server not whitelisted ?)");
                    }
                }
            }
            if (System.currentTimeMillis() / 1000 > 1700938800) {
                if (player.isWhitelisted()){
                    if (!player.hasPermission("theevent580.tester")){
                        player.kickPlayer("Sorry, but you're not allowed to join the server yet !");
                    }
                }
            }
        }
    }
}