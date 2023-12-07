package fr.thefox580.theevent580.tasks;

import fr.thefox580.theevent580.main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.io.File;

public class reloadScoreboard extends BukkitRunnable {

    private final main plugin;

    public reloadScoreboard(main plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {

        FileConfiguration config = this.plugin.getConfig();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("title", Criteria.DUMMY, Component.text(ChatColor.BOLD + "Kill the Ender Dragon", TextColor.color(255, 85, 85)).toString());
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score blank = objective.getScore("");
        blank.setScore(12);

        Score timer = objective.getScore("Time : " + config.getInt("timer_minutes") + " : " + config.getInt("timer_seconds"));
        if (config.getInt("timer_minutes") < 10){
            if (config.getInt("timer_seconds") < 10) {
                timer = objective.getScore("Time : 0" + config.getInt("timer_minutes") + " : 0" + config.getInt("timer_seconds"));
            } else {
                timer = objective.getScore("Time : 0" + config.getInt("timer_minutes") + " : " + config.getInt("timer_seconds"));
            }
        } else {
            if (config.getInt("timer_seconds") < 10){
                timer = objective.getScore("Time : " + config.getInt("timer_minutes") + " : 0" + config.getInt("timer_seconds"));
            }
        }

        timer.setScore(11);

        blank.setScore(10);

        Score onlinePlayer = objective.getScore("Online players : " + config.getString("online_players"));
        onlinePlayer.setScore(9);

        blank.setScore(8);

        for (Player loopedPlayer : Bukkit.getOnlinePlayers()){
            loopedPlayer.setScoreboard(scoreboard);
        }

    }
}
