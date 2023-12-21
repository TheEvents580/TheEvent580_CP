package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class damage implements CommandExecutor {

    private final main plugin;

    public damage(main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        FileConfiguration config = plugin.getConfig();

        config.set("damage_enabled", !config.getBoolean("damage_enabled"));

        if (config.getBoolean("damage_enabled")){
            commandSender.sendMessage("Damages have been enabled");
        } else {
            commandSender.sendMessage("Damages have been disabled");
        }

        return false;
    }
}
