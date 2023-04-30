package fr.thefox580.theevent580.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class StartTp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player){

            Player p = (Player) commandSender;
            if (strings.length != 0){
                p.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] This command is only used to teleport ALL OF THE PLAYERS to the decision crystal, please retry without any arguments !");
            }
            else{
                for (Player player : Bukkit.getOnlinePlayers()){
                    player.teleport(new Location(Bukkit.getWorld("world"), 0, 250, 0));
                }
                p.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] Telepored all players to the decision crystal !");
            }

        }
        else if(commandSender instanceof ConsoleCommandSender){
            ConsoleCommandSender console = (ConsoleCommandSender) commandSender;
            for (Player player : Bukkit.getOnlinePlayers()){
                player.teleport(new Location(Bukkit.getWorld("world"), 0, 250, 0));
            }
            console.sendMessage("[" + ChatColor.RED + ChatColor.BOLD + "TheEvent580 - Admin" + ChatColor.RESET + "] Telepored all players to the decision crystal !");
        }

        return true;
    }
}
