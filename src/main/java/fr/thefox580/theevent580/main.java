package fr.thefox580.theevent580;

import fr.thefox580.theevent580.commands.GameTp;
import fr.thefox580.theevent580.commands.Ride;
import fr.thefox580.theevent580.commands.SetRP;
import fr.thefox580.theevent580.commands.StartTp;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("TheEvent580's plugin started");

        getCommand("starttp").setExecutor(new StartTp());
        getCommand("gametp").setExecutor(new GameTp());
        getCommand("setrp").setExecutor(new SetRP());
        getCommand("rideplayer").setExecutor(new Ride());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("TheEvent580's plugin stopped");

    }
}
