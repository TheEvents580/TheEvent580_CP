package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class getGlobalMultiplier implements CommandExecutor {

    private final main plugin;

    public getGlobalMultiplier(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (strings.length != 0){
            commandSender.sendMessage("You may not use arguments for this command");
        }

        double multiplierTotal = this.plugin.getConfig().getDouble("multiplier_total");

        commandSender.sendMessage("The global multiplier currently is : " + multiplierTotal);

        return true;
    }
}
