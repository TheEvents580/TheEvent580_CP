package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class setConfigVar implements CommandExecutor {

    private final main plugin;

    public setConfigVar(main plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        FileConfiguration config = this.plugin.getConfig();

        String var_name = strings[0];
        String var_value = strings[1];

        config.set(var_name, var_value);

        return true;
    }
}
