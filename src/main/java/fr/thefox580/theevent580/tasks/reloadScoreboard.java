package fr.thefox580.theevent580.tasks;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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

        for (Player loopedPlayer : Bukkit.getOnlinePlayers()){

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
                timer1 = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Event Over !");
            }

            timer1.setScore(11);

            Score timer = objective.getScore(" ");

            if (config.getBoolean("timer_mode")){
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
            } else {
                timer = objective.getScore("Timer paused");
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

            Score inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + config.getInt("dropper." + loopedPlayer.getUniqueId()));

            if (config.getBoolean("finished." + loopedPlayer.getUniqueId()) && !Objects.equals(config.getString("game_world"), "Survival Games")){
                inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Waiting for other players");
            } else {
                if (Objects.equals(config.getString("game_world"), "Parkour")) {
                    inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + config.getInt("parkour.main_level." + loopedPlayer.getUniqueId()) + " - " + config.getInt("parkour.sub_level." + loopedPlayer.getUniqueId()));
                } else if (Objects.equals(config.getString("game_world"), "Bingo")) {
                    if (loopedPlayer.getGameMode() == GameMode.SPECTATOR || loopedPlayer.isFlying()){
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total slot completed : " + ChatColor.WHITE + config.getInt("bingo_all_cases"));
                    } else {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + config.getInt("bingo_cases." + loopedPlayer.getUniqueId()) + "/9");
                    }
                } else if (Objects.equals(config.getString("game_world"), "Find The Button")) {
                    if (loopedPlayer.getGameMode() == GameMode.SPECTATOR || loopedPlayer.isFlying()) {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total buttons pressed : " + ChatColor.WHITE + config.getInt("total_buttons_pressed"));
                    } else {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Button pressed : " + ChatColor.WHITE + config.getInt("ftb_fin." + loopedPlayer.getUniqueId()) + "/11");
                    }
                } else if (Objects.equals(config.getString("game_world"), "Mulilap")) {
                    if (loopedPlayer.getGameMode() == GameMode.SPECTATOR || loopedPlayer.isFlying()) {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Current opened path : " + ChatColor.WHITE + config.getInt("race_lap"));
                    } else {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Checkpoint : " + ChatColor.WHITE + config.getInt("race_checkpoint." + loopedPlayer.getUniqueId()));
                    }
                } else if (Objects.equals(config.getString("game_world"), "Survival Games")) {
                    inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Height limit : " + ChatColor.WHITE + Math.round(config.getDouble("sg.height")));
                } else if (Objects.equals(config.getString("game_world"), "Bow PVP")) {
                    if (config.getBoolean("invincibility." + loopedPlayer.getUniqueId())) {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are invincible for : " + ChatColor.WHITE + Math.round(config.getDouble("invincibility.time_left." + loopedPlayer.getUniqueId())));
                    } else {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are not invincible");
                    }
                } else if (Objects.equals(config.getString("game_world"), "Build Masters")) {
                    if (loopedPlayer.getGameMode() == GameMode.SPECTATOR || loopedPlayer.isFlying()) {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total Completed Builds : " + ChatColor.WHITE + config.getInt("builds_total"));
                    } else {
                        inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + config.getInt("builds." + loopedPlayer.getUniqueId()) + "/10");
                    }
                } else if (Objects.equals(config.getString("game_world"), "Labyrinth")) {
                    inGameInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Actual level : " + ChatColor.WHITE + config.getInt("laby_level." + loopedPlayer.getUniqueId()) + "/10");
                }
            }

            inGameInfo.setScore(8);

            Score blank3 = objective.getScore("   ");
            blank3.setScore(7);

            Score lastMinigame = objective.getScore(ChatColor.YELLOW + "" +ChatColor.BOLD + "Last mini-game :");
            lastMinigame.setScore(6);

            textToTranslate = config.getString("last_game_color");
            Score lastMinigame2 = objective.getScore(ChatColor.translateAlternateColorCodes('&', textToTranslate) + " " + ChatColor.BOLD + config.getString("last_game"));
            lastMinigame2.setScore(5);

            Score blank4 = objective.getScore("    ");
            blank4.setScore(4);

            loopedPlayer.setScoreboard(scoreboard);
        }
    }
}
