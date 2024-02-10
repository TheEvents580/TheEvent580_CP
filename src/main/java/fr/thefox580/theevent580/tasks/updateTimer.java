package fr.thefox580.theevent580.tasks;

import fr.thefox580.theevent580.main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

public class updateTimer extends BukkitRunnable {

    private final main plugin;

    public updateTimer(main plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {

        FileConfiguration config = plugin.getConfig();

        int second = config.getInt("timer_seconds");
        int minutes = config.getInt("timer_minutes");
        //String timer = config.getString("timer");

        if (second == 0){
            if (minutes > 0){
                config.set("timer_minutes", minutes-1);
                config.set("timer_seconds", 61);
            }
            else {
                config.set("timer", "Game End");
            }

        }

        second = config.getInt("timer_seconds");
        config.set("timer_seconds", second-1);

    }
}
