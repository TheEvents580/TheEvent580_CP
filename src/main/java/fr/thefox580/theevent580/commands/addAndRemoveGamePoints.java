package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class addAndRemoveGamePoints implements CommandExecutor {

    private final main plugin;

    public addAndRemoveGamePoints(main plugin) {
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

                    long gamePointsPlayer = this.plugin.getConfig().getLong("game_points."+player.getUniqueId());

                    gamePointsPlayer += Long.parseLong(strings[1]);

                    String strGamePoints = strings[1];

                    if (gamePointsPlayer < 0){
                        strGamePoints = strGamePoints.substring(1);
                        commandSender.sendMessage("Removed "+ strGamePoints + " game points from player " + player.getName());
                    } else {
                        commandSender.sendMessage("Added " + strGamePoints + " game points to player " + player.getName());
                    }

                    this.plugin.getConfig().set("old_game_points."+player.getUniqueId(), this.plugin.getConfig().get("game_points."+player.getUniqueId()));
                    this.plugin.getConfig().set("game_points."+player.getUniqueId(), gamePointsPlayer);
                    this.plugin.saveConfig();

                }

            }

        }

        return true;
    }
}
