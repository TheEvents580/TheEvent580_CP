package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class setGlobalMultiplier implements CommandExecutor {

    private final main plugin;

    public setGlobalMultiplier(main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings.length != 1 ){
            commandSender.sendMessage("You may only use one argument");
        } else {

            double multiplierTotal = Double.parseDouble(s);

            this.plugin.getConfig().set("multiplier_total", multiplierTotal);

            commandSender.sendMessage("The global multiplier has been set to : " + multiplierTotal);

        }

        return true;
    }
}
