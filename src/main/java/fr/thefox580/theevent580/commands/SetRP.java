package fr.thefox580.theevent580.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length != 2){
            commandSender.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] Please only use 2 arguments");
        }

        Player target = Bukkit.getPlayerExact(strings[0]);
        String URL = strings[1];

        if (target != null){
            target.setResourcePack(URL);
        }

        else{
            commandSender.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] " + target.getName() + " is not online");
        }

        return true;
    }
}
