package fr.thefox580.theevent580.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jakarta.xml.bind.DatatypeConverter;

public class SetRP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length != 3){
            commandSender.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] Please only use 3 arguments");
        }

        Player target = Bukkit.getPlayerExact(strings[0]);
        String URL = strings[1];
        String toByte = strings[2];
        byte[] bytes = DatatypeConverter.parseHexBinary(toByte);

        if (target != null){
            target.setResourcePack(URL, bytes);
        }

        else{
            commandSender.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] " + target.getName() + " is not online");
        }

        return true;
    }
}
