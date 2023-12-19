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

        switch (strings[0]) {
            case "set" -> {
                config.set("timer_minutes", Integer.valueOf(strings[1]));
                config.set("timer_seconds", Integer.valueOf(strings[2]));
            }
            case "toggle" -> config.set("timer_mode", !(config.getBoolean("timer_mode")));
            case "mode" -> config.set("timer", strings[1]);
        }

        this.plugin.saveConfig();

        return true;
    }
}
