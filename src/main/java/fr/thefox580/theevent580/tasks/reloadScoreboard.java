package fr.thefox580.theevent580.tasks;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

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

        Objective objective = scoreboard.registerNewObjective("title", Criteria.DUMMY, ChatColor.RED + "" + ChatColor.BOLD +"TheEvent580 | Season 1 - Episode 5");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        String textToTranslate = config.getString("game_color");

        Score gameStatus = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Game " + config.getInt("game_counter") + "/6 -" + ChatColor.translateAlternateColorCodes('&', textToTranslate) + " " + ChatColor.BOLD + config.getString("game_world"));
        gameStatus.setScore(13);

        Score blank0 = objective.getScore("");
        blank0.setScore(12);

        Score timer = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Time : " + config.getInt("timer_minutes") + ":" + config.getInt("timer_seconds"));
        if (config.getInt("timer_minutes") < 10){
            if (config.getInt("timer_seconds") < 10) {
                timer = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Time : 0" + config.getInt("timer_minutes") + ":0" + config.getInt("timer_seconds"));
            } else {
                timer = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Time : 0" + config.getInt("timer_minutes") + ":" + config.getInt("timer_seconds"));
            }
        } else {
            if (config.getInt("timer_seconds") < 10){
                timer = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Time : " + config.getInt("timer_minutes") + ":0" + config.getInt("timer_seconds"));
            }
        }

        timer.setScore(11);

        Score blank1 = objective.getScore(" ");
        blank1.setScore(10);

        Score onlinePlayer = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Online players : " + config.getString("online_players"));
        onlinePlayer.setScore(9);

        Score blank2 = objective.getScore("  ");
        blank2.setScore(8);

        for (Player loopedPlayer : Bukkit.getOnlinePlayers()){
            loopedPlayer.setScoreboard(scoreboard);
        }

    }
}
