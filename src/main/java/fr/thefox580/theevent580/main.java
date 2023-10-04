package fr.thefox580.theevent580;

import fr.thefox580.theevent580.commands.*;
import fr.thefox580.theevent580.listeners.onJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("TheEvent580's plugin started");

        getCommand("starttp").setExecutor(new StartTp());
        getCommand("gametp").setExecutor(new GameTp());
        getCommand("setrp").setExecutor(new SetRP());
        getCommand("rideplayer").setExecutor(new Ride());

        getServer().getPluginManager().registerEvents(new onJoinEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("TheEvent580's plugin stopped");

    }
}
