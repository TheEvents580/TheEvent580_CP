package fr.thefox580.theevent580.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ride implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (Bukkit.getPlayer(strings[0]) != null){
            if (Bukkit.getPlayer(strings[1]) != null){
                Player p1 = Bukkit.getPlayerExact(strings[0]);
                Player p2 = Bukkit.getPlayerExact(strings[1]);

                if (p2.getPassenger() == null){
                    p2.setPassenger(p1);

                    p1.sendMessage("["+ChatColor.RED +"TheEvent580"+ChatColor.RESET+"] "+ChatColor.RED+p2.getName()+ChatColor.RESET+" grabbed you on their head !");
                    p2.sendMessage("["+ChatColor.RED +"TheEvent580"+ChatColor.RESET+"] You grabbed "+ChatColor.RED+p1.getName()+ChatColor.RESET+" on your head !");
                }
            }
        }

        return true;
    }
}
