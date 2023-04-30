package fr.thefox580.theevent580;

import fr.thefox580.theevent580.commands.FlySpeed;
import fr.thefox580.theevent580.commands.StartTp;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("TheEvent580's plugin started");

        getCommand("starttp").setExecutor(new StartTp());
        //getCommand("flyspeed").setExecutor(new FlySpeed());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("TheEvent580's plugin stopped");

    }
}
