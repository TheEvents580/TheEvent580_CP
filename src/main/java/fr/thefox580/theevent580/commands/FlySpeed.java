package fr.thefox580.theevent580.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){
            Player p = (Player) commandSender;

            if (strings.length > 0){
                p.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Fly" + ChatColor.RESET + "] You should not set any arguments to that command");
            } else {
                float speed = p.getFlySpeed();
                if (speed >= 0.8F){
                    p.setFlySpeed(0.1F);
                    p.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Fly" + ChatColor.RESET + "] Your fly speed has been set to 1");
                } else {
                    p.setFlySpeed(speed+0.2F);
                    p.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Fly" + ChatColor.RESET + "] Your fly speed has been set to " + Math.round(speed*10+1));
                }
            }
        }

        return true;
    }
}
