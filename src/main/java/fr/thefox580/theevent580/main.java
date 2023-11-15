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
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled"); //Tell the plugin Adventure is already used
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("TheEvent580's plugin started"); //Send a message on plugin start

        this.adventure = BukkitAudiences.create(this); //Implements Adventure to the plugin

        getCommand("starttp").setExecutor(new StartTp()); //Add the /starttp command to the plugin
        getCommand("gametp").setExecutor(new GameTp()); //Add the /gametp command to the plugin
        getCommand("setrp").setExecutor(new SetRP()); //Add the /setrp command to the plugin
        getCommand("rideplayer").setExecutor(new Ride()); //Add the /rideplayer command to the plugin

        getServer().getPluginManager().registerEvents(new onJoinEvent(this), this); //Registers the join message on player join to the plugin
        getServer().getPluginManager().registerEvents(new onLeaveEvent(this), this); //Registers the leave message on player leave to the plugin
        getServer().getPluginManager().registerEvents(new onDeathEvent(this), this); //Registers the death message on player death to the plugin

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("TheEvent580's plugin stopped"); //Send a message on plugin stop

    }
}
