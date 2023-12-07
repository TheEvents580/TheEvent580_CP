package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class pronouns implements CommandExecutor {

    private final main plugin;

    public pronouns(main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        // Try to make a menu with pronouns 1 & 2

        if (commandSender instanceof Player){
            UUID playerUUID = Bukkit.getPlayerExact(commandSender.getName()).getUniqueId();

            FileConfiguration config = this.plugin.getConfig();

            config.set("pronouns_1." + playerUUID, s);
        }

        return true;
    }
}
