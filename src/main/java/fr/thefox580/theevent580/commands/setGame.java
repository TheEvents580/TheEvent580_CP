package fr.thefox580.theevent580.commands;

import fr.thefox580.theevent580.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class setGame implements CommandExecutor {

    private final main plugin;

    public setGame(main plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        FileConfiguration config = plugin.getConfig();

        String lastGame = config.getString("last_game");
        String lastGameColor = config.getString("last_game_color");

        config.set("old_last_game", lastGame);
        config.set("old_last_game_color", lastGameColor);

        String currentGame = config.getString("game_world");
        String currentGameColor = config.getString("game_color");

        if (!Objects.equals(currentGame, "Hub")){

            config.set("last_game", currentGame);
            config.set("last_game_color", currentGameColor);
        }

        String nextGame = "";
        String nextGameColor = "";

        if (Integer.parseInt(strings[0]) == 0) {
            nextGame = "Hub";
            nextGameColor = "&f";
        } else if (Integer.parseInt(strings[0]) == 1) {
            nextGame = "Dropper";
            nextGameColor = "&c";
        } else if (Integer.parseInt(strings[0]) == 2) {
            nextGame = "Parkour";
            nextGameColor = "&6";
        } else if (Integer.parseInt(strings[0]) == 3) {
            nextGame = "Bingo";
            nextGameColor = "&e";
        } else if (Integer.parseInt(strings[0]) == 4) {
            nextGame = "Find The Button";
            nextGameColor = "&a";
        } else if (Integer.parseInt(strings[0]) == 5) {
            nextGame = "Multilap";
            nextGameColor = "&b";
        } else if (Integer.parseInt(strings[0]) == 6) {
            nextGame = "Build Masters";
            nextGameColor = "&1";
        } else if (Integer.parseInt(strings[0]) == 7) {
            nextGame = "Survival Games";
            nextGameColor = "&5";
        } else if (Integer.parseInt(strings[0]) == 8) {
            nextGame = "Bow PVP";
            nextGameColor = "&d";
        }

        config.set("game_world", nextGame);
        config.set("game_world_color", nextGameColor);

        return true;
    }
}
