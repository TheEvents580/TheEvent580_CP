package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class addAndRemovePoints implements CommandExecutor {

    private final main plugin;

    public addAndRemovePoints(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings.length != 2){

            commandSender.sendMessage("You must only use 2 arguments");

        } else {

            Player player = Bukkit.getPlayer(strings[0]);

            if (player != null){
                if (player.isOnline()){

                    long pointsPlayer = this.plugin.getConfig().getLong("points."+player.getUniqueId());

                    pointsPlayer += Long.parseLong(strings[1]);

                    String strPoints = strings[1];

                    if (pointsPlayer < 0){
                        strPoints = strPoints.substring(1);
                        commandSender.sendMessage("Removed "+ strPoints + " points from player " + player.getName());
                    } else {
                        commandSender.sendMessage("Added " + strPoints + " points to player " + player.getName());
                    }

                    this.plugin.getConfig().set("old_points."+player.getUniqueId(), this.plugin.getConfig().get("points."+player.getUniqueId()));
                    this.plugin.getConfig().set("points."+player.getUniqueId(), pointsPlayer);
                    this.plugin.saveConfig();

                }

            }

        }

        return true;
    }
}
