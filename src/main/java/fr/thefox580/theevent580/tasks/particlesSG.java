package fr.thefox580.theevent580.tasks;

import fr.thefox580.theevent580.main;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class particlesSG extends BukkitRunnable {

    private final main plugin;

    public particlesSG(main plugin){
        this.plugin = plugin;
    }
    @Override
    public void run() {

        FileConfiguration config = this.plugin.getConfig();

        for (int x = -100; x < 100; x++){
            for (int z =  -100; z < 100; z++){

                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromBGR(0, 0, 255), 4.0F);

                Location location = new Location(plugin.getServer().getWorld("SG4"), x, config.getInt("sg.height"), z);

                location.add(x, config.getInt("sg.height"), z);
                Objects.requireNonNull(plugin.getServer().getWorld("SG4")).spawnParticle(Particle.REDSTONE, location, 3, dustOptions);
                location.subtract(x, config.getInt("sg.height"), z);

            }
        }

    }
}
