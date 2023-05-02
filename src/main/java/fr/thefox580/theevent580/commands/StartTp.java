package fr.thefox580.theevent580.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartTp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length != 0){
            commandSender.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] This command is only used to teleport ALL OF THE PLAYERS to the decision crystal, please retry without any arguments !");
        }
        else{
            for (Player player : Bukkit.getOnlinePlayers()){
                player.teleport(new Location(Bukkit.getWorld("world"), 0.5, 251, 0.5));
            }
            commandSender.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] Teleported all players to the decision crystal !");
            }

        return true;
    }
}
