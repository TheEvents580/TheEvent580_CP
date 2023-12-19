package fr.thefox580.theevent580.tasks;

import fr.thefox580.theevent580.main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class reloadTimer extends BukkitRunnable {

    private final main plugin;

    public reloadTimer(main plugin){
        this.plugin = plugin;
    }
    @Override
    public void run() {

        FileConfiguration config = this.plugin.getConfig();

        if (config.getBoolean("timer_mode")){
            if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") > 0){
                config.set("timer_minutes", config.getInt("timer_minutes") - 1);
                config.set("timer_seconds", config.getInt("timer_seconds") + 60);
            }
            if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0){
                if (!Objects.equals(config.getString("timer"), "10")){
                    config.set("timer", String.valueOf(Integer.parseInt(config.getString("timer")) + 1));
                } else {
                    config.set("timer", "End");
                }
            }
            config.set("timer_seconds", config.getInt("timer_seconds") - 1);
            plugin.saveConfig();
        }
    }
}
