package fr.thefox580.theevent580;

import fr.thefox580.theevent580.commands.*;
import fr.thefox580.theevent580.listeners.*;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;

public class main extends JavaPlugin{

    private BukkitAudiences adventure;

    public @NonNull BukkitAudiences adventure() {
        if (this.adventure == null){
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("TheEvent580's plugin started");

        this.adventure = BukkitAudiences.create(this);

        getCommand("starttp").setExecutor(new StartTp());
        getCommand("gametp").setExecutor(new GameTp());
        getCommand("setrp").setExecutor(new SetRP());
        getCommand("rideplayer").setExecutor(new Ride());

        getServer().getPluginManager().registerEvents(new onJoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new onLeaveEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("TheEvent580's plugin stopped");

    }
}
