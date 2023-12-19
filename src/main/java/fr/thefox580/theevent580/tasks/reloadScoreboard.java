package fr.thefox580.theevent580.tasks;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.Objects;

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

        Score timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Event starting soon");
        if (config.getString("timer").equals("1")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Event starting in : ");
        }
        if (config.getString("timer").equals("2") || config.getString("timer").equals("9")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Opening votes in : ");
        }
        if (config.getString("timer").equals("3")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Minigame announced in : ");
        }
        if (config.getString("timer").equals("4")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Teleportation to the minigame in : ");
        }
        if (config.getString("timer").equals("5")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Minigame starting in : ");
        }
        if (config.getString("timer").equals("6")){
            if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0){
                timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Players still alive : ");
            } else {
                if (config.getString("game_world").equals("Survival Games")){
                    timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Final battle in : ");
                } else {
                    timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Minigame ending in : ");
                }
            }
        }
        if (config.getString("timer").equals("7")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Back to hub in : ");
        }
        if (config.getString("timer").equals("8")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Intermission ends in : ");
        }
        if (config.getString("timer").equals("10")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Results in : ");
        }
        if (config.getString("timer").equals("End")){
            timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Event Over ");
        }

        timer1.setScore(11);

        Score timer = objective.getScore(" ");

        if (!Objects.equals(config.getString("timer"), "0") && !Objects.equals(config.getString("timer"), "End")){
            timer = objective.getScore(config.getInt("timer_minutes") + ":" + config.getInt("timer_seconds"));
            if (config.getString("timer").equals("6")){
                if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0){
                    timer = objective.getScore(config.getString("alive_players_sg"));
                }
            }
            if (config.getInt("timer_minutes") < 10){
                if (config.getInt("timer_seconds") < 10) {
                    timer = objective.getScore("0" + config.getInt("timer_minutes") + ":0" + config.getInt("timer_seconds"));
                } else {
                    timer = objective.getScore("0" + config.getInt("timer_minutes") + ":" + config.getInt("timer_seconds"));
                }
            } else {
                if (config.getInt("timer_seconds") < 10){
                    timer = objective.getScore(config.getInt("timer_minutes") + ":0" + config.getInt("timer_seconds"));
                }
            }
        }

        if (!Objects.equals(config.getString("timer"), "End")){
            timer.setScore(10);
        }

        Score blank1 = objective.getScore(" ");
        blank1.setScore(9);

        Score onlinePlayer = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Online players : " + ChatColor.WHITE + config.getString("online_players"));
        onlinePlayer.setScore(8);

        if (config.getInt("game_count") > 1){

            Score blank2 = objective.getScore("  ");
            blank2.setScore(7);

        }

        for (Player loopedPlayer : Bukkit.getOnlinePlayers()){
            loopedPlayer.setScoreboard(scoreboard);
        }
    }
}
