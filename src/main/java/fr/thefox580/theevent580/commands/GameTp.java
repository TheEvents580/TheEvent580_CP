package fr.thefox580.theevent580.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameTp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length != 0){
            commandSender.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] This command is only used to teleport ALL OF THE PLAYERS to the decision crystal, please retry without any arguments !");
        } else {
            for (Player player : Bukkit.getOnlinePlayers()){
                if (player.hasPermission("group.spectators")){
                    player.teleport(new Location(Bukkit.getWorld("world"), 0.5, 251, 0.5));
                } else if (player.hasPermission("group.rouge")) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 0.5, 251, 6.5));
                } else if (player.hasPermission("group.orange")) {
                    player.teleport(new Location(Bukkit.getWorld("world"), -5.5, 251, 6.5));
                } else if (player.hasPermission("group.jaune")) {
                    player.teleport(new Location(Bukkit.getWorld("world"), -5.5, 251, 0.5));
                } else if (player.hasPermission("group.vert")) {
                    player.teleport(new Location(Bukkit.getWorld("world"), -5.5, 251, -5.5));
                } else if (player.hasPermission("group.bleu_clair")) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 0.5, 251, -5.5));
                } else if (player.hasPermission("group.bleu")) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 6.5, 251, -5.5));
                } else if (player.hasPermission("group.violet")) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 6.5, 251, 0.5));
                } else if (player.hasPermission("group.rose")) {
                    player.teleport(new Location(Bukkit.getWorld("world"), 6.5, 251, 6.5));
                }
            }
            commandSender.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] Teleported all players to the decision crystal !");

        }

        return true;
    }
}
