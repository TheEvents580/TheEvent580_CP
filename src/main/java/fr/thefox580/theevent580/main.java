package fr.thefox580.theevent580;

import fr.thefox580.theevent580.commands.*;
import fr.thefox580.theevent580.listeners.*;
import fr.thefox580.theevent580.tasks.*;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.checkerframework.checker.nullness.qual.NonNull;

public class main extends JavaPlugin{

    private BukkitAudiences adventure;

    public @NonNull BukkitAudiences adventure() {
        if (this.adventure == null){
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled"); //Self-explanatory
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("TheEvent580's plugin started"); //Send a message on plugin start

        this.adventure = BukkitAudiences.create(this); //Implements Adventure to the plugin

        saveDefaultConfig(); //Saves the config in the plugin folder

        getCommand("starttp").setExecutor(new StartTp()); //Add the /starttp command to the plugin
        getCommand("gametp").setExecutor(new GameTp()); //Add the /gametp command to the plugin
        getCommand("setrp").setExecutor(new SetRP()); //Add the /setrp command to the plugin
        getCommand("rideplayer").setExecutor(new Ride()); //Add the /rideplayer command to the plugin
        getCommand("points").setExecutor(new addAndRemovePoints(this)); //Add the /points command to the plugin
        getCommand("gamepoints").setExecutor(new addAndRemoveGamePoints(this)); //Add the /gamepoints command to the plugin
        getCommand("totalpoints").setExecutor(new addAndRemoveTotalPoints(this)); //Add the /totalpoints command to the plugin
        getCommand("getpoints").setExecutor(new getPoints(this)); //Add the /getpoints command to the plugin
        getCommand("getgamepoints").setExecutor(new getGamePoints(this)); //Add the /getgamepoints command to the plugin
        getCommand("gettotalpoints").setExecutor(new getTotalPoints(this)); //Add the /gettotalpoints command to the plugin
        getCommand("setglobalmultiplier").setExecutor(new setGlobalMultiplier(this)); //Add the /setglobalmultiplier command to the plugin
        getCommand("getglobalmultiplier").setExecutor(new getGlobalMultiplier(this)); //Add the /getglobalmultiplier command to the plugin
        getCommand("gamemultiplier").setExecutor(new addAndRemoveGameMultiplier(this)); //Add the /gamemultiplier command to the plugin
        getCommand("timer").setExecutor(new setTimer(this)); //Add the /settimer command to the plugin
        getCommand("start").setExecutor(new startEvent()); //Add the /start command to the plugin
        getCommand("pronouns").setExecutor(new pronouns()); //Add the /pronouns command to the plugin
        getCommand("damage").setExecutor(new damage(this)); //Add the /damage command to the plugin
        getCommand("minecraftle").setExecutor(new minecraftle(this)); //Add the /minecraftle command to the plugin
        getCommand("setconfigvarplayer").setExecutor(new setConfigVarPlayer(this)); //Add the /setconfigvarplayer command to the plugin
        getCommand("setconfigvar").setExecutor(new setConfigVar(this)); //Add the /setconfigvar command to the plugin
        //getCommand("zone").setExecutor(new zone()); //Add the /zone command to the plugin
        getCommand("setsgheight").setExecutor(new setSGHeight(this)); //Add the /setsgheight to the plugin
        getCommand("setgame").setExecutor(new setGame(this)); // Add the /setgame to the plugin

        getServer().getPluginManager().registerEvents(new onJoinEvent(this), this); //Registers the join message on player join to the plugin
        getServer().getPluginManager().registerEvents(new onLeaveEvent(this), this); //Registers the leave message on player leave to the plugin
        getServer().getPluginManager().registerEvents(new onDeathEvent(this), this); //Registers the death message on player death to the plugin
        getServer().getPluginManager().registerEvents(new onMessage(this), this); //Registers the custom message on player message to the plugin
        getServer().getPluginManager().registerEvents(new checkGUIClick(this), this); //Registers when a players click in an inventory to the plugin
        getServer().getPluginManager().registerEvents(new onNoxesiumJoinEvent(), this); //Registers when a player joins the server to remove trident / boat collisions
        getServer().getPluginManager().registerEvents(new onDamage(this), this); //Registers when damage is dealt

        BukkitTask reloadScoreboadTask = new reloadScoreboard(this).runTaskTimer(this, 0L, 1L);
        BukkitTask reloadTimerTask = new reloadTimer(this).runTaskTimer(this, 0L, 20L);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("TheEvent580's plugin stopped"); //Send a message on plugin stop

    }
}
