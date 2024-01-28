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

    public reloadScoreboard(main plugin) {
        this.plugin = plugin;
    }

    public void setSB(Player player){

        FileConfiguration config = this.plugin.getConfig();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("title", Criteria.DUMMY, ChatColor.RED + "" + ChatColor.BOLD + "TheEvent580 | Season 1 - Episode 5");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        String textToTranslate = config.getString("game_color");
        String oldTextToTranslate = config.getString("last_game_color");


        Team gameStatusTeam = scoreboard.getTeam("gameStatus");

        if (gameStatusTeam == null){
            gameStatusTeam = scoreboard.registerNewTeam("gameStatus");
        }
        gameStatusTeam.setPrefix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Game " + config.getInt("game_counter"));
        gameStatusTeam.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD +"/6 -");
        gameStatusTeam.setSuffix(ChatColor.translateAlternateColorCodes('&', textToTranslate) + " " + ChatColor.BOLD + config.getString("game_world"));

        objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD +"/6 -").setScore(13);

        objective.getScore("").setScore(12);

        Team timer1Team = scoreboard.getTeam("timer1");

        if (timer1Team == null){
            timer1Team = scoreboard.registerNewTeam("timer1");
        }

        timer1Team.addEntry(ChatColor.YELLOW + "");
        timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event starting soon");

        if (config.getString("timer").equals("1")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event starting in : ");
        }
        if (config.getString("timer").equals("2") || config.getString("timer").equals("9")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Opening votes in : ");
        }
        if (config.getString("timer").equals("3")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame announced in : ");
        }
        if (config.getString("timer").equals("4")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Teleportation to the minigame in : ");
        }
        if (config.getString("timer").equals("5")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame starting in : ");
        }
        if (config.getString("timer").equals("6")) {
            if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0) {
                timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Players still alive : ");
            } else {
                if (config.getString("game_world").equals("Survival Games")) {
                    timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Final battle in : ");
                } else {
                    timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame ending in : ");
                }
            }
        }
        if (config.getString("timer").equals("7")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Back to hub in : ");
        }
        if (config.getString("timer").equals("8")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Intermission ends in : ");
        }
        if (config.getString("timer").equals("10")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Results in : ");
        }
        if (config.getString("timer").equals("End")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event Over !");
        }

        objective.getScore(ChatColor.YELLOW + "").setScore(11);

        Team timerTeam = scoreboard.getTeam("timer");

        if (timerTeam == null){
            timerTeam = scoreboard.registerNewTeam("timer");
        }

        timerTeam.setPrefix(""+config.getInt("timer_minutes"));
        timerTeam.addEntry(":");
        timerTeam.setSuffix(""+config.getInt("timer_seconds"));

        if (config.getBoolean("timer_mode")) {
            if (!Objects.equals(config.getString("timer"), "0") && !Objects.equals(config.getString("timer"), "End")) {
                if (config.getString("timer").equals("6")) {
                    if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0) {
                        timerTeam.setPrefix("");
                        timerTeam.setSuffix(" "+config.getInt("alive_players_sg"));
                    }
                }
                if (config.getInt("timer_minutes") < 10) {
                    if (config.getInt("timer_seconds") < 10) {
                        timerTeam.setPrefix("0" + config.getInt("timer_minutes"));
                        timerTeam.setSuffix("0" + config.getInt("timer_seconds"));
                    } else {
                        timerTeam.setPrefix("0" + config.getInt("timer_minutes"));
                    }
                } else {
                    if (config.getInt("timer_seconds") < 10) {
                        timerTeam.setSuffix("0" + config.getInt("timer_seconds"));
                    }
                }
            }
        } else {
            timerTeam.setPrefix("Timer");
            timerTeam.setSuffix("Paused");
        }

        if (!Objects.equals(config.getString("timer"), "End")) {
            objective.getScore(":").setScore(10);
        }

        objective.getScore(" ").setScore(9);

        Team currentInfoTeam = scoreboard.getTeam("currentInfo");

        if (currentInfoTeam == null){
            currentInfoTeam = scoreboard.registerNewTeam("currentInfo");
        }

        currentInfoTeam.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD);
        currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Online players : " + ChatColor.WHITE + config.getInt("online_players"));

        if (config.getBoolean("finished." + player.getUniqueId()) && !Objects.equals(config.getString("game_world"), "Survival Games")) {

            currentInfoTeam.setSuffix("Waiting for other players");
        } else {
            if (Objects.equals(config.getString("game_world"), "Dropper")) {
                currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + config.getInt("dropper." + player.getUniqueId()));
            } else if (Objects.equals(config.getString("game_world"), "Parkour")) {
                currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + config.getInt("parkour.main_level." + player.getUniqueId()) + " - " + config.getInt("parkour.sub_level." + player.getUniqueId()));
            } else if (Objects.equals(config.getString("game_world"), "Bingo")) {
                if (player.getGameMode() == GameMode.SPECTATOR || player.isFlying()) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total slot completed : " + ChatColor.WHITE + config.getInt("bingo_all_cases"));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + config.getInt("bingo_cases." + player.getUniqueId()) + "/9");
                }
            } else if (Objects.equals(config.getString("game_world"), "Find The Button")) {
                if (player.getGameMode() == GameMode.SPECTATOR || player.isFlying()) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total buttons pressed : " + ChatColor.WHITE + config.getInt("total_buttons_pressed"));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Button pressed : " + ChatColor.WHITE + config.getInt("ftb_fin." + player.getUniqueId()) + "/11");
                }
            } else if (Objects.equals(config.getString("game_world"), "Mulilap")) {
                if (player.getGameMode() == GameMode.SPECTATOR || player.isFlying()) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Current opened path : " + ChatColor.WHITE + config.getInt("race_lap"));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Checkpoint : " + ChatColor.WHITE + config.getInt("race_checkpoint." + player.getUniqueId()));
                }
            } else if (Objects.equals(config.getString("game_world"), "Survival Games")) {
                currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Height limit : " + ChatColor.WHITE + Math.round(config.getDouble("sg.height")));
            } else if (Objects.equals(config.getString("game_world"), "Bow PVP")) {
                if (config.getBoolean("invincibility." + player.getUniqueId())) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are invincible for : " + ChatColor.WHITE + Math.round(config.getDouble("invincibility.time_left." + player.getUniqueId())));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are not invincible");
                }
            } else if (Objects.equals(config.getString("game_world"), "Build Masters")) {
                if (player.getGameMode() == GameMode.SPECTATOR || player.isFlying()) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total Completed Builds : " + ChatColor.WHITE + config.getInt("builds_total"));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + config.getInt("builds." + player.getUniqueId()) + "/10");
                }
            } else if (Objects.equals(config.getString("game_world"), "Labyrinth")) {
                currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Actual level : " + ChatColor.WHITE + config.getInt("laby_level." + player.getUniqueId()));
            }
        }

        objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD).setScore(8);

        objective.getScore("   ").setScore(7);

        Team lastMinigameTeam = scoreboard.getTeam("lastMinigame");

        if (lastMinigameTeam == null){
            lastMinigameTeam = scoreboard.registerNewTeam("lastMinigame");
        }

        lastMinigameTeam.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD + " ");
        lastMinigameTeam.setPrefix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Last mini-game : ");

        objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + " ").setScore(6);

        oldTextToTranslate = config.getString("old_last_game_color");
        textToTranslate = config.getString("last_game_color");

        Team lastMinigame2Team = scoreboard.getTeam("lastMinigame2");

        if (lastMinigame2Team == null){
            lastMinigame2Team = scoreboard.registerNewTeam("lastMinigame2");
        }

        lastMinigame2Team.addEntry(ChatColor.translateAlternateColorCodes('&', textToTranslate) + "" + ChatColor.BOLD);
        lastMinigame2Team.setSuffix(ChatColor.translateAlternateColorCodes('&', textToTranslate) + "" + ChatColor.BOLD + config.getString("last_game"));

        objective.getScore(ChatColor.translateAlternateColorCodes('&', textToTranslate) + "" + ChatColor.BOLD).setScore(5);

        objective.getScore("    ").setScore(4);

        Team pointsTeam = scoreboard.getTeam("points");

        if (pointsTeam == null){
            pointsTeam = scoreboard.registerNewTeam("points");
        }

        pointsTeam.addEntry(ChatColor.GREEN + "" + ChatColor.BOLD + "Your ");
        pointsTeam.setSuffix("╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("points." + player.getUniqueId()));

        Team allTimePointsTeam = scoreboard.getTeam("allTimePoints");

        if (allTimePointsTeam == null){
            allTimePointsTeam = scoreboard.registerNewTeam("allTimePoints");
        }

        allTimePointsTeam.addEntry(ChatColor.GREEN + "" + ChatColor.BOLD + "Your All Time " + ChatColor.RESET + "╣");
        allTimePointsTeam.setSuffix(ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("total_points." + player.getUniqueId()));

        if (!Arrays.asList("5", "6", "7", "10").contains(config.getString("timer"))) {
            if (config.getBoolean("scoreboard.pos")) {
                pointsTeam.setSuffix("╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("points." + player.getUniqueId()) + config.getString("pos." + player.getUniqueId()));
            }
            objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your ").setScore(3);
            objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your All Time " + ChatColor.RESET + "╣").setScore(2);
        } else {
            if (Objects.equals(config.getString("game_world"), "Parkour")) {
                pointsTeam.setSuffix(ChatColor.GREEN + "" + ChatColor.BOLD + "In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("game_points." + player.getUniqueId()) * config.getInt("multiplier_game." + player.getUniqueId())) + "(" + config.getInt("game_points." + player.getUniqueId()) + " ║ " + config.getInt("multiplier_game." + player.getUniqueId()) + ')');
            } else {
                pointsTeam.setSuffix(ChatColor.GREEN + "" + ChatColor.BOLD + "In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("game_points." + player.getUniqueId()));
            }
            objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your ").setScore(3);
        }

        player.setScoreboard(scoreboard);
        
    }

    public void updateSB(Player player){

        FileConfiguration config = this.plugin.getConfig();

        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.getObjective("title");

        String textToTranslate = config.getString("game_color");
        String oldTextToTranslate = config.getString("last_game_color");


        Team gameStatusTeam = scoreboard.getTeam("gameStatus");

        if (gameStatusTeam == null){
            scoreboard.registerNewTeam("gameStatus");
        }
        gameStatusTeam.setPrefix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Game " + config.getInt("game_counter"));
        gameStatusTeam.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD +"/6 -");
        gameStatusTeam.setSuffix(ChatColor.translateAlternateColorCodes('&', textToTranslate) + " " + ChatColor.BOLD + config.getString("game_world"));

        objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD +"/6 -").setScore(13);

        objective.getScore("").setScore(12);

        Team timer1Team = scoreboard.getTeam("timer1");

        if (timer1Team == null){
            scoreboard.registerNewTeam("timer1");
        }

        timer1Team.addEntry(ChatColor.YELLOW + "");
        timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event starting soon");

        if (config.getString("timer").equals("1")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event starting in : ");
        }
        if (config.getString("timer").equals("2") || config.getString("timer").equals("9")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Opening votes in : ");
        }
        if (config.getString("timer").equals("3")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame announced in : ");
        }
        if (config.getString("timer").equals("4")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Teleportation to the minigame in : ");
        }
        if (config.getString("timer").equals("5")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame starting in : ");
        }
        if (config.getString("timer").equals("6")) {
            if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0) {
                timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Players still alive : ");
            } else {
                if (config.getString("game_world").equals("Survival Games")) {
                    timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Final battle in : ");
                } else {
                    timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Minigame ending in : ");
                }
            }
        }
        if (config.getString("timer").equals("7")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Back to hub in : ");
        }
        if (config.getString("timer").equals("8")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Intermission ends in : ");
        }
        if (config.getString("timer").equals("10")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Results in : ");
        }
        if (config.getString("timer").equals("End")) {
            timer1Team.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Event Over !");
        }

        objective.getScore(ChatColor.YELLOW + "").setScore(11);

        Team timerTeam = scoreboard.getTeam("timer");

        if (timerTeam == null){
            scoreboard.registerNewTeam("timer");
        }

        timerTeam.setPrefix(""+config.getInt("timer_minutes"));
        timerTeam.addEntry(":");
        timerTeam.setSuffix(""+config.getInt("timer_seconds"));

        if (config.getBoolean("timer_mode")) {
            if (!Objects.equals(config.getString("timer"), "0") && !Objects.equals(config.getString("timer"), "End")) {
                if (config.getString("timer").equals("6")) {
                    if (config.getInt("timer_seconds") == 0 && config.getInt("timer_minutes") == 0) {
                        timerTeam.setPrefix("");
                        timerTeam.setSuffix(" "+config.getInt("alive_players_sg"));
                    }
                }
                if (config.getInt("timer_minutes") < 10) {
                    if (config.getInt("timer_seconds") < 10) {
                        timerTeam.setPrefix("0" + config.getInt("timer_minutes"));
                        timerTeam.setSuffix("0" + config.getInt("timer_seconds"));
                    } else {
                        timerTeam.setPrefix("0" + config.getInt("timer_minutes"));
                    }
                } else {
                    if (config.getInt("timer_seconds") < 10) {
                        timerTeam.setSuffix("0" + config.getInt("timer_seconds"));
                    }
                }
            }
        } else {
            timerTeam.setPrefix("Timer");
            timerTeam.setSuffix("Paused");
        }

        if (!Objects.equals(config.getString("timer"), "End")) {
            objective.getScore(":").setScore(10);
        }

        objective.getScore(" ").setScore(9);

        Team currentInfoTeam = scoreboard.getTeam("currentInfo");

        if (currentInfoTeam == null){
            scoreboard.registerNewTeam("currentInfo");
        }

        currentInfoTeam.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD);
        currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Online players : " + ChatColor.WHITE + config.getInt("online_players"));

        if (config.getBoolean("finished." + player.getUniqueId()) && !Objects.equals(config.getString("game_world"), "Survival Games")) {

            currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Waiting for other players");
        } else {
            if (Objects.equals(config.getString("game_world"), "Dropper")) {
                currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + config.getInt("dropper." + player.getUniqueId()));
            } else if (Objects.equals(config.getString("game_world"), "Parkour")) {
                currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Level : " + ChatColor.WHITE + config.getInt("parkour.main_level." + player.getUniqueId()) + " - " + config.getInt("parkour.sub_level." + player.getUniqueId()));
            } else if (Objects.equals(config.getString("game_world"), "Bingo")) {
                if (player.getGameMode() == GameMode.SPECTATOR || player.isFlying()) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total slot completed : " + ChatColor.WHITE + config.getInt("bingo_all_cases"));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + config.getInt("bingo_cases." + player.getUniqueId()) + "/9");
                }
            } else if (Objects.equals(config.getString("game_world"), "Find The Button")) {
                if (player.getGameMode() == GameMode.SPECTATOR || player.isFlying()) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total buttons pressed : " + ChatColor.WHITE + config.getInt("total_buttons_pressed"));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Button pressed : " + ChatColor.WHITE + config.getInt("ftb_fin." + player.getUniqueId()) + "/11");
                }
            } else if (Objects.equals(config.getString("game_world"), "Mulilap")) {
                if (player.getGameMode() == GameMode.SPECTATOR || player.isFlying()) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Current opened path : " + ChatColor.WHITE + config.getInt("race_lap"));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Checkpoint : " + ChatColor.WHITE + config.getInt("race_checkpoint." + player.getUniqueId()));
                }
            } else if (Objects.equals(config.getString("game_world"), "Survival Games")) {
                currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Height limit : " + ChatColor.WHITE + Math.round(config.getDouble("sg.height")));
            } else if (Objects.equals(config.getString("game_world"), "Bow PVP")) {
                if (config.getBoolean("invincibility." + player.getUniqueId())) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are invincible for : " + ChatColor.WHITE + Math.round(config.getDouble("invincibility.time_left." + player.getUniqueId())));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "You are not invincible");
                }
            } else if (Objects.equals(config.getString("game_world"), "Build Masters")) {
                if (player.getGameMode() == GameMode.SPECTATOR || player.isFlying()) {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Total Completed Builds : " + ChatColor.WHITE + config.getInt("builds_total"));
                } else {
                    currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Completed : " + ChatColor.WHITE + config.getInt("builds." + player.getUniqueId()) + "/10");
                }
            } else if (Objects.equals(config.getString("game_world"), "Labyrinth")) {
                currentInfoTeam.setSuffix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Actual level : " + ChatColor.WHITE + config.getInt("laby_level." + player.getUniqueId()));
            }
        }

        objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD).setScore(8);

        objective.getScore("   ").setScore(7);

        Team lastMinigameTeam = scoreboard.getTeam("lastMinigame");

        if (lastMinigameTeam == null){
            scoreboard.registerNewTeam("lastMinigame");
        }

        lastMinigameTeam.addEntry(ChatColor.YELLOW + "" + ChatColor.BOLD + " ");
        lastMinigameTeam.setPrefix(ChatColor.YELLOW + "" + ChatColor.BOLD + "Last mini-game : ");

        objective.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + " ").setScore(6);

        oldTextToTranslate = config.getString("old_last_game_color");
        textToTranslate = config.getString("last_game_color");

        Team lastMinigame2Team = scoreboard.getTeam("lastMinigame2");

        if (lastMinigame2Team == null){
            scoreboard.registerNewTeam("lastMinigame2");
        }

        lastMinigame2Team.addEntry(ChatColor.translateAlternateColorCodes('&', textToTranslate) + "" + ChatColor.BOLD);
        lastMinigame2Team.setSuffix(ChatColor.translateAlternateColorCodes('&', textToTranslate) + "" + ChatColor.BOLD + config.getString("last_game"));

        objective.getScore(ChatColor.translateAlternateColorCodes('&', textToTranslate) + "" + ChatColor.BOLD).setScore(5);

        objective.getScore("    ").setScore(4);

        Team pointsTeam = scoreboard.getTeam("points");

        if (pointsTeam == null){
            scoreboard.registerNewTeam("points");
        }

        pointsTeam.addEntry(ChatColor.GREEN + "" + ChatColor.BOLD + "Your ");
        pointsTeam.setSuffix("╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("points." + player.getUniqueId()));

        Team allTimePointsTeam = scoreboard.getTeam("allTimePoints");

        if (allTimePointsTeam == null){
            scoreboard.registerNewTeam("allTimePoints");
        }

        allTimePointsTeam.addEntry(ChatColor.GREEN + "" + ChatColor.BOLD + "Your All Time " + ChatColor.RESET + "╣");
        allTimePointsTeam.setSuffix(ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("total_points." + player.getUniqueId()));

        if (!Arrays.asList("5", "6", "7", "10").contains(config.getString("timer"))) {
            if (config.getBoolean("scoreboard.pos")) {
                pointsTeam.setSuffix("╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("points." + player.getUniqueId()) + config.getString("pos." + player.getUniqueId()));
            }
            objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your ").setScore(3);
            objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your All Time " + ChatColor.RESET + "╣").setScore(2);
        } else {
            if (Objects.equals(config.getString("game_world"), "Parkour")) {
                pointsTeam.setSuffix(ChatColor.GREEN + "" + ChatColor.BOLD + "In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + (config.getInt("game_points." + player.getUniqueId()) * config.getInt("multiplier_game." + player.getUniqueId())) + "(" + config.getInt("game_points." + player.getUniqueId()) + " ║ " + config.getInt("multiplier_game." + player.getUniqueId()) + ')');
            } else {
                pointsTeam.setSuffix(ChatColor.GREEN + "" + ChatColor.BOLD + "In-Game " + ChatColor.RESET + "╣" + ChatColor.GREEN + "" + ChatColor.BOLD + " : " + ChatColor.RESET + config.getInt("game_points." + player.getUniqueId()));
            }
            objective.getScore(ChatColor.GREEN + "" + ChatColor.BOLD + "Your ").setScore(3);
        }
    }

    @Override
    public void run() {

        for (Player loopedPlayer : Bukkit.getOnlinePlayers()) {

            updateSB(loopedPlayer);

        }
    }
}
