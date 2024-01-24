package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setSGHeight implements CommandExecutor {

    private final main plugin;

    public setSGHeight(main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        FileConfiguration config = plugin.getConfig();

        if (strings.length != 1){

            commandSender.sendMessage("You must only use 1 argument");

        } else {
            double sgHeight = config.getDouble("sg.height");

            if (commandSender instanceof Player player){
                player.sendMessage("Set the Survival Games height to " + strings[0]);
            }

            config.set("sg.height_old", sgHeight);
            config.set("sg.height", Double.valueOf(strings[0]));
            plugin.saveConfig();
        }


        return true;
    }
}
