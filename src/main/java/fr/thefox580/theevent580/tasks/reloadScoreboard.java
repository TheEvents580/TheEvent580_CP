package fr.thefox580.theevent580.tasks;

import fr.thefox580.theevent580.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.Arrays;
import java.util.Objects;

public class reloadScoreboard extends BukkitRunnable {

    private final main plugin;
    private final ScoreboardManager manager = Bukkit.getScoreboardManager();
    private final Scoreboard scoreboard = manager.getNewScoreboard();
    private final Objective objective = scoreboard.registerNewObjective("title", Criteria.DUMMY, ChatColor.RED + "" + ChatColor.BOLD + "TheEvent580 | Season 1 - Episode 5");

    public reloadScoreboard(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {

        for (Player loopedPlayer : Bukkit.getOnlinePlayers()) {

            FileConfiguration config = this.plugin.getConfig();

            objective.setDisplaySlot(DisplaySlot.SIDEBAR);

            String textToTranslate = config.getString("game_color");
            String oldTextToTranslate = config.getString("last_game_color");

            scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Game " + (config.getInt("game_counter")-1) + "/6 -" + ChatColor.translateAlternateColorCodes('&', oldTextToTranslate) + " " + ChatColor.BOLD + config.getString("game_world"));
            Score gameStatus = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Game " + config.getInt("game_counter") + "/6 -" + ChatColor.translateAlternateColorCodes('&', textToTranslate) + " " + ChatColor.BOLD + config.getString("game_world"));
            gameStatus.setScore(13);

            Score blank0 = objective.getScore("");
            blank0.setScore(12);

            Score timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event starting soon");
            if (config.getString("timer").equals("1")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event starting soon");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event starting in : ");
            }
            if (config.getString("timer").equals("2") || config.getString("timer").equals("9")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event starting in : ");
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Intermission ends in : ");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Opening votes in : ");
            }
            if (config.getString("timer").equals("3")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Opening votes in : ");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame announced in : ");
            }
            if (config.getString("timer").equals("4")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame announced in : ");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Teleportation to the minigame in : ");
            }
            if (config.getString("timer").equals("5")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Teleportation to the minigame in : ");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame starting in : ");
            }
            if (config.getString("timer").equals("6")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame starting in : ");
                if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0) {
                    timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Players still alive : ");
                } else {
                    if (config.getString("game_world").equals("Survival Games")) {
                        timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Final battle in : ");
                    } else {
                        timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame ending in : ");
                    }
                }
            }
            if (config.getString("timer").equals("7")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Players still alive : ");
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Final battle in : ");
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame ending in : ");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Back to hub in : ");
            }
            if (config.getString("timer").equals("8")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Back to hub in : ");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Intermission ends in : ");
            }
            if (config.getString("timer").equals("10")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Players still alive : ");
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Final battle in : ");
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame ending in : ");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Results in : ");
            }
            if (config.getString("timer").equals("End")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Results in : ");
                timer1 = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event Over !");
            }

            timer1.setScore(11);

            scoreboard.resetScores(" ");
            Score timer = objective.getScore(" ");

            for (int timer_minute = 0; timer_minute < 31; timer_minute++){
                for (int timer_second = 0; timer_second < 61; timer_second++){
                    if (timer_minute > 10){
                        if (timer_second < 10) {
                            scoreboard.resetScores("" + timer_minute + ":0" + timer_second);
                        } else {
                            scoreboard.resetScores("" + timer_minute + ":" + timer_second);
                        }
                    } if (timer_minute < 10){
                        if (timer_second < 10){
                            scoreboard.resetScores("0"+ timer_minute + ":0" + timer_second);
                        } else {
                            scoreboard.resetScores("0"+ timer_minute + ":" + timer_second);
                        }
                    }
                }
            }

            if (config.getBoolean("timer_mode")) {
                if (!Objects.equals(config.getString("timer"), "0") && !Objects.equals(config.getString("timer"), "End")) {
                    timer = objective.getScore(config.getInt("timer_minutes") + ":" + config.getInt("timer_seconds"));
                    if (config.getString("timer").equals("6")) {
                        if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0) {
                            timer = objective.getScore(""+config.getInt("alive_players_sg"));
                        }
                    }
                    if (config.getInt("timer_minutes") < 10) {
                        if (config.getInt("timer_seconds") < 10) {
                            timer = objective.getScore("0" + config.getInt("timer_minutes") + ":0" + config.getInt("timer_seconds"));
                        } else {
                            timer = objective.getScore("0" + config.getInt("timer_minutes") + ":" + config.getInt("timer_seconds"));
                        }
                    } else {
                        if (config.getInt("timer_seconds") < 10) {
                            timer = objective.getScore(config.getInt("timer_minutes") + ":0" + config.getInt("timer_seconds"));
                        }
                    }
                }
            } else {
                timer.setScore(10);
            }

            if (!Objects.equals(config.getString("timer"), "End")) {
                timer.setScore(10);
            }

            Score blank1 = objective.getScore(" ");
            blank1.setScore(9);


            scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Online players : " + ChatColor.WHITE + (config.getInt("online_players")-1));
            scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Online players : " + ChatColor.WHITE + (config.getInt("online_players")+1));
            Score currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Online players : " + ChatColor.WHITE + config.getInt("online_players"));

            if (config.getInt("game_count") > 1) {

                Score blank2 = objective.getScore("  ");
                blank2.setScore(7);
            } else {
                scoreboard.resetScores("  ");
            }

            if (config.getBoolean("finished." + loopedPlayer.getUniqueId()) && !Objects.equals(config.getString("game_world"), "Survival Games")) {
                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Waiting for other players");
                currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Waiting for other players");
            } else {
                if (Objects.equals(config.getString("game_world"), "Dropper")) {
                    scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + (config.getInt("dropper." + loopedPlayer.getUniqueId())-1));
                    currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + config.getInt("dropper." + loopedPlayer.getUniqueId()));
                } else if (Objects.equals(config.getString("game_world"), "Parkour")) {
                    for (int mainlevel = 0; mainlevel < 4; mainlevel++){
                        for (int sublevel = 0; sublevel < 8; sublevel++){
                            if ((mainlevel != config.getInt("parkour.main_level."+loopedPlayer.getUniqueId())) && (sublevel != config.getInt("parkour.sub_level."+loopedPlayer.getUniqueId()))){
                                scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + mainlevel + " - " + sublevel);
                            }
                        }
                    }
                    currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + config.getInt("parkour.main_level." + loopedPlayer.getUniqueId()) + " - " + config.getInt("parkour.sub_level." + loopedPlayer.getUniqueId()));
                } else if (Objects.equals(config.getString("game_world"), "Bingo")) {
                    if (loopedPlayer.getGameMode() == GameMode.SPECTATOR || loopedPlayer.isFlying()) {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total slot completed : " + ChatColor.WHITE + (config.getInt("bingo_all_cases")-1));
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total slot completed : " + ChatColor.WHITE + config.getInt("bingo_all_cases"));
                    } else {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + (config.getInt("bingo_cases." + loopedPlayer.getUniqueId())-1)+ "/9");
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + config.getInt("bingo_cases." + loopedPlayer.getUniqueId()) + "/9");
                    }
                } else if (Objects.equals(config.getString("game_world"), "Find The Button")) {
                    if (loopedPlayer.getGameMode() == GameMode.SPECTATOR || loopedPlayer.isFlying()) {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total buttons pressed : " + ChatColor.WHITE + (config.getInt("total_buttons_pressed")-1));
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total buttons pressed : " + ChatColor.WHITE + config.getInt("total_buttons_pressed"));
                    } else {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Button pressed : " + ChatColor.WHITE + (config.getInt("ftb_fin." + loopedPlayer.getUniqueId())-1)+ "/11");
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Button pressed : " + ChatColor.WHITE + config.getInt("ftb_fin." + loopedPlayer.getUniqueId()) + "/11");
                    }
                } else if (Objects.equals(config.getString("game_world"), "Mulilap")) {
                    if (loopedPlayer.getGameMode() == GameMode.SPECTATOR || loopedPlayer.isFlying()) {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Current opened path : " + ChatColor.WHITE + (config.getInt("race_lap")-1));
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Current opened path : " + ChatColor.WHITE + config.getInt("race_lap"));
                    } else {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Checkpoint : " + ChatColor.WHITE + (config.getInt("race_checkpoint." + loopedPlayer.getUniqueId())-1));
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Checkpoint : " + ChatColor.WHITE + 2);
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Checkpoint : " + ChatColor.WHITE + 3);
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Checkpoint : " + ChatColor.WHITE + config.getInt("race_checkpoint." + loopedPlayer.getUniqueId()));
                    }
                } else if (Objects.equals(config.getString("game_world"), "Survival Games")) {
                    scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Height limit : " + ChatColor.WHITE + Math.round(config.getDouble("sg.height_old")));
                    currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Height limit : " + ChatColor.WHITE + Math.round(config.getDouble("sg.height")));
                } else if (Objects.equals(config.getString("game_world"), "Bow PVP")) {
                    if (config.getBoolean("invincibility." + loopedPlayer.getUniqueId())) {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are invincible for : " + ChatColor.WHITE + (Math.round(config.getDouble("invincibility.time_left." + loopedPlayer.getUniqueId()))-1));
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are invincible for : " + ChatColor.WHITE + Math.round(config.getDouble("invincibility.time_left." + loopedPlayer.getUniqueId())));
                    } else {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are not invincible");
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are not invincible");
                    }
                } else if (Objects.equals(config.getString("game_world"), "Build Masters")) {
                    if (loopedPlayer.getGameMode() == GameMode.SPECTATOR || loopedPlayer.isFlying()) {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total Completed Builds : " + ChatColor.WHITE + (config.getInt("builds_total")-1));
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total Completed Builds : " + ChatColor.WHITE + config.getInt("builds_total"));
                    } else {
                        scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + (config.getInt("builds." + loopedPlayer.getUniqueId())-1) + "/10");
                        currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + config.getInt("builds." + loopedPlayer.getUniqueId()) + "/10");
                    }
                } else if (Objects.equals(config.getString("game_world"), "Labyrinth")) {
                    scoreboard.resetScores(ChatColor.YELLOW + "" + ChatColor.BOLD + "Actual level : " + ChatColor.WHITE + (config.getInt("laby_level." + loopedPlayer.getUniqueId())-1));
                    currentInfo = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Actual level : " + ChatColor.WHITE + config.getInt("laby_level." + loopedPlayer.getUniqueId()));
                }
            }

            currentInfo.setScore(8);

            Score blank3 = objective.getScore("   ");
            blank3.setScore(7);

            Score lastMinigame = objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "Last mini-game :");
            lastMinigame.setScore(6);

            oldTextToTranslate = config.getString("old_last_game_color");
            scoreboard.resetScores(ChatColor.translateAlternateColorCodes('&', oldTextToTranslate) + "" + ChatColor.BOLD + config.getString("old_last_game"));
            textToTranslate = config.getString("last_game_color");
            Score lastMinigame2 = objective.getScore(ChatColor.translateAlternateColorCodes('&', textToTranslate) + "" + ChatColor.BOLD + config.getString("last_game"));
            lastMinigame2.setScore(5);

            Score blank4 = objective.getScore("    ");
            blank4.setScore(4);

            scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("old_points." + loopedPlayer.getUniqueId()));
            scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your All Time " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("old_total_points." + loopedPlayer.getUniqueId()));

            Score points = objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("points." + loopedPlayer.getUniqueId()));
            Score allTimePoints = objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your All Time " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("total_points." + loopedPlayer.getUniqueId()));

            if (!Arrays.asList("5", "6", "7", "10").contains(config.getString("timer"))) {
                if (config.getBoolean("scoreboard.pos")) {
                    points = objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("points." + loopedPlayer.getUniqueId()) + config.getString("pos." + loopedPlayer.getUniqueId()));
                }
                scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("game_points." + loopedPlayer.getUniqueId()));
                scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("game_points." + loopedPlayer.getUniqueId()) * config.getInt("multiplier_game." + loopedPlayer.getUniqueId())) + "(" + config.getInt("game_points." + loopedPlayer.getUniqueId()) + " ║ " + config.getInt("multiplier_game." + loopedPlayer.getUniqueId()) + ')');
                scoreboard.resetScores("     ");
                points.setScore(3);
                allTimePoints.setScore(2);
            } else {
                scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("points." + loopedPlayer.getUniqueId()));
                scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your All Time " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("total_points." + loopedPlayer.getUniqueId()));
                if (Objects.equals(config.getString("game_world"), "Parkour")) {
                    scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("old_game_points." + loopedPlayer.getUniqueId()));
                    scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("old_game_points." + loopedPlayer.getUniqueId()) * config.getInt("multiplier_game." + loopedPlayer.getUniqueId())) + " (" + config.getInt("old_game_points." + loopedPlayer.getUniqueId()) + " ║ " + config.getInt("multiplier_game." + loopedPlayer.getUniqueId()) + ')');
                    scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("old_game_points." + loopedPlayer.getUniqueId()) * config.getInt("multiplier_game." + loopedPlayer.getUniqueId())) + " (" + config.getInt("game_points." + loopedPlayer.getUniqueId()) + " ║ " + config.getInt("old_multiplier_game." + loopedPlayer.getUniqueId()) + ')');
                    scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("old_game_points." + loopedPlayer.getUniqueId()) * config.getInt("multiplier_game." + loopedPlayer.getUniqueId())) + " (" + config.getInt("old_game_points." + loopedPlayer.getUniqueId()) + " ║ " + config.getInt("old_multiplier_game." + loopedPlayer.getUniqueId()) + ')');
                    points = objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("game_points." + loopedPlayer.getUniqueId()) * config.getInt("multiplier_game." + loopedPlayer.getUniqueId())) + "(" + config.getInt("game_points." + loopedPlayer.getUniqueId()) + " ║ " + config.getInt("multiplier_game." + loopedPlayer.getUniqueId()) + ')');
                } else {
                    scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("old_game_points." + loopedPlayer.getUniqueId()));
                    scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("old_game_points." + loopedPlayer.getUniqueId()) * config.getInt("multiplier_game." + loopedPlayer.getUniqueId())) + " (" + config.getInt("old_game_points." + loopedPlayer.getUniqueId()) + " ║ " + config.getInt("multiplier_game." + loopedPlayer.getUniqueId()) + ')');
                    scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("old_game_points." + loopedPlayer.getUniqueId()) * config.getInt("multiplier_game." + loopedPlayer.getUniqueId())) + " (" + config.getInt("game_points." + loopedPlayer.getUniqueId()) + " ║ " + config.getInt("old_multiplier_game." + loopedPlayer.getUniqueId()) + ')');
                    scoreboard.resetScores(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("old_game_points." + loopedPlayer.getUniqueId()) * config.getInt("multiplier_game." + loopedPlayer.getUniqueId())) + " (" + config.getInt("old_game_points." + loopedPlayer.getUniqueId()) + " ║ " + config.getInt("old_multiplier_game." + loopedPlayer.getUniqueId()) + ')');
                    points = objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("game_points." + loopedPlayer.getUniqueId()));

                }
                points.setScore(3);
            }

            loopedPlayer.setScoreboard(scoreboard);

        }
    }
}
