package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class setTimer implements CommandExecutor {

    private final main plugin;

    public setTimer(main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        FileConfiguration config = this.plugin.getConfig();

        if (strings[0].equals("set")){
            config.set("timer_minutes", Integer.valueOf(strings[1]));
            config.set("timer_seconds", Integer.valueOf(strings[2]));
        } else if (strings[0].equals("toggle")){
            if (config.getBoolean("timer_mode")){
                config.set("timer_mode", false);
            } else {
                config.set("timer_mode", true);
            }
        }

        this.plugin.saveConfig();

        return true;
    }
}
