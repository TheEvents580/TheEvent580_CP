package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class setConfigVarPlayer implements CommandExecutor {

    private final main plugin;

    public setConfigVarPlayer(main plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        FileConfiguration config = this.plugin.getConfig();

        String var_name = strings[0];
        UUID playerUUID = Bukkit.getPlayer(strings[1]).getUniqueId();
        String var_value = strings[2];

        config.set(var_name+playerUUID, var_value);

        return true;
    }
}
