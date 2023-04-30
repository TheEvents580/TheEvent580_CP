package fr.thefox580.theevent580;

import fr.thefox580.theevent580.commands.StartTp;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("TheEvent580's plugin started");

        Objects.requireNonNull(getCommand("starttp")).setExecutor(new StartTp());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("TheEvent580's plugin stopped");

    }
}
