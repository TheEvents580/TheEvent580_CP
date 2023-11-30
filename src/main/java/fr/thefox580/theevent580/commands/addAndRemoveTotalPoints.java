package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class addAndRemoveTotalPoints implements CommandExecutor {

    private final main plugin;
    private final main advMain;

    public addAndRemoveTotalPoints(main plugin) {
        this.plugin = plugin;
        this.advMain = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings.length != 2){

            commandSender.sendMessage("You must only use 2 arguments");

        } else {

            Player player = Bukkit.getPlayer(strings[0]);

            if (player != null){
                if (player.isOnline()){

                    long totalPointsPlayer = this.plugin.getConfig().getLong("total_points."+player.getUniqueId());

                    totalPointsPlayer += Long.parseLong(strings[1]);

                    String strTotalPoints = strings[1];

                    if (totalPointsPlayer < 0){
                        strTotalPoints = strTotalPoints.substring(1);
                        commandSender.sendMessage("Removed "+ strTotalPoints + " total points from player " + player.getName());
                    } else {
                        commandSender.sendMessage("Added " + totalPointsPlayer + " total points to player " + player.getName());
                    }

                    this.plugin.getConfig().set("total_points."+player.getUniqueId(), totalPointsPlayer);
                    this.plugin.saveConfig();

                }

            }

        }

        return true;
    }
}
