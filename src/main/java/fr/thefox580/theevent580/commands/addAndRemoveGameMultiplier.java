package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class addAndRemoveGameMultiplier implements CommandExecutor {

    private final main plugin;
    private final main advMain;

    public addAndRemoveGameMultiplier(main plugin) {
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

                    double gameMultiplierPlayer = this.plugin.getConfig().getLong("multiplier_game."+player.getUniqueId());

                    gameMultiplierPlayer += Double.parseDouble(strings[1]);

                    String strGameMultiplier = strings[1];

                    if (gameMultiplierPlayer < 0){
                        strGameMultiplier = strGameMultiplier.substring(1);
                        commandSender.sendMessage("Removed "+ strGameMultiplier + " game points from player " + player.getName());
                    } else {
                        commandSender.sendMessage("Added " + strGameMultiplier + " game points to player " + player.getName());
                    }

                    this.plugin.getConfig().set("multiplier_game."+player.getUniqueId(), gameMultiplierPlayer);
                    this.plugin.saveConfig();

                }

            }

        }

        return true;
    }
}